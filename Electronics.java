public class Electronics extends Product {
    private String warrantyPeriod;

    // Constructor
    public Electronics(int productID, String name, String category, double price, int stockQuantity, String warrantyPeriod) {
        super(productID, name, category, price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Getter and Setter
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    // Override calculateDiscount for Electronics
    @Override
    public double calculateDiscount() {
        return 0.1 * getPrice(); // 10% discount for electronics
    }

    @Override
    public String toString() {
        return super.toString() + ", warrantyPeriod='" + warrantyPeriod + '\'';
    }
}