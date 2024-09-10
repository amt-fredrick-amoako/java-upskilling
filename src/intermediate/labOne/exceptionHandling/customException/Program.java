package intermediate.labOne.exceptionHandling.customException;

public class Program {
    public static void main(String... args) {
        BankAccount account = new BankAccount(100.00); // Initial balance is $100

        try {
            account.withdraw(150.00); // Trying to withdraw $150
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Please enter a different amount or make a deposit.");
        }
    }
}
