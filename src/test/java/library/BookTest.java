package library;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

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
        assertThat(book.getId(), CoreMatchers.equalTo(1001));

        Author author2 = new Author();
        author2.setName("Rian");
        author2.setId(2);
        Book book1 = Book.createBook("Spring", author2);
        assertThat(book1.getId(), CoreMatchers.equalTo(1002));

    }
}