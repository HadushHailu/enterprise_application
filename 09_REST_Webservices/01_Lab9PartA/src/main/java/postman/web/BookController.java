package postman.web;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import postman.domain.Book;
import postman.domain.Books;
import postman.domain.ErrorMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {
    private Map<String, Book> books = new HashMap<String, Book>();

    public BookController(){
        books.put("B67-897-456", new Book("B67-897-456", "Obama", "American Democracy", 9.67));
        books.put("B67-935-780", new Book("B67-935-780", "Hadush", "Field Equation", 99.67));
        books.put("ADF-123-456", new Book("ADF-123-456", "Belay", "How to invade a country", 9.67));
    }

    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book books1 = books.get(isbn);
        if(books1 == null){
            return new ResponseEntity<ErrorMessage>(new ErrorMessage("Book with isbn " + isbn + " is not found!"), HttpStatus.NOT_FOUND);
        }
        books.remove(books1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        books.put(book.getIsbn(), book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        books.put(book.getIsbn(), book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/book/{getSearchParam}/{operation}")
    public ResponseEntity<?> getOrSearchBooks(@PathVariable String getSearchParam, @PathVariable String operation){
        Collection<Book> bookCollection = new ArrayList<>();

        if(operation.equals("get")){
            Book book = books.get(getSearchParam);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        else{
            for(Book book: books.values()){
                if(book.getAuthor().equals(getSearchParam)){
                    bookCollection.add(book);
                }
            }
            Books books1 = new Books(bookCollection);
            return new ResponseEntity<Books>(books1, HttpStatus.OK);

        }
    }

    @GetMapping("/book/search/{author}")
    public ResponseEntity<?> searchBooks(@PathVariable String author){
        Collection<Book> bookCollection = new ArrayList<>();

        for(Book book: books.values()){
            if(book.getAuthor().equals(author)){
                bookCollection.add(book);
            }
        }

        Books books1 = new Books(bookCollection);
        return new ResponseEntity<Books>(books1, HttpStatus.OK);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
        Book book = books.get(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        Books allBooks = new Books(books.values());
        return new ResponseEntity<Books>(allBooks, HttpStatus.OK);
    }

}
