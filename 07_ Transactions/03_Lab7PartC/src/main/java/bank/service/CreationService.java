package bank.service;

import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreationService {
    @Autowired
    private EmailSender emailSender;
    @Autowired
    BankService bankService;

    @Autowired
    TraceRecordRepository traceRecordRepository;

    public void sendEmail(String emailAddress, String message, String customerName){
        emailSender.sendEmail(emailAddress, message + " " + customerName);
    }


    public void createCustomerAndAccountAndLog(int customerId, String customerName, String emailAddress, String AccountNumber) {
        try{
            bankService.createCustomerAndAccount(customerId, customerName, AccountNumber);
            traceRecordRepository.saveCustomer(new TraceRecord(new Date(), "Customer "+customerName+"created with account" + AccountNumber));
        }catch (Exception e){
            sendEmail(emailAddress, "We could not create your account", customerName);
            traceRecordRepository.saveCustomer(new TraceRecord(new Date(), "Could not create Customer "+customerName+"created with account" + AccountNumber));
        }
    }
}
