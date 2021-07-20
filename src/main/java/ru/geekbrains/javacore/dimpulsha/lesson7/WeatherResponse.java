package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.util.List;

public class WeatherResponse {
    private final String city = "Санкт-Петербург";
    @JsonProperty(value = "Headline")
    private Headline headline;
    @JsonProperty(value = "DailyForecasts")
    private List <DailyForecasts> dailyForecastsList;

    public WeatherResponse(Headline headline) {
        this.headline = headline;
    }

    public WeatherResponse() {
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "city='" + city + '\'' +
                ", headline=" + headline +
                ", dailyForecastsList=" + dailyForecastsList +
                '}';
    }

   public void getForecastText () {
       dailyForecastsList.forEach(item -> {
           try {
               System.out.println( "В городе " + city + " " + item.getForecastText());
           } catch (ParseException e) {
               e.printStackTrace();
           }
       });
   };
}
