/**
 * Base class for all products
 */
public abstract class Product {
    private final String name;
    private final double price;

    protected Product(String name, double price) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        if (Double.isNaN(price) || Double.isInfinite(price) || price < 0) throw new IllegalArgumentException("price >= 0");
        this.name = name.trim();
        this.price = price;
    }
    public final String getName() { return name; }
    public final double getPrice() { return price; }

    @Override
    public String toString() {
        return "%s{name='%s', price=%.2f}"
                .formatted(getClass().getSimpleName(), name, price);
    }

}
