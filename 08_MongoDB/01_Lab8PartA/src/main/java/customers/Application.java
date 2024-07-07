package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
       this.forStudent();
	}

	public void forStudent(){

		System.out.println("[+] Creating students");
		Address address1 = new Address("Kebele-18", "Mekelle", "456-809");
		Address address2 = new Address("Kebele-2", "Wukro", "456-809");

		Student student1 = new Student(123L, "Gebre", "+1-234-567-8890", address1);
		Student student2 = new Student(133L, "Kebede", "+1-234-567-8891", address1);
		Student student3 = new Student(143L, "Fatima", "+1-234-567-8892", address2);
		Student student4 = new Student(153L, "Tsige", "+1-234-567-8890", address2);

		List<Grade> gradeList1 = new ArrayList<>(){{
			add(new Grade("MPP", "A+"));
			add(new Grade("FPP", "C-"));
			add(new Grade("EA", "D+"));
		}};

		List<Grade> gradeList2 = new ArrayList<>(){{
			add(new Grade("MPP", "B+"));
			add(new Grade("FPP", "C+"));
			add(new Grade("EA", "C+"));
		}};

		List<Grade> gradeList3 = new ArrayList<>(){{
			add(new Grade("MPP", "C+"));
			add(new Grade("FPP", "B-"));
			add(new Grade("EA", "B+"));
		}};

		List<Grade> gradeList4 = new ArrayList<>(){{
			//add(new Grade("MPP", "D+"));
			add(new Grade("FPP", "B+"));
			add(new Grade("EA", "A+"));
		}};

		student1.setGrades(gradeList1);
		student2.setGrades(gradeList2);
		student3.setGrades(gradeList3);
		student4.setGrades(gradeList4);

		System.out.println("[+] Saving them");
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);

		System.out.println("[*] Part-1");
		//====== Then write the following queries using method names: ===
		//• Find the Students with a certain name
		studentRepository.findByName("Kebede").stream()
				.forEach(System.out::println);
		//System.out.println(studentRepository.findByName("Kebede").get());
		//• Find the Students with a certain phone number
		studentRepository.findByPhone("+1-234-567-8890").stream()
				.forEach(System.out::println);

		//• Find the Students from a certain city
		studentRepository.findByAddressCity("Mekelle").stream()
				.forEach(System.out::println);

		System.out.println("[*] Part-2");
		// ====== Then write the following queries using method names: ===
		//• Find the Students that took a certain course with a given name
		studentRepository.findByGradesCourseName("MPP").stream()
				.forEach(System.out::println);
		//• Find the Students with an A+ for a certain course name
		System.out.println(" [-] Part-2-2");
		studentRepository.findByGradesGradeAndGradesCourseName("A+", "EAA").stream()
				.forEach(System.out::println);

	}

	public void forCustomer(){
		// create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);

		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);

		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);

		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());

		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);

		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));

		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));

		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findByCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

	}

}
