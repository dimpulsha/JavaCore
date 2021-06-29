package ru.geekbrains.javacore.dimpulsha.lesson4;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> phonebook;

    public PhoneBook(String[][] initArray) {
        Map<String, String> initPhoneBook = new HashMap<>();
        for (int i = 0; i < initArray.length; i++) {
            initPhoneBook.put(initArray[i][0], initArray[i][1]);
        }
        this.phonebook = initPhoneBook;
    }

    public void getAll() {
        phonebook.forEach((key, value) -> System.out.println("Name: " + value + " phone: " + key));
    }

    public void getPhone(String inName) {

        Map<String, String> tempMap = new HashMap<>();
        // мне кажется  phonebook.containsValue() всё равно придется пробегать по всей MAP. так зачем это делать дважды?
        phonebook.forEach((phone, name) -> {
            if (name == inName) {
                tempMap.put(phone, name);
            }
        });
        if (tempMap.isEmpty()) {
            System.out.println("Записей не найдено");
        } else {
            tempMap.forEach((key, value) -> System.out.println(value + " Тел: " + key));
        }

    }
}
