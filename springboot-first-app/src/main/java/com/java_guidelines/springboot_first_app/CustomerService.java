package com.java_guidelines.springboot_first_app;

public interface CustomerService {
    public abstract void addCustomer(String customername);
    public abstract void init();
    public abstract void cleanup();
}
