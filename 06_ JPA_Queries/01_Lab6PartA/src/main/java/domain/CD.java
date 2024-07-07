package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("cd-type")
@NamedQuery(name="findByArtist", query="select c from CD c where c.artist=:artist")
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
