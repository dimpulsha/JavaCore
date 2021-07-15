package ru.geekbrains.javacore.dimpulsha.lesson6;

import okhttp3.*;

import java.io.IOException;

public class WeatherForecast {

    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String CITY_KEY = "474112_PC";
    private static final String API_KEY = "x7bHtEmfRTNt6FlFxPzfFyNESAivupMw";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(CITY_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String responseJson = client.newCall(request).execute().body().string();
        System.out.println(responseJson);
    }
}
