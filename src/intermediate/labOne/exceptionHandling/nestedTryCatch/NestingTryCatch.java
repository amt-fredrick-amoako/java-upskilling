package intermediate.labOne.exceptionHandling.nestedTryCatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NestingTryCatch {
    public static void processFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            int sum = 0;

            try {
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    try {
                        int num = Integer.parseInt(data);
                        sum += num;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid integer in file: " + data);
                        // Handle non-integer data gracefully, e.g., skip this data
                    }
                }
                System.out.println("Sum of all valid integers: " + sum);
            } finally {
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + filePath);
            // Handle the case where the file does not exist
        }
    }
}
