package com.java_guidelines.springboot_first_app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		//ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		//SpringApplication.run(SpringbootFirstAppApplication.class, args);
//		CustomerService customerService = context.getBean("customerService", CustomerService.class);
//		customerService.sayHello();

//		CustomerService customerService1 = context.getBean("customerService", CustomerService.class);
//		CustomerService customerService2 = context.getBean("customerService", CustomerService.class);
//		System.out.println("customerService1 ="+ customerService1);
//		System.out.println("customerService2 ="+ customerService2);
		System.out.println("2");
		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		System.out.println("3");
		customerService.addCustomer("Frank Brown");
		System.out.println("4");
//		MyAccountService myAccountService = context.getBean("accountService", MyAccountService.class);
//		System.out.println("IAccountDAO: " + myAccountService.getAccountDAO());
		//context.close();

		customerService.addCustomer("Hadush");

		System.out.println("new context..");
		ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
		MyCustomerServiceImpl myCustomerServiceImpl =
				context1.getBean("customerService", MyCustomerServiceImpl.class);
		myCustomerServiceImpl.addCustomer("Well, ME");
	}


}
