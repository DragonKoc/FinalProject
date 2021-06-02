package alfa.model;

import alfa.model.entity.Book;
import alfa.view.BooksView;

import java.util.ArrayList;
import java.util.List;

public class SearchBooks {
    private BooksView printBooks = new BooksView();

    public List<Book> viewName(List<Book> booklist, String name){
        List<Book> outputBooks = new ArrayList<>();
        for (Book book : booklist)   {
            if (name.equals(book.getName())){
                printBooks.printBook(book);
                outputBooks.add(book);
            }
        }
        if (outputBooks.size() > 0){
            return outputBooks;
        } else {
            System.out.println("There are no books with that name");
            return outputBooks;
        }
    }

    public List<Book> viewAuthor(List<Book> booklist, String author){
        List<Book> outputBooks = new ArrayList<>();
        for (Book book : booklist)   {
            if (author.equals(book.getAuthor())){
                printBooks.printBook(book);
                outputBooks.add(book);
            }
        }
        if (outputBooks.size() > 0){
            return outputBooks;
        } else {
            System.out.println("No books by this author");
            return outputBooks;
        }
    }

    public List<Book>  viewPublish(List<Book> booklist, String publish){
        List<Book> outputBooks = new ArrayList<>();
        for (Book book : booklist)   {
            if (publish.equals(book.getPublish())){
                printBooks.printBook(book);
                outputBooks.add(book);
            }
        }
        if (outputBooks.size() > 0){
            return outputBooks;
        } else {
            System.out.println("No books from this publisher");
            return outputBooks;
        }
    }

    public List<Book> viewYear(List<Book> booklist, int year){
        List<Book> outputBooks = new ArrayList<>();
        for (Book book : booklist)   {
            if (year == (book.getYear())){
                printBooks.printBook(book);
                outputBooks.add(book);
            }
        }
        if (outputBooks.size() > 0){
            return outputBooks;
        } else {
            System.out.println("No books for this year");
            return outputBooks;
        }
    }

    public List<Book> viewCost(List<Book> booklist, Double costIn, Double costOut){
        List<Book> outputBooks = new ArrayList<>();
        for (Book book : booklist)   {
            if (costIn <= (book.getCost()) && (book.getCost()) <= costOut){
                printBooks.printBook(book);
                outputBooks.add(book);
            }
        }
        if (outputBooks.size() > 0){
            return outputBooks;
        } else {
            System.out.println("There are no books in this price range");
            return outputBooks;
        }
    }

}
