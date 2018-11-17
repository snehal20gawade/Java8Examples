import library.Author;
import library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperation {

    public double calculateAverage(List<Integer> integerList) {
        double avg = integerList.stream().mapToDouble(i -> i)
                .average().getAsDouble();
        return avg;

    }

    public Set<Author> getListOfAuthorsInLib(List<Book> books) {
        Set<Author> authorSet = books.stream().map(book -> book.getAuthor()).collect(Collectors.toSet());
        return authorSet;
    }


    public List<Book> getBookListByAuthor(List<Book> bookList, Author author) {

        List<Book> bookList1 = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                bookList1.add(book);
            }

        }
        return bookList1;
    }

    public List<Book> getBookListByAuthorWithJava8(List<Book> books, Author author) {
        List<Book> bookList = books.stream().filter(book -> book.getAuthor().equals(author)).
                collect(Collectors.toList());
        return bookList;
    }
}
