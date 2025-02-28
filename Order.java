import java.util.List;

public class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetails;

    // Constructor
    public Order(int orderID, int userID, List<OrderDetails> orderDetails) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetails = orderDetails;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", orderDetails=" + orderDetails +
                '}';
    }
}