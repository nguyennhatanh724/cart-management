import java.time.LocalDate;

//Food: expiryDate (must be today or in the future)
public class Food extends Product{

    private final LocalDate expiryDate;

    public Food(String name, LocalDate expiryDate, double price) {
        super(name, price);
        if (expiryDate == null) {
            throw new IllegalArgumentException("expiryDate must not be null");
        }
        if (expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("expiryDate must be today or in the future");
        }
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return super.toString() + " [expiryDate=" + expiryDate + "]";
    }

}
