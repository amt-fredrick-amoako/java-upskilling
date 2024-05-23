package labTwo.dataStructures.studentManager.builders;

import labTwo.dataStructures.studentManager.models.Student;

public class StudentBuilder {
    protected Student student = new Student();

    public Student build(){
        return student;
    }
}
