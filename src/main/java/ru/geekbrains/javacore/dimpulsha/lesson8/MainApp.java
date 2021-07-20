package ru.geekbrains.javacore.dimpulsha.lesson8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
        } catch (SQLException throwables) {
            System.out.println("Ошибка подключения к базе данных");
            throwables.printStackTrace();
        }

        boolean isTable; // убрать, вместе с трай-катч
        try {
            //позже перенести выше
            isTable = prepareTable("weather", connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            isTable = false;
        }
        System.out.println("istable = " + isTable);

        if (connection != null && isTable) {
            Scanner scanner = new Scanner(System.in);
            WeatherResponse weatherResponse = new WeatherResponse();
            int menuItem = -1;
            while (menuItem != 0) {

                System.out.println("введите код действия:");
                System.out.println("1 - получить и отобразить погоду");
                System.out.println("2 - записать погоду в базу данных");
                System.out.println("3 - считать погоду из базы данных");
                System.out.println("0 - выход");

                menuItem = scanner.nextInt();

                switch (menuItem) {
                    case 0:
                        break;
                    case 1: {
                        // Задание 6 - Получить погоду с сервера
                        String weatherRawJson = null;
                        try {
                            weatherRawJson = FetchWeatherForecast.getWeather();
                            System.out.println("=====================  Raw Data  =============================");
                            System.out.println(weatherRawJson);
                            System.out.println("==========================================================================================");
                        } catch (IOException e) {
                            System.out.println("Ошибка получения прогноза погоды");
                            e.printStackTrace();
                            menuItem = 0;
                            break;
                        }

                        // Задание 7 - десериализовать и вывести сведения о погоде;
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        try {
                            weatherResponse = objectMapper.readValue(weatherRawJson, WeatherResponse.class);
                            System.out.println("=====================  Formatted Data  =============================");
                            weatherResponse.getForecastText();
                            System.out.println("==========================================================================================");

                        } catch (JsonProcessingException e) {
                            System.out.println("Ошибка обработки JSON");
                            e.printStackTrace();
                            menuItem = 0;
                            break;
                        }
                        break;
                    }

                    case 2: {

                            try {
                                saveWeatherToDB(weatherResponse, connection);
                                System.out.println("=====================  Задание 8 - данные записаны  =============================");
                                weatherResponse = null;
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                                menuItem = 0;
                                break;
                            } catch (NullPointerException e) {
                                System.out.println( "Нет данных для записи" );
                            }
                        break;
                    }
                    case 3: {
                        try {
                            readWeatherFromDB(connection);
                            System.out.println("=====================  Задание 8 - данные считаны  =============================");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                            menuItem = 0;
                            break;
                        }
                        break;
                    }
                }
            }
            scanner.close();
        }

        try {
//            после перенести в вызов функции
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean checkTable(String tableName, Connection inConnection) throws SQLException {
        DatabaseMetaData metaData = inConnection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);
//        boolean test = resultSet.next();
//        System.out.println(" test  = " + test);
//        return test;
       return resultSet.next();
    }

    public static boolean createWeatherTable(Connection inConnection) throws SQLException {
        Statement tempStatement = inConnection.createStatement();
        try {
            tempStatement.executeUpdate("CREATE TABLE weather ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "city VARCHAR(100), date VARCHAR2(10), day_weather VARCHAR2(255), night_weather VARCHAR2(255)," +
                    " t_max VARCHAR2(10), t_min VARCHAR2(10) )");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if (tempStatement != null) {
                tempStatement.close();
            }
            return false;
        }
    }

    public static boolean prepareTable(String tableName, Connection inConnection) throws SQLException {
        if (checkTable(tableName, inConnection)) {
            return true;
        } else {
            return createWeatherTable(inConnection);
        }
    }

    public static void saveWeatherToDB(WeatherResponse inWeatherResponse, Connection inConnection) throws SQLException {
        List<DailyForecasts> dailyForecastsList = inWeatherResponse.getDailyForecastsList();
//            System.out.println(inWeatherResponse.getCity());
            PreparedStatement insertWeather = inConnection.prepareStatement("INSERT INTO weather(city, date, " +
                    " day_weather, night_weather, t_max, t_min) VALUES ( ?,?,?,?,?,? )");
            dailyForecastsList.forEach(dfl -> {
                try {
                    insertWeather.setString(1, inWeatherResponse.getCity());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.setString(2, dfl.getForecastDate());
                } catch (SQLException | ParseException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.setString(3, dfl.getDayWeather().getDescription());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.setString(4, dfl.getNightWeather().getDescription());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.setString(5, dfl.getTemperature().getMaximum().getValue());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.setString(6, dfl.getTemperature().getMinimum().getValue());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    insertWeather.addBatch();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
            int[] result = insertWeather.executeBatch();
//            System.out.println(result.toString());
            insertWeather.close();
    }

    public static void readWeatherFromDB(Connection inConnection) throws SQLException {
        Statement tempStatement = inConnection.createStatement();
        ResultSet resultSet = tempStatement.executeQuery("SELECT * FROM weather");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String city = resultSet.getString(2);
            String wDate = resultSet.getString(3);
            String wDay = resultSet.getString(4);
            String wNight = resultSet.getString(5);
            String tMax = resultSet.getString(6);
            String tMin = resultSet.getString(7);
            String weatherText ="recordId="+ id + "  В городе " + city + " "
                    + wDate + " ожидается: днем - " + wDay +
                    ", ночью - " + wNight + ". Максимальная температура " +
                    tMax + " С,  минимальная температура " + tMin + " С.";
            System.out.println(weatherText);
        }
    }
}
