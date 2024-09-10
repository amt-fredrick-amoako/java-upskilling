package intermediate.labTwo.designPatterns.structural.facade;

public class OrderService {
    public String createOrder(String userId, String itemId, int quantity) {
        System.out.println("Order created for user: " + userId);
        return "ORDER12345"; // Dummy order ID
    }

    public void updateOrderStatus(String orderId, String status) {
        System.out.println("Order " + orderId + " updated to status: " + status);
    }
}