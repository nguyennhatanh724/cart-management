import java.time.LocalDate;

//Food: expiryDate
public class Food implements Product{
    private final String name;
    private final Double price;
    private final LocalDate expiryDate;

    public Food(String name, Double price, LocalDate expiryDate) {
        if(name == null || name.isBlank() ){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if(price.isInfinite() || price.isNaN() || price < 0.0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if(expiryDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Expiry Date cannot be after now");
        }
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
