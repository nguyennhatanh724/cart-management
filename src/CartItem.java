/**
 * A single line item in the shopping cart.
 * The item is responsible for validating its own invariants (quantity > 0).
 */
public class CartItem {
    // The product being purchased. Immutable
    private final Product product;

    //Number of units for this product. Mutable
    private int quantity;

    /**
     * Constructs a new cart line item.
     *
     * @param product the product (must not be {@code null})
     * @param quantity initial quantity (must be {@code > 0})
     * @throws IllegalArgumentException if {@code product == null} or {@code quantity <= 0}
     */
    public CartItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Computes the line total = unit price * quantity.
     *
     * @return the monetary total for this line item
     */
    public Double lineTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Cartitem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
