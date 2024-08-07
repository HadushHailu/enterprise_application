package bank.service;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.jms.IJMSSender;
import bank.logging.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Service
public class AccountService implements IAccountService {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender texServiceJmsSender;
	@Autowired
	private ILogger logger;


    @Transactional
	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.save(account);
		logger.log("createAccount with parameters accountNumber= "
				+ accountNumber + " , customerName= " + customerName);
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	@Transactional
	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		account.deposit(amount);
		accountDAO.save(account);
		logger.log("deposit with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
		if (amount > 10000) {
			texServiceJmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
		applicationEventPublisher.publishEvent(new CustomerEvent("[*] [!] " + amount+" has been deposited from your account!"));
		applicationEventPublisher.publishEvent(new TraceRecord(LocalDateTime.now(), accountNumber, "Deposit", amount));
	}
	@Transactional
	public AccountDTO getAccount(long accountNumber) {
		Account account = accountDAO.findById(accountNumber).get();
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	@Transactional
	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accountList = accountDAO.findAll();
		return AccountAdapter.getAccountDTOListFromAccountList(accountList);
	}

	@Transactional
	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		account.withdraw(amount);
		accountDAO.save(account);
		logger.log("withdraw with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
		applicationEventPublisher.publishEvent(new CustomerEvent("[*] [!] " + amount+" has been withdrawn from your account!"));
		applicationEventPublisher.publishEvent(new TraceRecord(LocalDateTime.now(), accountNumber, "Withdraw", amount));
	}

	@Transactional
	public void depositEuros(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.save(account);
		logger.log("depositEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
		if (amountDollars > 10000) {
			texServiceJmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
		applicationEventPublisher.publishEvent(new CustomerEvent("[*] [!] " + amount+" Euros has been deposited to your account!"));
		applicationEventPublisher.publishEvent(new TraceRecord(LocalDateTime.now(), accountNumber, "Deposit", amountDollars));
	}
	@Transactional
	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountDAO.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.save(account);
		logger.log("withdrawEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
		applicationEventPublisher.publishEvent(new CustomerEvent("[*] [!] " + amount+" Euros has been withdrawn from your account!"));
		applicationEventPublisher.publishEvent(new TraceRecord(LocalDateTime.now(), accountNumber, "Withdraw", amountDollars));
	}
	@Transactional
	public void transferFunds(long fromAccountNumber, long toAccountNumber,
							  double amount, String description) {
		Account fromAccount = accountDAO.findById(fromAccountNumber).get();
		Account toAccount = accountDAO.findById(toAccountNumber).get();
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.save(fromAccount);
		accountDAO.save(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= "
				+ fromAccountNumber + " , toAccountNumber= " + toAccountNumber
				+ " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			texServiceJmsSender.sendJMSMessage("TransferFunds of $ " + amount
					+ " from account with accountNumber= " + fromAccount
					+ " to account with accountNumber= " + toAccount);
		}
		applicationEventPublisher.publishEvent(new CustomerEvent("[*] [!] " + amount+" has been transfered to " + toAccountNumber));
		applicationEventPublisher.publishEvent(new TraceRecord(LocalDateTime.now(), fromAccountNumber, toAccountNumber, "Transfer", amount));
	}
}
