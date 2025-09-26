import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Demo for the cart-management system

        Cart cart = new Cart();

        // Create some products (using Double for prices as you chose)
        Product cleanCode = new Book("Clean Code", 39.99, "Robert C. Martin", 2008 );
        Product tshirt     = new Clothing("T-Shirt", "Cotton", 12.05, "L");
        Product milk       = new Food("Milk 1L", 1.35, LocalDate.now().plusDays(3));

        // Add items to cart (duplicates should merge quantities)
        cart.add(cleanCode, 1);
        cart.add(tshirt, 2);
        cart.add(milk, 3);
        cart.add(tshirt, 1); // now T-Shirt qty = 3

        // Update quantity and remove an item
        cart.updateQuantity("T-Shirt", 4);
        cart.remove("Milk 1L");

        // Print invoice and total
        cart.printInvoice();

        // Access total programmatically if needed
        System.out.println("Grand total = " + cart.getTotal());
    }
}
