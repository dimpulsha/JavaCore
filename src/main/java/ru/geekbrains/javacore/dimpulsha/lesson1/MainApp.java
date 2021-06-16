package ru.geekbrains.javacore.dimpulsha.lesson1;

public class MainApp {
    public static void main(String[] args) {
//        User siteUser = new User ( "root", "qwerty");
//        User backUser = new User(null, null);
//        backUser.setLogin("backroot");
//        backUser.setPassword("backPassw");
//        System.out.println(siteUser);
//        System.out.println(backUser);

        Animal animal = new Animal("Murka", 2);

        Cat cat = new Cat("homeCat", "grey");
//        cat.setName("Barsik");
//        cat.setAge(3);
//        cat.setBreed("leo");
//        cat.setColor("black");

        System.out.println(cat);

        BombeyCat bCat = new BombeyCat("Rubik", 4, "tiger", "white", "the best Cat");
        BombeyCat bCat2 = new BombeyCat("Rubik", 4, "tiger", "white", "the best Cat");
        System.out.println(bCat);
        System.out.println(bCat2);

//        animal.voice("aaaaaaaaaaaaaarrrrrrrrrrrrrch");
//        cat.voice("meow");

        System.out.println(bCat.equals(bCat2));

        BombeyCat bCat3 = bCat;

        System.out.println(bCat.equals(bCat3));

        System.out.println(bCat.hashCode());
        System.out.println(bCat2.hashCode());
        System.out.println(bCat3.hashCode());


    }

}
