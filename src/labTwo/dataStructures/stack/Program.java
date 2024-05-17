package labTwo.dataStructures.stack;

import java.util.Scanner;

public class Program {

    public static void main(String[]args) {
        Calculator calculator = new Calculator();
        calculator.push("10");
        calculator.push("20");
        calculator.push("/");

        calculator.calculate();

        System.out.println("Result: " + calculator.pop());
    }

//    void runCalculator() {
//        Scanner scanner = new Scanner(System.in);
//
//        while(scanner.nextLine() != "q") {
//
//        }
//    }
}

