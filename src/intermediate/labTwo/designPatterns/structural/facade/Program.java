package intermediate.labTwo.designPatterns.structural.facade;

public class Program {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();
        String orderId = orderFacade.placeOrder("USER123", "ITEM456", 2, "Credit Card Info");

        if (orderId != null) {
            System.out.println("Order placed successfully. Order ID: " + orderId);
        }

        // Example of cancelling an order
        orderFacade.cancelOrder(orderId);
    }
}
