package intermediate.labTwo.designPatterns.structural.adapter;

public class LegacyPaymentProcessor {
    public void makePayment(String userId, double amount, String currency) {
        // Process payment here
        System.out.println("Processing payment for user " + userId + " for amount " + amount + " " + currency);
    }
}