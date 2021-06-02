package alfa.model;

import alfa.model.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceBooksTest {

    private ServiceBooks serviceBooks;

    @Before
    public void initialize(){
        serviceBooks = new ServiceBooks();
    }

    @Test
    public void getBookList() {
        assertFalse(serviceBooks.getBookList().isEmpty());
        assertEquals(10, serviceBooks.getBookList().size());
    }

    @Test
    public void addBook() {
        int size1 = serviceBooks.getBookList().size();
        serviceBooks.addBook("Test", "Test", "Test", 2020, 100, 333.3);
        int size2 = serviceBooks.getBookList().size();
        assertTrue(size1 < size2);
    }

    @Test
    public void increaseCostAll() {
        Book book = serviceBooks.getBookList().get(0);
        List<Book> list = new ArrayList<>();
        list.add(book);
        Double firstPrise = book.getCost();
        serviceBooks.increaseCostAll(list,50);
        Double changePrise = book.getCost();
        assertTrue(changePrise > firstPrise);
    }
}