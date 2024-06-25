package com.java_guidelines.springboot_first_app;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class MyCustomerServiceImpl implements CustomerService{
    private EmailService emailService;

    MyCustomerServiceImpl(){
        System.out.println("MyCustomerServiceImpl constructor");
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
        this.emailService.sendEmail();
    }


    public void addCustomer(String customername) {
        System.out.println("calling addCustomer of CustomerServiceImpl");
    }

    @PostConstruct
    public void init() {
        System.out.println("calling init method of CustomerService");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("calling cleanup method of CustomerService");
    }
}
