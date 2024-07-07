package app;

import java.util.List;
import java.util.Optional;

import domain.Book;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.BookRepository;
import repositories.CustomerRepository;
import domain.Customer;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(100L);
		Customer customer = custOpt.orElse(null);
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		System.out.println("-------- FindByFirstName-----");
		List<Customer> customer1 = customerrepository.findByLastName("Bauer");
		customer1.stream()
				.forEach(System.out::println);

		System.out.println("-------- FindByFirstNameAndLastNameAndEmail-----");
		System.out.println(customerrepository.findByFirstNameAndLastNameAndEmail("Kim", "Bauer", "kim@acme.com"));

		System.out.println("-------- findLastNameByFirstName-----");
		System.out.println(customerrepository.findLastNameByFirstName("Kim"));

		bookRepository.save(new Book("Haush-izm", "TR-87GHBY", "Hadush", 897.99));
		bookRepository.save(new Book("Jesus-the-lair", "TR-836sdf", "Hailu", 32.99));
		bookRepository.save(new Book("Follow-me", "TR-GHD487", "Gebre", 98.09));

		// Retrieve and display all books
		System.out.println("----Retrieve all books from the database and display them in the console---");
		bookRepository.findAll().forEach(System.out::println);

		// Update a book
		System.out.println("----update a book---");
		Book book = bookRepository.findById(3L).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setTitle("I-am-the-way");
		book.setISBN("TR-35jsf");
		book.setAuthor("Hadush");
		book.setPrice(345.98);
		bookRepository.save(book);

		//Delete a book (not the book that was just updated)
		System.out.println("----Delete a book (not the book that was just updated)---");
		bookRepository.deleteById(1L);

		// Retrieve and display all books
		System.out.println("----Retrieve all books from the database and display them in the console---");
		bookRepository.findAll().forEach(System.out::println);



	}
}
