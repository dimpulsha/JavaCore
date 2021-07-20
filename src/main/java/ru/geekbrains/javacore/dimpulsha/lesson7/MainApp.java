package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws IOException {

        // Задание 6 - Получить погоду с сервера
        String weatherRawJson = FetchWeatherForecast.getWeather();
        System.out.println(weatherRawJson);
        System.out.println("==========================================================================================");


        // Задание 7 - десериализовать и вывести сведения о погоде;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WeatherResponse weatherResponse = objectMapper.readValue(weatherRawJson,WeatherResponse.class);
       // System.out.println(weatherResponse.toString());
        weatherResponse.getForecastText();

        System.out.println("==========================================================================================");
//      Задание 8 - сохранить в базу прогноз погоды

    }
}
