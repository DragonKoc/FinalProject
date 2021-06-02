package alfa.model;

import alfa.exception.BooksReadFileException;
import alfa.model.entity.Book;
import alfa.util.WriteBook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SourceBooks {

    private static final Logger logger = LogManager.getLogger(SourceBooks.class);

    private static WriteBook writeBook;

    public static List<Book> generateBooks() {

        logger.info("создание справочника из генератора");
        List<Book> list = new ArrayList<>();
        logger.debug("List<Book> list = new ArrayList<>() создан");
        list.add(new Book("HeadFirstJava", "Beyts", "Almanah", 1905, 100, 1000.5));
        list.add(new Book("Java.Beginner's Guide", "Шилдт", "Javac", 2020, 300, 450.5));
        list.add(new Book("Java_для_чайников", "Берд", "Almanah", 1988, 300, 200.0));
        list.add(new Book("Java.Полное_руководство", "Шилдт", "JavaLesson", 2001, 500, 432.5));
        list.add(new Book("Java.Библиотека_профессионала", "Хорстманн", "Publish", 2010, 800, 500.5));
        list.add(new Book("Java.Методы_программирования", "Блинов", "Nebo", 2020, 200, 345.0));
        list.add(new Book("Java.Dictionary_Developer", "Эванс", "Sky", 2005, 600, 800.5));
        list.add(new Book("JavaSE9.Basic", "Хорстманн", "Agenstvo", 1945, 100, 1010.0));
        list.add(new Book("Effective_Java", "Блох", "Abetka", 2018, 1005, 333.5));
        list.add(new Book("Философия_Java", "Эккель", "Divo", 2013, 900, 690.0));
        logger.debug("list наполнен");
        return list;
    }

    public static List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
                if(! new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").isFile()  ||
                        new File("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json").length() == 0){
                logger.info("не пройдена проверка наличия справочника, справочник будет пересоздан");
                writeBook.writeBooks(generateBooks());
            }
            Object parse = parser.parse(new FileReader("/Users/dragon/Dev/ideaProjects/FinalProject/src/main/resources/books.json"));
            JSONObject jsonObject = (JSONObject) parse;
            JSONArray jsonArray = (JSONArray) jsonObject.get("Books");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonBook = (JSONObject) jsonArray.get(i);
                    list.add(new Book(
                            jsonBook.get("name").toString(),
                            jsonBook.get("author").toString(),
                            jsonBook.get("publish").toString(),
                            Integer.parseInt(jsonBook.get("year").toString()),
                            Integer.parseInt(jsonBook.get("countPages").toString()),
                            Double.parseDouble(jsonBook.get("cost").toString())
                    ));
                }
            }
            logger.info("заполнение справочника успешно");
            return list;

        } catch (Exception e) {
            logger.info("ошибка! при создании и заполнении справочника!");
            throw new BooksReadFileException(e.getMessage());
        }
    }
}
