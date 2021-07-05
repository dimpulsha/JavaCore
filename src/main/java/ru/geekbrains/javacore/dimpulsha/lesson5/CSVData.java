package ru.geekbrains.javacore.dimpulsha.lesson5;

import java.util.Arrays;

public class CSVData {
    private String[] header;
    private int[][] data;

    public CSVData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CSVData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
