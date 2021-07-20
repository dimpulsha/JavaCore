package ru.geekbrains.javacore.dimpulsha.lesson9;

import java.util.List;

public class CourseItem implements Course {
    private String courseName;

    public CourseItem(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CourseItem{" +
                "courseName='" + courseName + '\'' +
                '}';
    }

    @Override
    public String getCourse() {
        return courseName;
    }
}
