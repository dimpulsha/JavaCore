package ru.geekbrains.javacore.dimpulsha.lesson1;

public class Cat extends Animal {
    private String breed;
    private String color;

    public String getBreed() {
        return breed;
    }

    // через super вызывается конструктор суперкласса - и это первый опреатор в конструкторе подкласса

    public void callAnimal () {
        super.getName();
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String breed, String color) {
        super("Rudolf", 5);
        this.breed = breed;
        this.color = color;
    }

    public void voice (String word){
        System.out.println("Cat say: " + word);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
