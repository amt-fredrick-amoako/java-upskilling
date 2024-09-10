package intermediate.labTwo.designPatterns.structural.facade;

public class PaymentService {
    public boolean processPayment(String paymentDetails) {
        // Process the payment
        System.out.println("Payment processed for: " + paymentDetails);
        return true; // Assume the payment is successful
    }
}