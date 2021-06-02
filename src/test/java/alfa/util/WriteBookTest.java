package alfa.util;

import alfa.model.SourceBooks;
import alfa.model.entity.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class WriteBookTest {

    private SourceBooks sourceBooks;
    private WriteBook writeBooks;

    @Before
    public void initialize(){
        sourceBooks = new SourceBooks();
        writeBooks = new WriteBook();
    }

    @Test
    public void testWriteBooks() throws IOException, ParseException {
        List<Book> booksList = sourceBooks.generateBooks();
        writeBooks.writeBooks(booksList);
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json");
        JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
        JSONArray jsonArray = (JSONArray) jsonObject.get("Books");
        assertTrue(jsonObject.containsKey("Books"));
        assertEquals(10, jsonArray.size());
    }

}