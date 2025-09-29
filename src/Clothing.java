

//Clothing has size, material
public class Clothing extends Product {

    private final String material;
    private final String size;

    public Clothing(String name, String size, String material, double price) {
        super(name, price);
        if (size == null || size.isBlank()) {
            throw new IllegalArgumentException("size must not be blank");
        }
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException("material must not be blank");
        }
        this.size = size.trim();
        this.material = material.trim();
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + " [size='" + size + "', material='" + material + "']";
    }
}
