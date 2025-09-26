

//Clothing: size, material
public class Clothing implements Product {
    private final String name;
    private final String material;
    private final Double price;
    private final String size;

    public Clothing(String name, String material, Double price, String size) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException("Material cannot be null");
        }
        if (price.isInfinite() || price.isNaN() || price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (size == null || size.isBlank()) {
            throw new IllegalArgumentException("Size cannot be null or blank");
        }
        this.name = name;
        this.material = material;
        this.price = price;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
