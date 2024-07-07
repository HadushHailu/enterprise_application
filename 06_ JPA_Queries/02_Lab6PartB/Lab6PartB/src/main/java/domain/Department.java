package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }

    public Department(String name) {
        this.name = name;
    }


}
