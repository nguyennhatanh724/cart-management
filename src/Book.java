import java.util.Objects;

//Book: has author, year
public class Book implements Product {
    private final String name;
    private final Double price;
    private final String author;
    private final int year;

    public Book(String name, Double price, String author, int year) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Book name cannot be null or blank");
        }
        if (price.isInfinite() || price.isNaN() || price < 0.0) {
            throw new IllegalArgumentException("Book price cannot be negative");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or blank");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Book year cannot be negative");
        }
        this.name = Objects.requireNonNull(name).trim();
        this.price = price;
        this.author = Objects.requireNonNull(author).trim();
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" + name + ", " + author + ", " + year + ", " + price + "}";
    }

}
