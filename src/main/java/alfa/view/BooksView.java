package alfa.view;

import alfa.model.entity.Book;

import java.util.List;

public class BooksView {
    public static final String ENTER_COMMAND = "Make your choice: ";
    public static final String ENTER_USER = "Enter your data: ";
    public static final String ERROR_ENTER = "Error. Repeat! ";
    public static final String ENTER_TITL = "Enter title: ";
    public static final String ENTER_AUTHOR = "Enter author: ";
    public static final String ENTER_PUBLISHER = "Enter publisher: ";
    public static final String ENTER_YEAR = "Enter year: ";
    public static final String ENTER_PAGES = "Enter pages: ";
    public static final String ENTER_COST = "Enter cost: ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printListBooks(List<Book> books){
        for (Book elem: books
             ) {
            System.out.println(convertBookToString(elem));
        }
    }

    public void printBook(Book book){
        System.out.println(convertBookToString(book));
    }

    private String convertBookToString(Book book){
        return String.format("%-20s| %-30s| %-15s| %-5d| %-5d| %8.2f", book.getAuthor(), book.getName(),
                book.getPublish(),book.getYear(),
                book.getCountPages(),book.getCost()
        );
    }

    public void printMenu(){
        System.out.print(
                "1. View all books\n" +
                "2. Add a new book\n" +
                "3. Change price of the all books\n" +
                "4. Change price of the book\n" +
                "5. Search the book (by author,year or publisher)\n" +
                "0. Close the app\n");
    }

    public void printSearch(){
        System.out.print(
                "1. Name\n" +
                "2. Author\n" +
                "3. Publisher\n" +
                "4. Year\n" +
                "5. Cost\n" +
                 "0. Close the app\n");
    }
}
