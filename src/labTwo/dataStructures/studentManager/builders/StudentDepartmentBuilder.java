package labTwo.dataStructures.studentManager.builders;

import labTwo.dataStructures.studentManager.models.Department;

public class StudentDepartmentBuilder<SELF extends StudentDepartmentBuilder<SELF>> extends StudentInformationBuilder<StudentDepartmentBuilder<SELF>> {
    public SELF isInDepartment(Department department) {
        this.student.setDepartment(department);
        return (SELF)this;
    }
}
