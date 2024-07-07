package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dvd-type")
public class DVD extends Product{
    private String genre;

    public DVD(){}

    public DVD(String genre) {
        this.genre = genre;
    }

    public DVD(String name, double price, String genre) {
        super(name, price);
        this.genre = genre;
    }
}
