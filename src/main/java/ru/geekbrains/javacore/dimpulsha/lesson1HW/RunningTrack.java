package ru.geekbrains.javacore.dimpulsha.lesson1HW;

import java.util.Random;

public class RunningTrack implements Obstacle {
    private String kind = "RunningTrack";
    private int distance;

    public RunningTrack() {
        Random random = new Random();
        this.distance = random.nextInt(200);
    }

    public int getLimit() {
        return distance;
    }

    public String getKind(){
        return kind;
    }
}
