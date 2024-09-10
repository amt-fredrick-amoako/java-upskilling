package intermediate.labTwo.designPatterns.structural.facade;

public class ShippingService {
    public void scheduleDelivery(String orderId) {
        System.out.println("Delivery scheduled for order: " + orderId);
    }
}
