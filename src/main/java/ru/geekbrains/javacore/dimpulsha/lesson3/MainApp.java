package ru.geekbrains.javacore.dimpulsha.lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

// =========== Задание 1 - запуск
        int[] intArr = {1, 2, 3};
        AnyObject<int[]> any1 = new AnyObject<>(intArr);
        AnyObject<String> any2 = new AnyObject<>("Sample object");
        AnyObject[] anyArr = {any1, any2};

        System.out.println(anyArr[0]);
        System.out.println(anyArr[1]);

// метод описан внизу
        changeArrMember(0, 1, anyArr);

        System.out.println(anyArr[0]);
        System.out.println(anyArr[1]);

// второй вариант
        changeArrMember2(0, 1, anyArr);

        System.out.println(anyArr[0]);
        System.out.println(anyArr[1]);
// как результат - ссылки у элементов массива изменились

// ===============  задание 2 - проверка

        Apple app1 = new Apple();
        Apple app2 = new Apple();
        Apple app3 = new Apple();
        Apple app4 = new Apple();

        Orange ora1 = new Orange();
        Orange ora2 = new Orange();
        Orange ora3 = new Orange();

        Apple [] apples = {app1, app2, app3, app4};
        Orange [] oranges = {ora1, ora2, ora3};

        // Если честно, лень было возиться с преобразованиями массивов (изменение размеров при добавлении/ удалении)
        // поэтому воспользовался списками
        ArrayList <Apple> appleItems = new ArrayList<>(Arrays.asList(apples));
        ArrayList <Orange> orangeItems = new ArrayList<>(Arrays.asList(oranges));

        //Box <Apple> appleBox = new Box<>(appleItems);
      Box <Apple> appleBox = new Box<>();
        // appleBox.addOneItem(ora1); Не дает положить фрукты уже на уровне компиляции т.е.
        // запрет смешивания у меня получается только за счет типизации "коробки"
        // я не понял - можно ли создать Box типа "Fruit", а при создании объекта передать в конструктор
        // массив или список типа Apple
        // у меня на такие конструкции ругался компилятор
        //Box <Fruit> appleBox4 = new Box<>(appleItems);

        appleBox.addOneItem(app3);
        System.out.println("Коробка содержит " + appleBox.getInfo());
        System.out.println("Вес коробки " + appleBox.getWeight());
        appleBox.addSomeItems(appleItems);
        System.out.println("Коробка содержит " + appleBox.getInfo());
        System.out.println("Вес коробки " + appleBox.getWeight());

        Box <Orange>  orangeBox = new Box<>(orangeItems);
        System.out.println("Коробка c апельсинами содержит " +orangeBox.getInfo());
        System.out.println("Вес коробки " + orangeBox.getWeight());

        // перекладывание может быть только между коробками одного типа. Коробка-приемник может быть не пустой.
        Box <Apple> appleBox2 = new Box<>(appleItems);
        System.out.println("Коробка 1 содержит " + appleBox.getInfo());
        System.out.println("Коробка 2 содержит " + appleBox2.getInfo());
        appleBox.replaceItems(appleBox2);
        System.out.println("Коробка 1 содержит " + appleBox.getInfo());
        System.out.println("Коробка 2 содержит " + appleBox2.getInfo());

        // не дает пересыпать на уровне компиляции
        //appleBox2.replaceItems(orangeBox);
    }

    // метод, который меняет объекты массива местами
    public static void changeArrMember(int indexA, int indexB, AnyObject[] inArr) {
        AnyObject tempBox;
        tempBox = inArr[indexA];
        inArr[indexA] = inArr[indexB];
        inArr[indexB] = tempBox;
    }

    public static void changeArrMember2 (int indexA, int indexB, Object[] inArr) {
        Object tempBox;
        tempBox = inArr[indexA];
        inArr[indexA] = inArr[indexB];
        inArr[indexB] = tempBox;
    }

}
