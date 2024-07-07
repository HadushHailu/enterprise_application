package withHsqlDB.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }
}
