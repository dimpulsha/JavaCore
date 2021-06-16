package ru.geekbrains.javacore.dimpulsha.lesson1HW;

public class Cat implements TeamActivity{
    private String type;
    private String name;
    private int runLimit;
    private int jumpLimit;
    private int health;
    private boolean obstacleCourseResult;

    //

    public Cat(String name) {
        this.type = "Cat"; //classType??
        this.name = name;
        this.runLimit = 30;
        this.jumpLimit = 170;
//        this.health = 30;
//        this.obstacleCourseResult = false;

    }

//    public void setObstacleCourseResult(boolean obstacleCourseResult) {
//        this.obstacleCourseResult = obstacleCourseResult;
//    }

    public boolean run (int distance) {
        System.out.println( type +" "+ name + " бежит");
//        System.out.println("предел = " + runLimit);
//        System.out.println("задача = " + distance);
        return runLimit > distance;
    }

    public boolean jump (int height) {
        System.out.println( type +" "+ name + " прыгает");
//        System.out.println("предел = " + jumpLimit);
//        System.out.println("задача = " + height);
        return jumpLimit > height;
    }

    public void overcomeObstacle (Obstacle [] obstacleList) {
        boolean result = true;
        for (int i = 0; i < obstacleList.length; i++){
            System.out.println("Прохожу препятствие  "+ obstacleList[i].getKind() );

            switch (obstacleList[i].getKind()) {
                case "Wall": result = jump(obstacleList[i].getLimit());
//                    System.out.println(result);
                    break;
                case "RunningTrack": result =  run(obstacleList[i].getLimit());
//                   System.out.println(result);
                    break;
                default: System.out.println("Неизвестное препятствие"); result = false; break;
            }
            if (!result) {
                System.out.println("Полоса не пройдена");
                break;
            }
        }
        if (result) System.out.println("Полоса пройдена успешно!");
        System.out.println("==========================");
    }
}
