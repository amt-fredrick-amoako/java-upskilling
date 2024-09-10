package intermediate.labTwo.designPatterns.structural.adapter;

public class PaymentAdapter implements ModernPaymentGateway {
    private LegacyPaymentProcessor legacyProcessor;
    private UserManagementService userService;

    public PaymentAdapter(LegacyPaymentProcessor legacyProcessor, UserManagementService userService) {
        this.legacyProcessor = legacyProcessor;
        this.userService = userService;
    }

    @Override
    public void processPayment(String paymentToken, double amount, String currency, String callbackUrl) {
        // Convert token to user ID (assuming user service can do this)
        String userId = userService.getUserIdFromToken(paymentToken);

        // Use the legacy system to process the payment
        legacyProcessor.makePayment(userId, amount, currency);

        // Optionally, handle the callback
        notifyCallback(callbackUrl, "Payment processed successfully for " + amount + " " + currency);
    }

    private void notifyCallback(String url, String message) {
        // Simulate a callback notification
        System.out.println("Callback to " + url + " with message: " + message);
    }
}
