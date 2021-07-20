package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Student {
    private String firstName;

    @JsonIgnore
    private String secondName;
    private int ade;
    private List <Course> completedCourse;

    public Student(String firstName, String secondName, int ade, List<Course> completedCourse) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.ade = ade;
        this.completedCourse = completedCourse;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAde() {
        return ade;
    }

    public void setAde(int ade) {
        this.ade = ade;
    }

    public List<Course> getCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(List<Course> completedCourse) {
        this.completedCourse = completedCourse;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", ade=" + ade +
                ", completedCourse=" + completedCourse +
                '}';
    }
}
