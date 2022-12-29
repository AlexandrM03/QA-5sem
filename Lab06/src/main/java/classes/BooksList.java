package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BooksList {
    private List<Book> books;

    public BooksList() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getAllByAuthor(String author) {
        return books
                .stream()
                .filter(b -> Objects.equals(b.getAuthor(), author))
                .collect(Collectors.toList());
    }

    public List<Book> getAllByPublisher(String publisher) {
        return books
                .stream()
                .filter(b -> Objects.equals(b.getPublisher(), publisher))
                .collect(Collectors.toList());
    }

    public List<Book> getAllAfterPublishingYear(int year) {
        return books
                .stream()
                .filter(b -> b.getPublishingYear() >= year)
                .collect(Collectors.toList());
    }
}
