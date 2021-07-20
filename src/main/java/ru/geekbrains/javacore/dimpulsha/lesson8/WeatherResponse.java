package ru.geekbrains.javacore.dimpulsha.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    private final String city = "Санкт-Петербург";
    @JsonProperty(value = "Headline")
    private Headline headline;
    @JsonProperty(value = "DailyForecasts")
    private List<DailyForecasts> dailyForecastsList;

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "city='" + city + '\'' +
                ", headline=" + headline +
                ", dailyForecastsList=" + dailyForecastsList +
                '}';
    }

    public void getForecastText() {
        dailyForecastsList.forEach(item -> {
            try {
                System.out.println("В городе " + city + " " + item.getForecastText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    };


}
