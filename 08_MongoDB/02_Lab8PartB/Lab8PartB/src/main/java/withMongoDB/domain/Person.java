package withMongoDB.domain;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document
public class Person {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private List<Pet> pets = new ArrayList<>();

    public Person() {
    }

    public Person(int id, String firstName, String lastName, List<Pet> pets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }
}
