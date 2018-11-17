package library;

import lombok.Data;

@Data
public class Book {

    private int id;

    private String bookName;

    private Author author;
}
