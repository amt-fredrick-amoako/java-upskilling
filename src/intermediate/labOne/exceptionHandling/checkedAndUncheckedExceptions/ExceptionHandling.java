package intermediate.labOne.exceptionHandling.checkedAndUncheckedExceptions;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionHandling {

    // checked exception: FileNotFoundException
    public void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        System.out.println("Reading file: " + fileName);
    }

    // throws an unchecked exception
    public void divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        int result = numerator / denominator;
        System.out.println("Result: " + result);
    }

    public void testReadFile() {
        try {
            readFile("somefile.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void testDivide() {
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
