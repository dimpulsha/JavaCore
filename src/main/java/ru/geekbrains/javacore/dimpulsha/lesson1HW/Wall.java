package ru.geekbrains.javacore.dimpulsha.lesson1HW;

import java.util.Random;

public class Wall implements Obstacle {
    private int height;
    private String kind = "Wall";
    public Wall() {
        Random random = new Random();
        this.height = random.nextInt(50);
    }

    public int getLimit() {
        return height;
    }

    public String getKind(){
        return kind;
    }

}
