package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DailyForecasts {

    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Temperature")
    private DayTemperature temperature;
    @JsonProperty(value = "Day")
    private WeatherEvent dayWeather;
    @JsonProperty(value = "Night")
    private WeatherEvent nightWeather;

    public String getForecastDate() throws ParseException {
        DateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormatOut = new SimpleDateFormat("dd-MM-yyyy");
        Date nDate = dateFormatIn.parse(date);
        String outDate = dateFormatOut.format(nDate);
        return outDate;
    }

    public String getForecastText() throws ParseException {
        String weatherText = "на дату "+ getForecastDate() + " ожидается днем: " + dayWeather.getDescription() +
                ", ночью: " + nightWeather.getDescription()+ ". Температура максимальная: "+ temperature.getMaximum().getValue() +
                " "+ temperature.getMaximum().getUnit() + ". Температура минимальная: "+ temperature.getMinimum().getValue() + " "+
                temperature.getMinimum().getUnit();

        return weatherText;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "date='" + date + '\'' +
                ", temperature=" + temperature +
                ", dayWeather=" + dayWeather +
                ", nightWeather=" + nightWeather +
                '}';
    }
}
