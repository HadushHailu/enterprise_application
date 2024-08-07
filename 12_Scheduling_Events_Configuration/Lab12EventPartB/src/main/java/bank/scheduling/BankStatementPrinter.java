package bank.scheduling;

import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
@EnableScheduling
public class BankStatementPrinter {

    @Autowired
    private IAccountDAO iAccountDAO;

    @Transactional
    @Scheduled(fixedRate = 20000)
    public void printAllAccountDetails(){
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currenttime = timeFormatter.format(date);

        System.out.println("[+] Scheduler called at: " + currenttime);
        for(Account account: iAccountDAO.findAll()){
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println(
                    "-Date-------------------------" + "-Description------------------" + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
                        entry.getAmount());
            }
            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }


    }
}
