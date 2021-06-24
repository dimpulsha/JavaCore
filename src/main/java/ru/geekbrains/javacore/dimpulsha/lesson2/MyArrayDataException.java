package ru.geekbrains.javacore.dimpulsha.lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException() {

    }
    public String toString( ) {
        return "MyArrayDataException: Ошибка преобразования данных: ";
    }
}