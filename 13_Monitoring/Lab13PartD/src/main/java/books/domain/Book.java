package books.domain;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Validated
public class Book {
	@NotEmpty
	@Size(min=2, max=10)
	private String isbn;
	@NotEmpty
	@Size(min=2, max=30)
	private String title;
	private double price;
	private String author;

	@Override
	public String toString() {
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", price=" + price +
				", author='" + author + '\'' +
				'}';
	}

	public Book() {

	}

	public Book(String isbn, String title, double price, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
