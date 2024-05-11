package labTwo.dataStructures.studentManager;

public class Program {
    public static void main(String...args) {
        Students students = new Students(5);
        students.addStudent("Fredrick Amoako");
        students.addStudent("Kweku Anokye");
        students.getStudent("Kweku Anokye");
        students.removeStudent("Kweku Anokye");
        students.printStudents();
    }
}
