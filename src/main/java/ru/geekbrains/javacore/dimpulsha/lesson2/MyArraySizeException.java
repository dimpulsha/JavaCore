package ru.geekbrains.javacore.dimpulsha.lesson2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
    }
    public String toString()
    {
        return "MyArraySizeException: Ошибка размерности массива " ;
    }
}
