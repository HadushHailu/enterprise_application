package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Lab2PartAApplication implements CommandLineRunner {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Lab2PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer("Frank Brown", "fbrown@acme.com", "mainstreet 5", "Chicago", "60613");
//		productService.addProduct("ET0056", "Rocket-TY", 4709870);
	}

}
