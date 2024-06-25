package com.java_guidelines.springboot_first_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("emailService")
@Scope("prototype")
public class EmailService implements IEmailService{

    @Value("smtp.mailserver.com")
    private String emailServer;

    EmailService(){
        System.out.println("Email service constructor");
    }
    public void sendEmail() {
        System.out.println("send email to server: "+ emailServer);
    }
}
