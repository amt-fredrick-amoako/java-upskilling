package labTwo.dataStructures.studentManager;

import labTwo.dataStructures.studentManager.builders.CoursesGenerator;
import labTwo.dataStructures.studentManager.models.*;

import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String...args) {
//        Students students = new Students(5);
//        students.addStudent("Fredrick Amoako");
//        students.addStudent("Kweku Anokye");
//        students.getStudent("Kweku Anokye");
//        students.removeStudent("Kweku Anokye");
//        students.printStudents();

        // var student = new Student();
        // student.setCourses(courses);
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
            System.out.println("q. Quit");
            System.out.print("Enter your choice: ");
            entry = scanner.nextLine().trim();

            switch (entry) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter year level (FRESHER, SOPHOMORE, JUNIOR, SENIOR): ");
                    String yearLevelStr = scanner.nextLine().trim().toUpperCase();
                    try {
                        YearLevel yearLevel = YearLevel.valueOf(yearLevelStr);
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

        var courses = new CoursesGenerator()
                .addCourse(new Course("Data Structures", "Learn data structures and algorithms"))
                .addCourse(new Course("Discrete Maths", "Advanced level maths."))
                .addCourse(new Course("Numerical Methods", "Prepare to have your mind blown away!"))
                .generate();

        /**
         * create list of students.
         * add students to students manager
         * interact with students manager for students.
         */
//        var student = Student.startBuilder()
//                .isCalled("Fredrick Amoako")
//                .isA(Gender.MALE)
//                .wasBornOn(new Date(2000, 11, 29))
//                .reads(courses)
//                .isInDepartment(new Department("IT Department"))
//                .isInYear(YearLevel.SENIOR)
//                .build();
//        System.out.println(student);
    }
}
