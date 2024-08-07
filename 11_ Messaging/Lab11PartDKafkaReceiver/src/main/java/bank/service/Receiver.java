package bank.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Service
public class Receiver {
    @Autowired
    AccountService accountService;

    @KafkaListener(topics = {"bank-create-account"}, groupId = "gid1")
    public void receive1(@Payload String message) {
        System.out.println("[+] === Topic: bank-create-account, Receiver: receive-1 === " + LocalDate.now());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CreateAccountMessage createAccountMessage = objectMapper.readValue(message, CreateAccountMessage.class);
            accountService.createAccount(createAccountMessage.getAccountNumber(), createAccountMessage.getCustomerName());

        } catch (IOException e) {
            System.out.println("Kafka receiver: Cannot convert : " + message +" to an object" + e.getMessage());
        }
    }

    @KafkaListener(topics = {"bank-withdraw"}, groupId = "gid2")
    public void receive2(@Payload String message) {
        System.out.println("[+] === Topic: bank-withdraw, Receiver: receive-2 ==="  + LocalDate.now());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TransferMessage transferMessage = objectMapper.readValue(message, TransferMessage.class);
            accountService.withdraw(transferMessage.getAccountNumber(), transferMessage.getAmount());

        } catch (IOException e) {
            System.out.println("Kafka receiver: Cannot convert : " + message +" to an object" + e.getMessage());
        }
    }

    @KafkaListener(topics = {"bank-deposit"}, groupId = "gid3")
    public void receive3(@Payload String message) {
        System.out.println("[+] === Topic: bank-deposit, Receiver: receive-3 ==="  + LocalDate.now());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TransferMessage transferMessage = objectMapper.readValue(message, TransferMessage.class);
            accountService.deposit(transferMessage.getAccountNumber(), transferMessage.getAmount());

        } catch (IOException e) {
            System.out.println("Kafka receiver: Cannot convert : " + message +" to an object" + e.getMessage());
        }
    }

}