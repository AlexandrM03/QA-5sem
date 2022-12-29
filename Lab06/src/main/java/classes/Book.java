package classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int publishingYear;
    private int pages;
    private float price;
    private Binding binding;
}
