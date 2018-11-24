package library;

import lombok.Data;

import java.util.HashMap;

@Data
public class Book {

    private int id;

    private String bookName;

    private Author author;

    private static int nextBookId = 1001;

    private Book(int id, String bookName, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public static Book createBook(String bookName, Author author) {
        int id = nextBookId++;
        return new Book(id, bookName, author);
    }

    @Override
    public String toString() {
        return "Book id :" + this.id + ",," + "Name of book : " + this.bookName + ",," + "Name of author : " + this.author.getName() + ",," +
                "Author Id :" + this.author.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Book)) {
           return false;
        }

        Book book = (Book) obj;

        if (bookName == book.getBookName() && author == book.getAuthor()) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + bookName.hashCode();
        result = 31 * result + id;
        result = 31 * result + author.hashCode();
        return result;
    }
}
