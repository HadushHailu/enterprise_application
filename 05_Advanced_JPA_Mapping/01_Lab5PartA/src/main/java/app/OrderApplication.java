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

		Product cd1 = new CD("Slim-shade", 456.8, "Eminem");
		Product cd2 = new CD("One-night", 45, "Lil-wayne");
		Product cd3 = new CD("Cyber-Truck", 60, "Dr.Dre");
		Product dvd1 = new DVD("French-style", 4.6, "Adult");
		Product dvd2 = new DVD("The-moon-landing", 70, "Space-exploration");
		Product book1 = new Book("Allien-open-problems", 600, "BK-876-098");
		Product book2 = new Book("Galactic-codes", 7000, "GT-876-897");
		Product book3 = new Book("Indain-rheotoric", 5.9, "IN-543-897");

		OrderLine orderLine1 = new OrderLine(3, cd1);
		OrderLine orderLine2 = new OrderLine(2, cd2);
		OrderLine orderLine3 = new OrderLine(1, cd3);
		OrderLine orderLine4 = new OrderLine(7, dvd1);
		OrderLine orderLine5 = new OrderLine(7, dvd2);
		OrderLine orderLine6 = new OrderLine(7, book1);
		OrderLine orderLine7 = new OrderLine(7, book2);
		OrderLine orderLine8 = new OrderLine(7, book3);


		Order order1 = new Order("ORD-ID-0001",new Date(), "Shipped", orderLine1);
		order1.addOrderLine(orderLine2);
		order1.addOrderLine(orderLine3);

		Order order2 = new Order("ORD-ID-0002",new Date(), "Delivered", orderLine4);
		order2.addOrderLine(orderLine5);

		Order order3 = new Order("ORD-ID-0003",new Date(), "Delivered", orderLine6);
		order3.addOrderLine(orderLine7);
		order3.addOrderLine(orderLine8);

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

	}

}
