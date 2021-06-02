package alfa.model.entity;

public class Book {
    private String name;
    private String author;
    private String publish;
    private int year;
    private int countPages;
    private double cost;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getCountPages() {
        return countPages;
    }
    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public Book() {    }

    public Book(String name,
                String author,
                String publish,
                int year,
                int countPages,
                double cost) {
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.year = year;
        this.countPages = countPages;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name +
                ", author='" + author +
                ", publish='" + publish +
                ", year=" + year +
                ", countPages=" + countPages +
                ", cost=" + cost +
                '}';
    }
}
