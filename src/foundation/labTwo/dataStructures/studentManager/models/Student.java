package foundation.labTwo.dataStructures.studentManager.models;

import foundation.labTwo.dataStructures.studentManager.builders.StudentDepartmentBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Student {
    private String fullName;
    private int age;
    private LocalDate birthDate;
    private YearLevel yearLevel;
    private Gender gender;
    private Department department;
    private List<Course> courses;



    public Student(String fullName, LocalDate birthDate, YearLevel yearLevel, Department department, Gender gender) {
        this.fullName = fullName;
        this.age = LocalDate.now().getYear() - birthDate.getYear();
        this.birthDate = birthDate;
        this.yearLevel = yearLevel;
        this.department = department;
        this.gender = gender;
        this.courses = new ArrayList<>(yearLevel.getDefaultValue());
    }

    public Student(){
        this.courses = new ArrayList<>(8);
    }

    @Override
    public String toString() {
        return "{\n Full name: " + getFullName() + ",\n Age: "+ getAge() + ", Level: " + getYearLevel() + ",\n Department: " + department.getName() + ",\n Gender: " + getGender() +  ",\n Courses: " + getCourses() + " \n}";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return this.age = LocalDate.now().getYear() - birthDate.getYear();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public YearLevel getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(YearLevel yearLevel) {
        this.yearLevel = yearLevel;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static Builder startBuilder(){
        return new Builder();
    }

    // builder interface for building student information.
    public static class Builder extends StudentDepartmentBuilder<Builder> {}
}
