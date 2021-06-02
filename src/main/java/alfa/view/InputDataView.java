package alfa.view;

import java.util.Scanner;

public class InputDataView {
    private Scanner scanner = new Scanner((System.in));
    private BooksView booksView;

    public InputDataView(BooksView bookView) {
        this.booksView = bookView;
    }

    public int inputMenuItem() {
        booksView.printMenu();
        booksView.printMessage(BooksView.ENTER_COMMAND);
        while (!scanner.hasNextInt()) {
            scanner.next();
            booksView.printMessage(BooksView.ERROR_ENTER);
        }
        return scanner.nextInt();

    }

    public int inputSearchItem() {
        booksView.printSearch();
        booksView.printMessage(BooksView.ENTER_COMMAND);
        while (!scanner.hasNextInt()) {
            scanner.next();
            booksView.printMessage(BooksView.ERROR_ENTER);
        }
        return scanner.nextInt();
    }

    public int inputUserData() {
        booksView.printMessage(BooksView.ENTER_USER);
        while (!scanner.hasNextInt()) {
            scanner.next();
            booksView.printMessage(BooksView.ERROR_ENTER);
        }
        return scanner.nextInt();

    }

    public String inputString(String message){
        booksView.printMessage(message);
        return scanner.next();
    }

    public void inputEmptyString(String message){
        booksView.printMessage(message);
    }

}
