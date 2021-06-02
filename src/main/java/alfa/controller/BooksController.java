package alfa.controller;

import alfa.model.SearchBooks;
import alfa.model.ServiceBooks;
import alfa.model.entity.Book;
import alfa.util.Validation;
import alfa.util.WriteBook;
import alfa.view.BooksView;
import alfa.view.InputDataView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BooksController {

    private static final Logger logger = LogManager.getLogger(BooksController.class);


    private BooksView printBooks;
    private ServiceBooks serviceBooks;
    private InputDataView dataView;
    private SearchBooks searchBook;
    private Validation validation;
    private WriteBook write;

    public BooksController() {
        logger.debug("конструктор BooksController вызван");
        printBooks = new BooksView();
        serviceBooks = new ServiceBooks();
        dataView = new InputDataView(printBooks);
        searchBook = new SearchBooks();
        validation = new Validation();
        write = new WriteBook();
    }

    public void execute() {
        while (true) {
            int menuItem = dataView.inputMenuItem();
            switch (menuItem) {
                case 0:
                    System.exit(0);
                case 1:
                    printBooks.printListBooks(serviceBooks.getBookList());
                    break;
                case 2:
                    inputAddBook();
                    break;
                case 3:
                    serviceBooks.increaseCostAll(serviceBooks.getBookList(), dataView.inputUserData());
                    break;
                case 4: inputIncreaseData();
                    break;
                case 5:
                    inputSearchData();
                    break;
                default:
                    printBooks.printMessage(BooksView.ERROR_ENTER);
            }
            logger.debug("End void execute()");
        }
    }

    private void inputAddBook() {
        logger.debug("добавление новой книги");
        String name = dataView.inputString(BooksView.ENTER_TITL);
        String nameValidate = validation.validateNameBook(name);
        String author = dataView.inputString(BooksView.ENTER_AUTHOR);
        String authorValidate = validation.validateAuthorBook(author);
        String publisher = dataView.inputString(BooksView.ENTER_PUBLISHER);
        String publisherValidate = validation.validatePublishBook(publisher);
        String year = dataView.inputString(BooksView.ENTER_YEAR);
        int yearValidate = validation.validateYearBook(year);
        String pages = dataView.inputString(BooksView.ENTER_PAGES);
        int pagesValidate = validation.validateCountPagesBook(pages);
        String cost = dataView.inputString(BooksView.ENTER_COST);
        double costValidate = validation.validateCostBook(cost);
        logger.debug("Add new book from filds: name:{}, author:{}",
                nameValidate, authorValidate);
                serviceBooks.addBook(
                nameValidate,
                authorValidate,
                publisherValidate,
                yearValidate,
                pagesValidate,
                costValidate);
        write.writeBooks(serviceBooks.getBookList());
    }

    private void inputIncreaseData() {
        dataView.inputEmptyString("How to search for a book?");
        List<Book> books = inputSearchData();
        if (!books.isEmpty()) {
            String inputString = dataView.inputString("how much % to increase the cost?");
            logger.debug("increase cost by book {} for :{}",books.toString(),inputString);
            logger.info("increase cost by book for :{}",inputString);
            serviceBooks.increaseCostAll(books, Double.parseDouble(inputString));
        }
    }


    private List<Book> inputSearchData() {
        logger.debug("Start menu of FindBooks");
        while (true) {
        int menuSearchItem = dataView.inputSearchItem();
        List<Book> bookList;

        switch (menuSearchItem) {
            case 0:
                logger.debug("User session end");
                System.exit(0);
            case 1:
                logger.debug("search by name start");
                bookList = searchBook.viewName(serviceBooks.getBookList(), dataView.inputString("enter the name of the book"));
                if (!bookList.isEmpty()) {
                    return bookList;
                } else {
                    System.out.println("");
                }
                break;
            case 2:
                logger.debug("search by author start");
                bookList = searchBook.viewAuthor(serviceBooks.getBookList(), dataView.inputString("enter the author of the book"));
                if (!bookList.isEmpty()) {
                    return bookList;
                } else {
                    System.out.println("");
                }
                break;
            case 3:
                logger.debug("search by publish start");
                bookList = searchBook.viewPublish(serviceBooks.getBookList(), dataView.inputString("enter book publisher"));
                if (!bookList.isEmpty()) {
                    return bookList;
                } else {
                    System.out.println("");
                }
                break;
            case 4:
                logger.debug("search by year start");
                bookList = searchBook.viewYear(serviceBooks.getBookList(), Integer.parseInt(dataView.inputString("enter the year of the book")));
                if (!bookList.isEmpty()) {
                    logger.debug("search by year finish");
                    return bookList;
                } else {
                    logger.debug("search by year finish");
                }
                break;
            case 5:
                logger.debug("search by price start");
                bookList = searchBook.viewCost(serviceBooks.getBookList(), Double.parseDouble(dataView.inputString("enter the starting price")),
                        Double.parseDouble(dataView.inputString("enter the final price")));
                if (!bookList.isEmpty()) {
                    logger.debug("search by price finish");
                    return bookList;
                } else {
                    logger.debug("search by price finish");
                }
                break;
            default:
                printBooks.printMessage(BooksView.ERROR_ENTER);


        } return (inputSearchData());
        }

    }
}

