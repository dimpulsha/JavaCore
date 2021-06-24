package ru.geekbrains.javacore.dimpulsha.lesson2;

public class ArraySum {
    public static int arraySumm(String[][] strArray, int arrSize ) throws MyArraySizeException, MyArrayDataException {

            if (strArray.length != arrSize || strArray[0].length != arrSize) {
                throw new MyArraySizeException();
            }
            int summ = 0;
        for (int i = 0; i < arrSize; i++ ) {
            for (int j = 0; j < arrSize; j++) {
                try {
                    try {
                        summ += Integer.valueOf(strArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException();
                    }
                } catch (MyArrayDataException e)  {System.out.println(e.toString()+ "Строка: " + (i+1) + ", Колонка: "+ (j+1));}
            }
        }
        return summ;
    }
}
