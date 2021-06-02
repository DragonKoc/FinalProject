package alfa.model;

import alfa.model.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SearchBooksTest {

    private ServiceBooks serviceBooks;

    @Before
    public void initialize(){
        serviceBooks = new ServiceBooks();
    }

    @Parameterized.Parameter
    public String valueName;

    @Parameterized.Parameter(1)
    public String valueAuthor;

    @Parameterized.Parameter(2)
    public  String valuePublish;

    @Parameterized.Parameter(3)
    public  int valueYear;

    @Parameterized.Parameter(4)
    public  int valueCountPages;

    @Parameterized.Parameter(5)
    public  double valueCost;


    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"TestName", "TestAuthor", "TestPublish", 2020,1000,10.05}
        });
    }

    @Test
    public void viewName() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getName(),valueName);
    }


    @Test
    public void viewAuthor() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getAuthor(),valueAuthor);
    }

    @Test
    public void viewPublish() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getPublish(),valuePublish);
    }

    @Test
    public void viewYear() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getYear(), valueYear);
    }

    @Test
    public void viewCountPages() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getCountPages(), valueCountPages);
    }

    @Test
    public void viewCost() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        Book bok = serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1);
        assertEquals(bok.getCost(), valueCost, 0.00);
    }



    @Test
    public void viewNameNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getName(),null);
    }


    @Test
    public void viewAuthorNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getAuthor(),null);
    }

    @Test
    public void viewPublishNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getPublish(),null);
    }

    @Test
    public void viewYearNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getYear(),null);
    }

    @Test
    public void viewCountPagesNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getCountPages(),null);
    }

    @Test
    public void viewCostNotFound() {
        serviceBooks.addBook(valueName, valueAuthor, valuePublish, valueYear, valueCountPages, valueCost);
        assertNotEquals(serviceBooks.getBookList().get(serviceBooks.getBookList().size() - 1).getCost(),null);
    }

}