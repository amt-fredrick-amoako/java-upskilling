package labTwo.dataStructures.studentManager;

import labTwo.dataStructures.studentManager.builders.CoursesGenerator;
import labTwo.dataStructures.studentManager.models.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentsManager {
    private int maxSize;
    private Student[] students;
    private int currentIndex;

    public StudentsManager(int maxSize) {
        this.students = new Student[maxSize];
        this.maxSize = maxSize;
        currentIndex = 0;
    }

    public void addStudent(Student student){
        if (currentIndex >= maxSize){
            throw new IndexOutOfBoundsException();
        }
        this.students[currentIndex] = student;
        currentIndex++;
    }

    public Student getStudent(String name){
        if (currentIndex == 0){
            throw new Error("There are no registered students, consider adding students first");
        }

        int index;
        for(int i = 0; i < currentIndex; i++){
            if(students[i].getFullName().equalsIgnoreCase(name)){
                index = i;
                System.out.println("Found student: " + students[i] + " at index: " + index);
                return students[i];
            }
        }

        throw new Error("No student found with name: " + name);
    }

    public void removeStudent(String name) {
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (students[i].getFullName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: The student does not exist");
            return;
        }

        for (int i = index; i < currentIndex - 1; i++) {
            students[i] = students[i + 1];
        }

        students[currentIndex - 1] = null;
        currentIndex--;
        System.out.println("Student removed");
    }

    public void printStudents(){
        if(currentIndex == 0){
            System.out.println(" ");
            return;
        }
        String start = "\"\n[";
        for(var student : students){

            if (student != null) {
                start += student + ",";
            }
        }
        start += "]\"";
        System.out.println(start);
    }

    public void addStudent(Scanner scanner) {

        if (currentIndex >= maxSize) {
            System.out.println("Error: The student is over max students size");
            return;
        }

        var studentBuilder = Student.startBuilder();
        var coursesGenerator = new CoursesGenerator();

        String name = getStudentName(scanner);

        YearLevel yearLevel = getStudentYearLevel(scanner);
        if (yearLevel == null) return;

        Gender gender = getGender(scanner);
        if (gender == null) return;

        var dob = getDateOfBirth(scanner);

        var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var date = LocalDate.parse(dob, dateFormatter);

        String department = getDepartment(scanner);

        while (true) {
            System.out.print("Do you want to add a course for the student? (yes/no): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("no")) {
                break;
            }

            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine().trim();
            System.out.print("Enter course description: ");
            String description = scanner.nextLine().trim();
            coursesGenerator.addCourse(new Course(courseName, description));
        }

        var courses = coursesGenerator.generate();
        var student = studentBuilder
                .isCalled(name)
                .isA(gender)
                .wasBornOn(date)
                .isInYear(yearLevel)
                .isInDepartment(new Department(department))
                .reads(courses)
                .build();

        students[currentIndex] = student;
        currentIndex++;
        System.out.println("Student added successfully");
    }

    // get inputs from user
    private static String getDepartment(Scanner scanner) {
        System.out.print("Enter department: ");
        String department = scanner.nextLine().trim();
        System.out.println("Department name: " + department);
        return department;
    }

    private static Gender getGender(Scanner scanner) {
        System.out.println("Enter gender (MALE, FEMALE, NOT_SPECIFIED): ");
        String genderStr = scanner.nextLine().trim().toUpperCase();
        System.out.println("Selected gender: " + genderStr);

        Gender gender;

        try {
            gender = Gender.valueOf(genderStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender selected. Please try again.");
            return null;
        }
        return gender;
    }

    private static YearLevel getStudentYearLevel(Scanner scanner) {
        System.out.print("Enter year level (FRESHER, SOPHOMORE, JUNIOR, SENIOR): ");
        String yearLevelStr = scanner.nextLine().trim().toUpperCase();
        System.out.println("Selected year for student: " + yearLevelStr);

        YearLevel yearLevel;

        try {
            yearLevel = YearLevel.valueOf(yearLevelStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid year level selected. Please try again.");
            return null;
        }
        return yearLevel;
    }

    private static String getStudentName(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Student's full name: " + name);
        return name;
    }

    private static String getDateOfBirth(Scanner scanner){
        System.out.println("Enter student's date of birth \"dd/MM/yyy\"");
        String dateOfBirth = scanner.nextLine().trim();
        System.out.println("Student's date of birth: " + dateOfBirth);
        return dateOfBirth;
    }
}
