package alfa.util;

import alfa.exception.BookWriteFileException;
import alfa.model.entity.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteBook {
    public static void writeBooks(List<Book> bookList) {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            for (Book book:bookList) {
                JSONObject jsonBook = new JSONObject();
                jsonBook.put("name", book.getName());
                jsonBook.put("author", book.getAuthor());
                jsonBook.put("publish", book.getPublish());
                jsonBook.put("year", book.getYear());
                jsonBook.put("countPages", book.getCountPages());
                jsonBook.put("cost", book.getCost());
                jsonArray.add(jsonBook);
            }
            jsonObject.put("Books", jsonArray);
            Files.write(Paths.get("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json"),
                    jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new BookWriteFileException(e.getMessage());
        }
    }
}
