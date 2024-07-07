package clientApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import postman.domain.Book;

@SpringBootApplication
public class clientApp implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(clientApp.class, args);
	}

	@Override
	public void run(String... args){

		RestClient restClient = RestClient.builder()
				.baseUrl("http://localhost:8080")
				.build();

		//get book from isbn
		Book bookIsbn = restClient.get()
				.uri("/book/{isbn}", "B67-935-780")
				.retrieve()
				.body(Book.class);
		System.out.println(bookIsbn);
	}

}
