package withHsqlDB.domain;

import javax.persistence.*;
@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }
}
