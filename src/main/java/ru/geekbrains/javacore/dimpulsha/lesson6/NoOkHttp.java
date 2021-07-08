package ru.geekbrains.javacore.dimpulsha.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NoOkHttp {

    private static final String PROTO = "http://";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String CITY_KEY = "474112_PC";
    private static final String API_KEY = "x7bHtEmfRTNt6FlFxPzfFyNESAivupMw";

    public static void main(String[] args) throws IOException {

        String urlString = PROTO + HOST + "/" + FORECAST + "/" + API_VERSION + "/" + FORECAST_TYPE + "/" + FORECAST_PERIOD + "/" + CITY_KEY + "?apikey=" + API_KEY + "&language=ru-ru&metric=true";
        System.out.println(urlString);

        URL url = new URL(urlString);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();

        BufferedReader buffer = null;

        if (httpURLConnection.getResponseCode() == 200) {
            buffer = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String responseBody = null;
            String currentLine = null;
            while ((currentLine = buffer.readLine()) != null) {
                responseBody += currentLine;
                System.out.println(responseBody);
            }
        } else {
            System.out.println("Response code: " + httpURLConnection.getResponseCode());
            System.out.println("Response message: " + httpURLConnection.getResponseMessage());
            buffer = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            String currentLine = null;
            while ((currentLine = buffer.readLine()) != null) {
                System.out.println(currentLine);
            }
        }
    }
}
