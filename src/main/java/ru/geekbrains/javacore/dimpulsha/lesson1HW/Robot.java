package ru.geekbrains.javacore.dimpulsha.lesson1HW;

public class Robot implements TeamActivity {
    private String type;
    private String name;
    private int runLimit;
    private int jumpLimit;
    private int health;
    private boolean obstacleCourseResult;

    //

    public Robot(String name) {
        this.type = "Robot"; //classType??
        this.name = name;
        this.runLimit = 300;
        this.jumpLimit = 50;
//        this.health = 200;
//        this.obstacleCourseResult = false;
    }

//    public void setObstacleCourseResult(boolean obstacleCourseResult) {
//        this.obstacleCourseResult = obstacleCourseResult;
//    }

    public boolean run (int distance) {
        System.out.println( type +" "+ name + " бежит");
        System.out.println("Мой предел = " + runLimit);
        System.out.println("Поставлена задача = " + distance);
        return runLimit > distance;
    }

    public boolean jump (int height) {
        System.out.println( type +" "+ name + " прыгает");
        System.out.println("Мой предел = " + jumpLimit);
        System.out.println("Поставлена задача = " + height);
        return jumpLimit > height;
    }

    public void overcomeObstacle (Obstacle [] obstacleList) {
        boolean result = true;
        for (int i = 0; i < obstacleList.length; i++){
            System.out.println("Прохожу препятствие  "+ obstacleList[i].getKind() );

            switch (obstacleList[i].getKind()) {
                case "Wall": result = jump(obstacleList[i].getLimit());
                    System.out.println("Результат выполнения задачи: " + result);
                    break;
                case "RunningTrack": result =  run(obstacleList[i].getLimit());
                    System.out.println("Результат выполнения задачи: " + result);
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
