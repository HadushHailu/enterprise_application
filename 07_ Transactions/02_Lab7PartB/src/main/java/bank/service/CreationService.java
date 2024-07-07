package bank.service;

import bank.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationService {
    @Autowired
    private EmailSender emailSender;
    @Autowired
    BankService bankService;

    public void sendEmail(String emailAddress, String message, String customerName){
        emailSender.sendEmail(emailAddress, message + " " + customerName);
    }


    public void createCustomerAndAccountAndLog(int customerId, String customerName, String emailAddress, String AccountNumber) {
        try{
            bankService.createCustomerAndAccount(customerId, customerName, AccountNumber);
            sendEmail(emailAddress, "Welcome", customerName);
        }catch (Exception e){
            sendEmail(emailAddress, "“We could not create your account ", customerName);
        }
    }
}
