import java.util.Objects;

//Book: has author, year
public class Book extends Product {

    private final String author;
    private final int year;

    public Book(String name, String author, int year, double price) {
        super(name, price);
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author must not be blank");
        }
        if (year < 0) {
            throw new IllegalArgumentException("year must be >= 0");
        }
        this.author = author.trim();
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return super.toString() + " [author='" + author + "', year=" + year + "]";
    }

}
