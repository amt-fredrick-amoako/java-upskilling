package intermediate.labOne.exceptionHandling.customException;

public class InsufficientFundsException extends Exception {
    private double amountRequested;
    private double balanceAvailable;

    public InsufficientFundsException(double amountRequested, double balanceAvailable) {
        super("Attempted to withdraw " + amountRequested + " with only " + balanceAvailable + " available.");
        this.amountRequested = amountRequested;
        this.balanceAvailable = balanceAvailable;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public double getBalanceAvailable() {
        return balanceAvailable;
    }
}
