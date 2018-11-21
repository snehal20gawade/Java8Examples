import library.Author;
import library.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class StreamOperationTest {

    private StreamOperation streamOperation;

    @Before
    public void setUp() throws Exception {
        streamOperation = new StreamOperation();
    }

    @Test
    public void calculateAverage() {
        List<Integer> integers = new ArrayList<>();
        integers.add(6);
        integers.add(12);
        integers.add(7);
        integers.add(5);
        integers.add(14);
        double averageValue = streamOperation.calculateAverage(integers);
        assertThat(averageValue,equalTo(Double.valueOf(8.8)));
    }


    @Test
    public void getListOfAunthorsInLib() {
        List<Book> books = setupBooks();
       Set<Author> authors =  streamOperation.getListOfAuthorsInLib(books);
        assertThat(authors, hasSize(2));
    }


    @Test
     public void getBookListByAuthor(){
        List<Book> books = setupBooks();
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Snehal");
        List<Book> bookList= streamOperation.getBookListByAuthor(books,author1);
        assertThat(bookList ,hasSize(2));
     }

    @Test
    public void getBookListByAuthorByJava8(){
        List<Book> books = setupBooks();
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Snehal");
        Book book1 = Book.createBook( "First Book",author1);
        List<Book> bookList= streamOperation.getBookListByAuthorWithJava8(books, author1);
        assertThat(bookList,hasSize(2));
    }

    private List<Book> setupBooks() {
        List<Book> books = new ArrayList<>();
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Snehal");

        Author author2 = new Author();
        author2.setId(2);
        author2.setName("Anaya");

        Author author3 = new Author();
        author3.setId(3);
        author3.setName("Vijay");

        Book book1 = Book.createBook( "First Book",author1);

        Book book2 = Book.createBook( "Second Book",author2);

        Book book3 = Book.createBook( "Third Book",author1);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        return books;
    }

}