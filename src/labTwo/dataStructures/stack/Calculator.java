package labTwo.dataStructures.stack;

public class Calculator {
    private Stack stack;

    public Calculator() {
        stack = new Stack();
    }

    public void push(String data) {
        this.stack.push(data);
    }

    public String pop() {
        return this.stack.pop();
    }

    public void calculate() {
        String operator = this.stack.pop();
        double operand2 = Double.parseDouble(this.stack.pop());
        double operand1 = Double.parseDouble(this.stack.pop());

        switch (operator) {
            case "+":
                this.stack.push(String.valueOf(operand1 + operand2));
                break;
            case "-":
                this.stack.push(String.valueOf(operand1 - operand2));
                break;
            case "*":
                this.stack.push(String.valueOf(operand1 * operand2));
                break;
            case "/":
                if (operand2 != 0) {
                    this.stack.push(String.valueOf(operand1 / operand2));
                } else {
                    throw new Error("Cannot divide by zero!");
                }
                break;
            default:
                throw new Error("Invalid operator!");
        }
    }
}
