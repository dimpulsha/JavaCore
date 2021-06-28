package ru.geekbrains.javacore.dimpulsha.lesson3;

public class AnyObject <T extends Object> {
    private T obj;

    public AnyObject(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}