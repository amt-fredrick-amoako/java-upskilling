package foundation.labTwo.dataStructures.studentManager.models;

public class Course {

    private String name;
    private String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course [name=" + name + ", description=" + description + "]";
    }
}
