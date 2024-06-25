package com.java_guidelines.springboot_first_app;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class CustomerServiceImpl implements CustomerService{
    public CustomerServiceImpl() {
        System.out.println("calling constructor of CustomerServiceImpl");
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
