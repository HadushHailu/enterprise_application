package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;
import specification.CDSpecification;
import specification.CustomerSpecification;
import specification.OrderSpecification;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	@Autowired
	CDRepository cdRepository;
	@Autowired
	DVDRepository dvdRepository;

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product cd1 = new CD("U2", 12, "Eminem");
		Product cd2 = new CD("U2", 6, "Eminem");
		Product cd3 = new CD("U2", 8, "Dr.Dre");
		Product dvd1 = new DVD("Rocky3", 4.6, "Adult");
		Product dvd2 = new DVD("Rocky3", 70, "Space-exploration");
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


		Order order1 = new Order("ORD-ID-0001",new Date(), "closed", orderLine1);
		order1.addOrderLine(orderLine2);
		order1.addOrderLine(orderLine4);

		Order order2 = new Order("ORD-ID-0002",new Date(), "closed", orderLine3);
		order2.addOrderLine(orderLine5);

		Order order3 = new Order("ORD-ID-0003",new Date(), "Delivered", orderLine6);
		order3.addOrderLine(orderLine7);
		order3.addOrderLine(orderLine8);

		Address address1 = new Address("1000N", "FairFeild", "52557", "USA");
		Address address2 = new Address("1100E", "Amsterdam", "52557", "Canada");

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

		//==== Write queries using method names for the following queries ====
		//Give all customers.
		customerRepository.findAll().stream()
				.forEach(System.out::println);
		//Give all CD’s from U2 with a price smaller than 10 euro
		cdRepository.findByPriceLessThan(10.0).stream()
				.forEach(System.out::println);

		//Give all customers with zip code 2389HJ
		customerRepository.findByAddressZip("52557").stream()
				.forEach(System.out::println);

		//Give all customers who ordered a DVD with the name Rocky3
		customerRepository.findByTheOrdersOrderlinesProductName("Rocky3").stream()
				.forEach(System.out::println);


		//======== Write a named query for the following queries: =======
		//Give all customers from the USA.
		customerRepository.findCountry("USA").stream()
				.forEach(System.out::println);
		//Give all CD’s from a certain artist
		cdRepository.findByArtist("Eminem").stream()
				.forEach(System.out::println);

		//======== Write a JPQL query with @Query for the following queries: =======
		//▪ Give the ordernumbers of all orders with status ‘closed’
		orderRepository.findOrderClosed("closed").stream()
				.forEach(System.out::println);

		//▪ Give the first and lastnames of all customers who live in Amsterdam.
		customerRepository.findCustomersInAmsterdam().stream()
				.forEach(p->System.out.println(Arrays.toString(p)));

		//▪ Give the ordernumbers of all orders from customers who live in a certain city (city is a parameter).
		customerRepository.findOrderNumbersByCity("Amsterdam").stream()
				.forEach(System.out::println);

		//▪ Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2).
		cdRepository.findCDsByArtistAndPriceGreaterThan("Eminem", 6.0).stream()
				.forEach(System.out::println);

		// ====== Write a native query for the following queries: =====
		//▪ Give all addresses in Amsterdam.
		adressRepository.findAddressInAmsterdam().stream()
				.forEach(System.out::println);

		//▪ Give all CD’s from U2.
		cdRepository.findCDU2().stream()
				.forEach(System.out::println);

		//==== Implement the following queries using specifications: =====
		//▪ Give the ordernumbers of all orders with status ‘closed’
		Specification<Order> orderSpecification = OrderSpecification.hasStatusClosed();
		orderRepository.findAll(orderSpecification).stream()
				.forEach(p->System.out.println(p.getOrdernr()));

		//▪ Give all customers who live in Amsterdam.
		Specification<Customer> customerSpecification = CustomerSpecification.livesInAmsterdam();
		customerRepository.findAll(customerSpecification).stream()
				.forEach(System.out::println);

		//▪ Give all CD’s from a certain artist with a price bigger than a certain amount (artist and amount are parameter2).
		Specification<CD> cdSpecification1 = CDSpecification.fromCDArtist("Eminem");
		Specification<CD> cdSpecification2 = CDSpecification.fromCDPriceGreaterThan(6);
		cdRepository.findAll(Specification.where(cdSpecification1).and(cdSpecification2)).stream()
				.forEach(System.out::println);

	}

}
