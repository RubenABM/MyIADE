package pt.iade.myiade.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Enrolment {
    @JsonIgnoreProperties({"enrolments"})
    private Student student;
    @JsonIgnoreProperties({"enrolments"})
    private Course course;
    private double grade;

    public Enrolment(Student student, Course course, double grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }
    public Student getStudent() {
        return student;
    }
    public Course getCourse() {
        return course;
    }
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade)
    {
    this.grade = grade;
    }
}
