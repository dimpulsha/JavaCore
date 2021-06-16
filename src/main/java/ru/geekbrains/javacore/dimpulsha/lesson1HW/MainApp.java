package ru.geekbrains.javacore.dimpulsha.lesson1HW;

public class MainApp {
    public static void main(String[] args) {
        TeamActivity r1 = new Robot("Robby");
        TeamActivity h1 = new Human("Вася");
        TeamActivity c1 = new Cat("Барсик");

        TeamActivity [] team = {r1, h1, c1};

        Obstacle w1 = new Wall();
        Obstacle w2 = new Wall();
        Obstacle rt1 = new RunningTrack();
        Obstacle rt2 = new RunningTrack();

        Obstacle [] obstacles = {w1,  rt1, w2, rt2};

        for (int i = 0; i < team.length; i++) {
            team[i].overcomeObstacle(obstacles);
        };
    }
}
