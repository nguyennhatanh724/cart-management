import java.util.*;

/**
 * Shopping Cart that holds many CartItem
 * Works via Product interface
 * Keyed by product name to merge quantities of the same product name
 */
public class Cart {

    private final Map<String, CartItem> items = new LinkedHashMap<>();

    /**
     * Add a product with a quantity. If same name exists → increase quantity.
     */
    public void add(Product p, int qty) {
        if (p == null) throw new IllegalArgumentException("product == null");
        if (qty <= 0) throw new IllegalArgumentException("qty must be > 0");

        // Gộp số lượng theo tên sản phẩm
        CartItem existing = items.get(p.getName());
        if (existing == null) {
            items.put(p.getName(), new CartItem(p, qty));
        } else {
            existing.setQuantity(existing.getQuantity() + qty);
        }
    }

    /**
     * Remove item by product name. Returns true if it existed.
     */
    public boolean remove(String productName) {
        if (productName == null || productName.isBlank()) return false;
        return items.remove(productName) != null;
    }

    /**
     * Set a new quantity for an item; throws if item not found or qty invalid.
     */
    public void updateQuantity(String productName, int newQty) {
        CartItem it = items.get(productName);
        if (it == null) throw new NoSuchElementException("Item not in cart: " + productName);
        it.setQuantity(newQty); // CartItem tự validate > 0
    }

    /**
     * Clear the whole cart.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Current total (sum of unitPrice * quantity) in double.
     */
    public double getTotal() {
        double sum = 0.0;
        for (CartItem ci : items.values()) {
            sum += ci.getProduct().getPrice() * ci.getQuantity();
        }
        return sum;
    }

    /**
     * Read-only view of items.
     */
    public Collection<CartItem> getItems() {
        return Collections.unmodifiableCollection(items.values());
    }

    /**
     * Print a simple invoice: name, unit price, qty, line total, and grand total.
     */
    public void printInvoice() {
        System.out.println("=== INVOICE ===");
        if (items.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (CartItem ci : items.values()) {
            double unit = ci.getProduct().getPrice();
            int qty = ci.getQuantity();
            double line = unit * qty;
            System.out.printf("- %-18s | unit=%6.2f | qty=%3d | line=%7.2f%n",
                    ci.getProduct().getName(), unit, qty, line);
        }
        System.out.println("-------------------------------");
        System.out.printf("TOTAL: %.2f%n", getTotal());
    }
}
