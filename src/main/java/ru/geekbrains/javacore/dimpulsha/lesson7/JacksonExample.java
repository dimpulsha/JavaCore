package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = new Course(1, "Java-1");
        new Course(2, "Java-2");
        List<Course> courseList = new ArrayList<>();
        courseList.add(course);
        courseList.add(new Course(2, "Java-2"));
        Student student = new Student("Ivan", "Ivanov", 48, courseList);

        try {
            objectMapper.writeValue(new File("st.json"), student);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("файл успешно создан");


//        List<Student> studentList = new ArrayList<>();
//
//        Student studentIn = objectMapper.readValue(new File("st.json"),  Student.class);
//        System.out.println(studentIn.getFirstName());
//        System.out.println(studentIn.getSecondName());
//        System.out.println(studentIn.getAde());
//        System.out.println(studentIn.getCompletedCourse());

//        List<Student> studentList = new ArrayList<>();
        Student[] studentList =   objectMapper.readValue(new File("st-N.json"),Student[].class);
        System.out.println(studentList[0].toString());


//        try {
//            objectMapper.readValue(new File("st.json"), (JavaType) studentList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(studentList);


    }
}
