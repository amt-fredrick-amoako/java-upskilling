package intermediate.labTwo.designPatterns.structural.adapter;

public interface ModernPaymentGateway {
    void processPayment(String paymentToken, double amount, String currency, String callbackUrl);
}
