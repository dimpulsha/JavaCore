package ru.geekbrains.javacore.dimpulsha.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        List<String[]> incomeCSV = readCSV("inputData.csv");
        CSVData csvData = new CSVData(createCSVHeader(incomeCSV), createCSVData(incomeCSV));
        writeCSV(csvData, "outputData.csv");

    }

    public static List<String[]> readCSV(String filename) {
        List<String[]> CSVStringList = new ArrayList<>();
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(filename));
            String[] inputLine = null;
            String tempLine = null;
            while ((tempLine = inputFile.readLine()) != null) {
//                System.out.println(tempLine);
                inputLine = tempLine.split(";");
                CSVStringList.add(inputLine);
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Can't create output stream." + e.getMessage());
            e.printStackTrace();
        } catch (IOException ioException) {
            System.out.println(" Can't read line" + ioException.getMessage());
            ioException.printStackTrace();
        }
        return CSVStringList;
    }

    public static String[] createCSVHeader(List<String[]> inputData) {
        return inputData.get(0);
    }

    public static int[][] createCSVData(List<String[]> inputData) {
        int[][] dataArray = new int[inputData.size() - 1][inputData.get(0).length];
        for (int i = 1; i < inputData.size(); i++) {
            for (int j = 0; j < inputData.get(0).length; j++) {
                try {
                    dataArray[i - 1][j] = Integer.parseInt(inputData.get(i)[j]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка преобразования данных. Строка: " + (i + 1) + " Позиция: " + (j + 1));
                    e.printStackTrace();
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ошибка формирования массива. Индекс: " + (i - 1) + " " + j);
                    e.printStackTrace();
                    break;
                }
            }
        }
        return dataArray;
    }

    public static void writeCSV(CSVData outputCSV, String filename) {
        try {
            //OutputStream outputFile = new BufferedOutputStream( new FileOutputStream(filename));
            PrintWriter printWriter = new PrintWriter(filename);
            printWriter.println(String.join(";", outputCSV.getHeader()));
            int[][] tempCSVData = outputCSV.getData();
            for (int i= 0; i<tempCSVData.length; i++) {
               printWriter.println(Arrays.toString(tempCSVData[i]).replace(", ", ";")
               .replace("[","")
               .replace("]",""));
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
