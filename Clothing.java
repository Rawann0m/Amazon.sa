public class Clothing extends Product {
    private String size;

    // Constructor
    public Clothing(int productID, String name, String category, double price, int stockQuantity, String size) {
        super(productID, name, category, price, stockQuantity);
        this.size = size;
    }

    // Getter and Setter
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Override calculateDiscount for Clothing
    @Override
    public double calculateDiscount() {
        return 0.05 * getPrice(); // 5% discount for clothing
    }

    @Override
    public String toString() {
        return super.toString() + ", size='" + size + '\'';
    }
}