package ru.geekbrains.javacore.dimpulsha.lesson2;

public class MainApp {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] checkedArr = {{"1", "2", "3", "4"}, {"g", "6", "7", "vfh"},
                {"9", "#4", "11", "12"}, {"13", "14", "de", "16"}};
        int strArraySumm = 0;
        try {
            strArraySumm = ArraySum.arraySumm(checkedArr, 4);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.toString());
        }
        System.out.println("Сумма значений корректных ячеек архива: " + strArraySumm);
    }
}
