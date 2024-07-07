package customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	ICustomerDAO customerDAO;
	@Autowired
	IEmailSender emailSender;

	public CustomerService() {
		System.out.println("[-] Default Constructor");
	}

	public CustomerService(ICustomerDAO customerDAO){
		System.out.println("[-] Constructor one argument");
		this.customerDAO = customerDAO;
	}


	@Autowired
	public CustomerService(ICustomerDAO customerDAO, IEmailSender emailSender) {
		System.out.println("[-] Constructor two argument");
		this.customerDAO = customerDAO;
		this.emailSender = emailSender;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO){
		System.out.println("[-] setCustomerDAO injected");
		this.customerDAO = customerDAO;
		//throw new Exception();
	}

	public void setEmailSender(IEmailSender emailSender){
		System.out.println("[-] setEmailSender injected");
		this.emailSender = emailSender;
	}

	public void init(){
		System.out.println("[+] service init is executed");
	}

	public void destroy(){
		System.out.println("[+] Destroy method is executed");
	}

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
}
