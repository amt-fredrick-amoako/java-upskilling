package labOne.mortgageCalculator;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageUI {
    private final Scanner scanner;
    private final MortgageCalculator calculator;

    public MortgageUI(){
        this.scanner = new Scanner(System.in);
        this.calculator = new MortgageCalculator();
    }

    public void run(){
        try {
            printBanner();
            float principal = getPrincipal();
            float annualInterestRate = getAnnualInterestRate();
            byte years = getYears();
            double mortgage = calculator.calculateMortgage(principal, annualInterestRate, years);
            displayMortgage(mortgage);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private float getPrincipal(){
        while(true){
            try {
                System.out.println("Principal:");
                float principal = scanner.nextFloat();
                if(principal >= 1000 && principal <= 1_000_000){
                    return principal;
                }
                System.out.println("Enter a value between 1000 and 1000000.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private float getAnnualInterestRate(){
        while (true) {
            try {
                System.out.println("Annual Interest Rate:");
                float rate = scanner.nextFloat();
                if (rate > 0) {
                    return rate;
                }
                System.out.println("Please enter a positive rate.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private byte getYears(){
        while (true) {
            try {
                System.out.println("Period (Years):");
                byte years = scanner.nextByte();
                if (years > 0) {
                    return years;
                }
                System.out.println("Please enter a positive number of years.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public void printBanner() {
        String banner = """
                #######################
                # Mortgage Calculator #
                #######################""";
        System.out.println(banner);
    }

    private void displayMortgage(double mortgage){
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    static class MortgageCalculator {
        private static final byte MONTHS_IN_YEAR = 12;
        private static final byte PERCENTAGE = 100;

        public double calculateMortgage(float principal, float annualInterestRate, byte years){
            float monthlyInterest = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;
            int numberOfPayments = years * MONTHS_IN_YEAR;
            return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        }
    }
}