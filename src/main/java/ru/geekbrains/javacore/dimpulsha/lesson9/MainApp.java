package ru.geekbrains.javacore.dimpulsha.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {

        Course c1 = new CourseItem("Иностранный язык");
        Course c2 = new CourseItem("Физика");
        Course c3 = new CourseItem("История");
        Course c4 = new CourseItem("Алгебра");
        Course c5 = new CourseItem("Химия");
        Course c6 = new CourseItem("Искусство");
        Course c7 = new CourseItem("Геометрия");
        Course c8 = new CourseItem("Астрономия");
        Course c9 = new CourseItem("Военная подготовка");


        Student s1 = new StudentItem("Петров", new ArrayList<Course>(Arrays.asList(c2, c3, c5, c8)));
        Student s2 = new StudentItem("Васечкин", new ArrayList<Course>(Arrays.asList(c1, c4, c6)));
        Student s3 = new StudentItem("Потапов", new ArrayList<Course>(Arrays.asList(c2, c6, c3)));
        Student s4 = new StudentItem("Гермиона", new ArrayList<Course>(Arrays.asList(c3, c4, c5, c6, c7, c1)));
        Student s5 = new StudentItem("Пофигист", new ArrayList<Course>(Arrays.asList(c4, c5)));
        Student s6 = new StudentItem("Карапузов", new ArrayList<Course>(Arrays.asList(c6, c7, c8)));
        Student s7 = new StudentItem("Зеленый", new ArrayList<Course>(Arrays.asList(c7, c8, c1, c2)));
        Student s8 = new StudentItem("Знайкин", new ArrayList<Course>(Arrays.asList(c2, c3, c4, c5, c6)));
        Student s9 = new StudentItem("Сыроежкин", new ArrayList<Course>(Arrays.asList(c3, c4, c5, c6)));

        //       s1.printCourses();

        List<Student> studentList = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9));
        // Список курсов, на котрые подписаны студенты
        getActualCourses(studentList);
        System.out.println("===============================================================");

        // Список любознательных студентов
        getCuriosityStudent(studentList);
        System.out.println("===============================================================");

        // Список студентов курса
        getMyStudent(studentList, c8);

    }

    // Список курсов, на котрые подписаны студенты
    public static List<Course> getActualCourses(List<Student> inList) {
        List<Course> tempCourseList = new ArrayList<>();
        inList.forEach(cl -> {
            tempCourseList.addAll(cl.getAllCourses());
        });
        List<Course> resultList = tempCourseList.stream().distinct().collect(Collectors.toList());
        System.out.println(resultList);
        return resultList;
    }

    // Список любознательных студентов
    public static List<Student> getCuriosityStudent(List<Student> inList) {
        List<Student> tempStudentList = inList.stream()
                .sorted((st1, st2) -> st2.getAllCourses().size() - st1.getAllCourses().size())
                .limit(3)
                //на самом деле тут должна быть система рейтингов для случая, если несколько человек
                // записались на одинаковое кол-во курсов
                .collect(Collectors.toList());
        tempStudentList.forEach(student -> System.out.println(student.getName()));
        return tempStudentList;
    }

    // Список студентов курса
    public static List<Student> getMyStudent(List<Student> inList, Course inCourse) {
        List<Student> tempStudentList = inList.stream().
                filter(student -> student.getAllCourses().stream().anyMatch(inCourse::equals))
                .collect(Collectors.toList());
        tempStudentList.forEach(student -> System.out.println(student.getName()));
        return tempStudentList;
    }

}
