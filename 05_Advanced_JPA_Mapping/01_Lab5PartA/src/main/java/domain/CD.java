package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cd-type")
public class CD extends Product{
    private String artist;

    public CD(){}
    public CD(String artist) {
        this.artist = artist;
    }

    public CD(String name, double price, String artist) {
        super(name, price);
        this.artist = artist;
    }
}
