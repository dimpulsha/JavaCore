package ru.geekbrains.javacore.dimpulsha.lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> boxItems;

// сразу делаем
    public Box(ArrayList<T> boxItems) {
        this.boxItems = boxItems;
    }

    public Box() {
        this.boxItems = new ArrayList<>();
    }

    public void addOneItem(T item) {
        boxItems.add(item);
    }

    public void addSomeItems(ArrayList<T> someItems) {
        boxItems.addAll(someItems);
    }

    public int getInfo() {
        return boxItems.size();
    }

    public void removeItem(){
        if (boxItems.size() !=0) {
            boxItems.remove(0);
        } else System.out.println("Коробка пуста");
    }

    public void empty() {
        boxItems.clear();
    }

    public float getWeight() {
        if (boxItems.size() != 0) {
            // пользуемся тем, что вес одинаков. иначе должен быть перебор всех объектов
            return boxItems.get(0).getWeight() * boxItems.size();
        } else return 0;
    }

    public void replaceItems (Box <T> newBox){
        newBox.addSomeItems(boxItems);
        boxItems.clear();
    }

}
