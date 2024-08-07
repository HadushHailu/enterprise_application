package app;

import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder ;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args){
		productService.createAccount("mary", passwordEncoder.encode("mary"), "finance");
		productService.createAccount("bob", passwordEncoder.encode("bob"), "sales");
		productService.createAccount("steve", passwordEncoder.encode("steve"), "manager");
		productService.createAccount("elon", passwordEncoder.encode("elon"), "topmanager");
	}
}
