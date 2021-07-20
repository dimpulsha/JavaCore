package ru.geekbrains.javacore.dimpulsha.lesson8;

import okhttp3.*;

import java.io.IOException;

public class FetchWeatherForecast {

    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String CITY_KEY = "295212";
    private static final String API_KEY = "x7bHtEmfRTNt6FlFxPzfFyNESAivupMw";

    public static String getWeather () throws IOException {
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

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        ResponseBody responseJsonBody = client.newCall(request).execute().body();
        String responseJson =  responseJsonBody.string();
        responseJsonBody.close();
        return responseJson;

    }
}
