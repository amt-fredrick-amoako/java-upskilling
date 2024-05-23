package labTwo.dataStructures.studentManager.builders;

import labTwo.dataStructures.studentManager.models.Course;

import java.util.ArrayList;
import java.util.List;

public class CoursesGenerator {
    private List<Course> courses;

    public CoursesGenerator() {
        courses = new ArrayList<>();
    }

    public CoursesGenerator addCourse(Course course) {
        this.courses.add(course);
        return this;
    }

    public List<Course> generate() {
        return this.courses;
    }
}
