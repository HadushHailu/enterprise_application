package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    Publisher(){}

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }

    public Publisher(String name) {
        this.name = name;
    }
}
