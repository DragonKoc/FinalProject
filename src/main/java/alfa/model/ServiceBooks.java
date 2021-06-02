package alfa.model;

import alfa.model.entity.Book;
import alfa.util.WriteBook;

import java.util.ArrayList;
import java.util.List;

public class ServiceBooks {
    private List<Book> booklist;
    private WriteBook writeBook;


    public ServiceBooks(){
        booklist = SourceBooks.getAllBooks();
    }

    public List<Book> getBookList(){
        return  (List<Book>)(new ArrayList<Book>(booklist).clone());
    }

    public void addBook(String name, String author, String publish, int year, int countPages, double cost){
        booklist.add(new Book(name,author,publish,year,countPages,cost));;
    }

    public void increaseCostAll(List<Book> booklist, double newcost) {
        for (Book elem : booklist) {
            double costbook = elem.getCost();
            elem.setCost(costbook + costbook * newcost / 100);
        }
        writeBook.writeBooks(getBookList());
        System.out.println("All find books increase price");
    }

}
