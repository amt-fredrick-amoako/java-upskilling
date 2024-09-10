package intermediate.labTwo.designPatterns.structural.facade;

public class OrderFacade {
    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();
    private OrderService orderService = new OrderService();

    public String placeOrder(String userId, String itemId, int quantity, String paymentDetails) {
        if (inventoryService.checkInventory(itemId)) {
            inventoryService.reserveInventory(itemId, quantity);
            if (paymentService.processPayment(paymentDetails)) {
                String orderId = orderService.createOrder(userId, itemId, quantity);
                shippingService.scheduleDelivery(orderId);
                return orderId;
            } else {
                System.out.println("Payment failed for order.");
                return null;
            }
        } else {
            System.out.println("Item is out of stock.");
            return null;
        }
    }

    public void cancelOrder(String orderId) {
        orderService.updateOrderStatus(orderId, "Cancelled");
        System.out.println("Order " + orderId + " has been cancelled.");
    }
}
