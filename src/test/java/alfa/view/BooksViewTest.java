package alfa.view;

import org.junit.Before;
import org.junit.Test;

public class BooksViewTest {
    private BooksView booksView;

    @Before
    public void initialize(){
        booksView = new BooksView();
    }

    @Test
    public void printMessage() {
        booksView.printMessage("string");;
    }

}