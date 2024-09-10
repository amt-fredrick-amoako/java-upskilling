package intermediate.labTwo.designPatterns.structural.adapter;

public class Program {
    public static void main(String[] args) {
        LegacyPaymentProcessor legacyProcessor = new LegacyPaymentProcessor();
        UserManagementService userService = new UserManagementService();
        PaymentAdapter adapter = new PaymentAdapter(legacyProcessor, userService);

        // Modern API call
        adapter.processPayment("token123", 100.00, "USD", "http://callback.example.com/payment");
    }
}
