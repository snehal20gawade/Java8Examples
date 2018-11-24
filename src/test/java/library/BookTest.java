package library;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class BookTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createBook() {
        Author author = new Author();
        author.setName("Alan");
        author.setId(1);
        Book book = Book.createBook("Java", author);
        assertThat(book.getId(), equalTo(1001));

        Author author2 = new Author();
        author2.setName("Rian");
        author2.setId(2);
        Book book1 = Book.createBook("Spring", author2);
        assertThat(book1.getId(), equalTo(1002));

    }


    @Test
    public void equalTest() {
        Author author = new Author();
        author.setName("Alan");
        author.setId(1);

        Author author1 = new Author();
        author.setName("Nick");
        author.setId(2);

        Book book = Book.createBook("Java", author);
        Book book1 = Book.createBook("Java", author);
        Book book2 = Book.createBook("Spring", author1);
        Book book3 = Book.createBook("Spring", author);

        assertThat(book.equals(book1), equalTo(true));
        assertThat(book.equals(book2), equalTo(false));
        assertThat(book2.equals(book3), equalTo(false));
        assertThat(book2.equals(author), equalTo(false));

    }

}