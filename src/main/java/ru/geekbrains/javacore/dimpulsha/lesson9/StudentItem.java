package ru.geekbrains.javacore.dimpulsha.lesson9;

import java.util.List;

public class StudentItem implements Student{
    private String name;
    private List<Course> courseList;

    public StudentItem(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public void printCourses() {
        courseList.forEach(cName -> System.out.println(cName));
    }
}
