package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;

    @ManyToOne(optional = false)
    private Publisher publisher;

    Book(){}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                '}';
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
