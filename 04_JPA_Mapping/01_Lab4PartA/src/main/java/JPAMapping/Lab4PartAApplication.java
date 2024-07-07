package JPAMapping;

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
@EntityScan("domain")
@EnableJpaRepositories("repositories")
public class Lab4PartAApplication implements CommandLineRunner {

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab4PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//----- A--Saving
		Employee employee = new Employee("Eden");
		Employee employee1 = new Employee("Hadush");
		Department department = new Department("ComPro");
		employee.setDepartment(department);
		employee1.setDepartment(department);

		departmentRepository.save(department);
		//employeeRepository.save(employee);

		//--- A-- Retrieve
		for(Department department1: departmentRepository.findAll()){
			System.out.println(department1);
		}

		//-----B-----
		Publisher publisher = new Publisher("Default-Publisher");
		publisherRepository.save(publisher);
		Publisher publisher1 = new Publisher("O'Reilly");
		publisherRepository.save(publisher1);

		Book book = new Book("TY-35423423", "Jesus-the-innocent");
		Publisher publisher2 = publisherRepository.findByName("Dummy").orElse(publisher);
		book.setPublisher(publisher2);
		bookRepository.save(book);
		System.out.println(bookRepository.findById(1L));

		//----C---
		Flight flight = new Flight("BY-734-MAX", "Addis-Ababa", "New-York", new Date());
		Flight flight1 = new Flight("BY-734-MAX", "New-york", "Dallas", new Date());
		Flight flight2 = new Flight("BY-734-MAX", "Dallas", "Tokyo", new Date());
		Flight flight3 = new Flight("BY-734-MAX", "Tokyo", "London", new Date());
		Passenger passenger = new Passenger("Isayas", flight);
		passenger.setFlights(flight1);
		passenger.setFlights(flight2);
		passenger.setFlights(flight3);

		passengerRepository.save(passenger);

		passengerRepository.findAll().stream()
				.forEach(System.out::println);

		//-------D------
		Student student = new Student("Hadush", "Hailu");
		Student student1 = new Student("Jhony", "Reo");

		School school = new School("MIU", student);
		school.setStudentMap(student1);
		schoolRepository.save(school);

		schoolRepository.findAll().stream()
				.forEach(System.out::println);


	}

}
