package ru.geekbrains.javacore.dimpulsha.lesson4;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        String[] names = {
                "Светлана",
                "Юлия",
                "Елена",
                "Светлана",
                "Иван",
                "Антон",
                "Юлия",
                "Сергей",
                "Иван",
                "Антон",
                "Анна",
                "Петр",
                "Ольга",
                "Анна",
                "Никита",
                "Наталья",
                "Александр",
                "Иван",
                "Алексей",
                "Игорь",
                "Константин"};

        String[][] phoneArray = {
                {"93487585", "Светлана"},
                {"934826-54", "Юлия"},
                {"23593287", "Елена"},
                {"34692086", "Светлана}"},
                {"3-40986-09", "Иван"},
                {"34-0698", "Антон"},
                {"4932086443", "Юлия"},
                {"340-9864444", "Сергей"},
                {"43643623", "Иван"},
                {"32367453", "Антон"},
                {"45436543", "Анна"},
                {"43656345", "Петр"},
                {"54765754", "Ольга"},
                {"34653467", "Анна"},
                {"97865545", "Никита"},
                {"11241235", "Наталья"},
                {"45653457", "Александр"},
                {"75466663", "Иван"},
                {"34643566", "Алексей"},
                {"46456446", "Игорь"},
                {"57546432", "Константин"}};

        // подготовка данных из массива
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        System.out.println(nameList.toString());
//
//        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем)
        Set<String> nameSet = new HashSet<>(nameList);
        System.out.println(nameSet.toString());
//        // Посчитать, сколько раз встречается каждое слово
        nameSet.forEach((name) ->
                System.out.println(name + "  кол-во повторов в списке: " + Collections.frequency(nameList, name))
        );
// инициализация книги
        PhoneBook myPhoneBook = new PhoneBook(phoneArray);
//         myPhoneBook.getAll();
        // поиск по значению
        myPhoneBook.getPhone("Сова");
        myPhoneBook.getPhone("Иван");
        myPhoneBook.getPhone("Ольга");

    }
}
