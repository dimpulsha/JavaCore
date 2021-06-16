package ru.geekbrains.javacore.dimpulsha.lesson1;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

public class BombeyCat extends Cat {
    String c;
    public BombeyCat(String name, int age, String breed, String color, String c){
           super(breed, color);
        this.c = c;
    }

    @Override
    public String toString() {
        return "BombeyCat{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", color='" + getColor() + '\'' +
                "c='" + c + '\'' +
                '}';
    }
}
