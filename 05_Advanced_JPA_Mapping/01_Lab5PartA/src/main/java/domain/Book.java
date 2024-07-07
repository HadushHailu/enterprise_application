package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book-type")
public class Book extends Product{
    private String isbn;

    public Book(){}

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public Book(String name, double price, String isbn) {
        super(name, price);
        this.isbn = isbn;
    }
}
