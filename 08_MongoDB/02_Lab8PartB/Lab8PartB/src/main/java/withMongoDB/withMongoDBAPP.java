package withMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import withMongoDB.domain.Person;
import withMongoDB.domain.Pet;
import withMongoDB.repository.PersonMongoRepository;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class withMongoDBAPP implements CommandLineRunner {

	@Autowired
	PersonMongoRepository personRepository;


	public static void main(String[] args) {
		SpringApplication.run(withMongoDBAPP.class, args);
	}

	public void run(String... args) throws Exception{
		System.out.println("[+] save 10,000 persons");

		long start1 = System.currentTimeMillis();
		for(int i=0; i < 10000; i++){

			List<Pet> pets = new ArrayList<>();
			for(int j=0; j<10; j++) {
				pets.add(new Pet("buru", 4));
			}

			Person person = new Person(i,"Kebede", "Gebru", pets);
			personRepository.save(person);
		}
		long finish1 = System.currentTimeMillis();
		long timeElapsed1 = finish1 - start1;

		System.out.println("[+] retrieve all persons");
		long start2 = System.currentTimeMillis();
		List<Person> allPersons = personRepository.findAll();
		allPersons.stream().forEach(System.out::println);
		long finish2 = System.currentTimeMillis();
		long timeElapsed2 = finish2 - start2;
		System.out.println("To Store all persons took "+timeElapsed1+" ms");
		System.out.println("To retrieve all persons took "+timeElapsed2+" ms");

//		To Store all persons took 5338 ms
//		To retrieve all persons took 711 ms

	}

}
