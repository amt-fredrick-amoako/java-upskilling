package foundation.labTwo.dataStructures.studentManager.builders;

import foundation.labTwo.dataStructures.studentManager.models.Student;

public class StudentBuilder {
    protected Student student = new Student();

    public Student build(){
        return student;
    }
}
