package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());

		productDAO.clearDB();
		Product product = new Product(123, "CyberTruck", 30000);
		Supplier supplier = new Supplier(123, "Elon Musk", "1-641-233-2435");
		product.setSupplier(supplier);
		productDAO.save(product);

		product = new Product(128, "Falcon-Rocket", 30000000);
		supplier = new Supplier(128, "Donald Trump", "1-641-457-897");
		product.setSupplier(supplier);
		productDAO.save(product);

		System.out.println("-----------findByProductNumber ----------------");
		System.out.println(productDAO.findByProductNumber(123));

		System.out.println("-----------findByProductName ----------------");
		System.out.println(productDAO.findByProductName("Falcon-Rocket"));

		System.out.println("-----------removeProduct ----------------");
		//productDAO.removeProduct(128);

		System.out.println("-----------getAllProducts----------------");
		productDAO.getAllProducts().stream()
				.forEach(System.out::println);



	}
}
