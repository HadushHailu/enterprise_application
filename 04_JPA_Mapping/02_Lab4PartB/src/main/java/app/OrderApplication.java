package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AdressRepository adressRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderLineRepository orderLineRepository;
	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product product1 = new Product("Falcon-x", 45000000);
		Product product2 = new Product("CyberTruck", 60000);
		Product product3 = new Product("BlueOrgin", 6000000);
		Product product4 = new Product("Appollo", 7000000);
		Product product5 = new Product("Toyota", 6000000);
		Product product6 = new Product("Nissan", 7000000);

		OrderLine orderLine1 = new OrderLine(3, product1);
		OrderLine orderLine2 = new OrderLine(2, product2);
		OrderLine orderLine3 = new OrderLine(1, product3);
		OrderLine orderLine4 = new OrderLine(7, product4);
		OrderLine orderLine5 = new OrderLine(7, product5);
		OrderLine orderLine6 = new OrderLine(7, product6);


		Order order1 = new Order("ORD-ID-0001",new Date(), "Shipped", orderLine1);
		order1.addOrderLine(orderLine2);
		order1.addOrderLine(orderLine3);
		Order order2 = new Order("ORD-ID-0002",new Date(), "Delivered", orderLine4);

		Order order3 = new Order("ORD-ID-0003",new Date(), "Delivered", orderLine5);
		order3.addOrderLine(orderLine6);

		Address address1 = new Address("1000N", "FairFeild", "52557", "USA");
		Address address2 = new Address("1100E", "NewYork", "67034", "USA");

		Customer customer1 = new Customer("Hadush", "Hailu", address1, order1);
		customer1.addOrder(order3);
		Customer customer2 = new Customer("Tedros", "Salih", address2, order2);

		order1.setCustomer(customer1);
		order2.setCustomer(customer2);
		order3.setCustomer(customer1);

		customerRepository.save(customer1);
		customerRepository.save(customer2);

		customerRepository.findAll().stream()
				.forEach(System.out::println);



//		Product product = new Product();
//		product.setName("Hibernate 3");
//		product.setDescription("Good book on Hibernate");
//		product.setPrice(35.50);
//		OrderLine ol1 = new OrderLine(2, product);
//
//		Product product2 = new Product();
//		product2.setName("The best of Queen");
//		product2.setDescription("Album from 1995");
//		product2.setPrice(12.98);
//		OrderLine ol2 = new OrderLine(4, product2);
//
//		Order o1 = new Order("234743", "12/10/06", "open");
//		o1.addOrderLine(ol1);
//		o1.addOrderLine(ol2);
//
//		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
//				"New york", "43221");
//		c1.addOrder(o1);
//		o1.setCustomer(c1);
//
//
//		printOrder(o1);
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
//		for (OrderLine orderline : order.getOrderlines()) {
//			System.out.println("Order line: quantity= "
//					+ orderline.getQuantity());
//			Product product = orderline.getProduct();
//			System.out.println("Product: " + product.getName() + " "
//					+ product.getDescription() + " " + product.getPrice());
//		}

	}
}
