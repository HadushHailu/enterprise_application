package com.java_guidelines.springboot_first_app;

public class MyAccountService {
    private IAccountDAO accountDAO;

    MyAccountService(IAccountDAO accountDAO){
        this.accountDAO = accountDAO;
        System.out.println("MyAccountService Constructor: " + accountDAO);
        System.out.println("MyAccountService: accountDAO: " + this.accountDAO);
    }
    public void setAccountDAO(IAccountDAO accountDAO) {
        System.out.println("MyAccountService: SetAccountDAD" + accountDAO);
        this.accountDAO = accountDAO;
    }

    IAccountDAO getAccountDAO(){
        return this.accountDAO;
    }
}
