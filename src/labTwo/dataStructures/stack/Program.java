package labTwo.dataStructures.stack;

public class Program {

    public static void main(String[]args) {
        Calculator calculator = new Calculator();
        calculator.push("10");
        calculator.push("20");
        calculator.push("/");
        calculator.calculate();

        System.out.println("Result: " + calculator.pop());
    }
}

