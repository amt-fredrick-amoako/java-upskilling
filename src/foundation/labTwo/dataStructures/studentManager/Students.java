package foundation.labTwo.dataStructures.studentManager;

public class Students {
    private int maxSize;
    private String[] students;
    private int currentIndex;

    public Students(int maxSize) {
        this.students = new String[maxSize];
        this.maxSize = maxSize;
        currentIndex = 0;
    }

    public void addStudent(String name){
        if (currentIndex >= maxSize){
            System.out.println("Error: The student is over max students size");
            return;
        }
        this.students[currentIndex] = name;
        currentIndex++;
    }

    public String getStudent(String name){
        int index;
        for(int i = 0; i < currentIndex; i++){
            if(students[i].equals(name)){
                index = i;
                System.out.println("Found student: " + students[i] + " at index: " + index);
                return students[i];
            }
        }

        return "Error: The student does not exist";
    }

    public void removeStudent(String name){
        int index;
        for(int i = 0; i < currentIndex; i++){
            if(students[i].equals(name)){
                students[i] = null;
                System.out.println("Student removed");
                return;
            }
        }

        System.out.println("Error: The student does not exist");
    }

    public void printStudents(){
        if(currentIndex == 0){
            System.out.println(" ");
            return;
        }
        String start = "\"";
        for(String student : students){

            if (student != null) {
                start += student + ",";
            }
        }
        start += "\"";
        System.out.println(start);
    }
}
