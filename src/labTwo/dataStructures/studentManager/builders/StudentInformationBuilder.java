package labTwo.dataStructures.studentManager.builders;

import labTwo.dataStructures.studentManager.models.Course;
import labTwo.dataStructures.studentManager.models.Gender;
import labTwo.dataStructures.studentManager.models.YearLevel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class StudentInformationBuilder<SELF extends StudentInformationBuilder<SELF>> extends StudentBuilder {

    public SELF isCalled(String name) {
        this.student.setFullName(name);
        return (SELF)this;
    }

    public SELF isA(Gender gender) {
        this.student.setGender(gender);
        return (SELF)this;
    }

    public SELF wasBornOn(LocalDate dateOfBirth) {
        this.student.setBirthDate(dateOfBirth);
        return (SELF)this;
    }

    public SELF reads(List<Course> courses) {
        this.student.setCourses(courses);
        return (SELF)this;
    }

    public SELF isInYear(YearLevel year) {
        this.student.setYearLevel(year);
        return (SELF)this;
    }
}
