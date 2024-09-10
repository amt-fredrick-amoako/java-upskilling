package foundation.labTwo.dataStructures.studentManager;
import java.util.Scanner;

public class Program {
    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);
        String entry;

        var studentsManager = new StudentsManager(5);

        System.out.println("**** Fun With Arrays ****");
        System.out.println("**** Students Manager Interface ****");

        do {
            System.out.println("\nOptions:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. List Students");
            System.out.println("4. Search Student");
            System.out.println("q. Quit");
            System.out.print("Enter your choice: ");
            entry = scanner.nextLine().trim();
            String name;

            switch (entry) {
                case "1":
                    try {
                        studentsManager.addStudent(scanner);
                        System.out.println("Student added successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid year level. Please try again.");
                    }
                    break;
                case "2":
                    System.out.print("Enter student name to remove: ");
                    name = scanner.nextLine().trim();
                    studentsManager.removeStudent(name);
                    break;
                case "3":
                    studentsManager.printStudents();
                    break;
                case "4":
                    System.out.print("Enter student name to search: ");
                    name = scanner.nextLine().trim();
                    studentsManager.getStudent(name);
                    break;
                case "q":
                case "quit":
                    System.out.println("Quitting the Students Manager Interface.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!entry.equalsIgnoreCase("q") && !entry.equalsIgnoreCase("quit"));

        scanner.close();
    }
}
