package alfa.model;

import alfa.model.entity.Book;
import alfa.util.WriteBook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import static org.junit.Assert.*;

public class SourceBooksTest {

    private SourceBooks sourceBooks;

    @Before
    public void initialize(){
        sourceBooks = new SourceBooks();
    }

    @Test
    public void testGenerateBook() {
        List<Book> books = sourceBooks.generateBooks();
        assertNotNull(books);
        assertEquals(10,books.size());
        assertTrue(new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").isFile());
        assertTrue(new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").length() > 0);
    }

    @Test
    public void testingGetAllBooks() {
        List<Book> allBooks = sourceBooks.getAllBooks();
        assertNotNull(allBooks);
        assertEquals(10,allBooks.size());
        assertTrue(new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").isFile());
        assertTrue(new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").length() > 0);
    }
}