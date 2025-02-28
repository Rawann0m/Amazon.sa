import java.util.*;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static Map<Integer, List<Order>> userOrderHistory = new HashMap<>(); // Updated to store all orders per user
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize some products
        products.add(new Electronics(1, "Laptop", "Electronics", 1200, 10, "1 Year"));
        products.add(new Clothing(2, "T-Shirt", "Clothing", 20, 50, "Medium"));

        while (true) {
            System.out.println("\n1. Place Order");
            System.out.println("2. View Order History");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    viewOrderHistory();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void placeOrder() {
        try {
            System.out.print("Enter User ID: ");
            int userID = scanner.nextInt();

            System.out.println("Available Products:");
            for (Product product : products) {
                System.out.println(product);
            }

            System.out.print("Enter Product ID: ");
            int productID = scanner.nextInt();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            // Find the product
            Product product = products.stream()
                    .filter(p -> p.getProductID() == productID)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Product not found!"));

            // Check stock
            if (product.getStockQuantity() < quantity) {
                throw new OutOfStockException("Insufficient stock for product: " + product.getName());
            }

            // Calculate subtotal
            double subTotal = product.getPrice() * quantity;

            // Create order details
            OrderDetails orderDetails = new OrderDetails(1, userOrderHistory.size() + 1, productID, quantity, subTotal);

            // Create order
            Order order = new Order(userOrderHistory.size() + 1, userID, Collections.singletonList(orderDetails));

            // Update stock
            product.setStockQuantity(product.getStockQuantity() - quantity);

            // Add to user order history
            userOrderHistory.computeIfAbsent(userID, k -> new ArrayList<>()).add(order);

            System.out.println("Order placed successfully!");
        } catch (OutOfStockException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewOrderHistory() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();

        List<Order> orders = userOrderHistory.get(userID);
        if (orders != null && !orders.isEmpty()) {
            System.out.println("Order History for User ID " + userID + ":");
            for (Order order : orders) {
                System.out.println(order);
            }
        } else {
            System.out.println("No orders found for User ID " + userID);
        }
    }
}