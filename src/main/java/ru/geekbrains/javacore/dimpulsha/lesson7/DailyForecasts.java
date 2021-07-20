package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyForecasts {

    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Temperature")
    private DayTemperature temperature;
    @JsonProperty(value = "Day")
    private WeatherEvent dayWeather;
    @JsonProperty(value = "Night")
    private WeatherEvent nightWeather;

    public DailyForecasts(String date, DayTemperature temperature, WeatherEvent dayWeather, WeatherEvent nightWeather) {
        this.date = date;
        this.temperature = temperature;
        this.dayWeather = dayWeather;
        this.nightWeather = nightWeather;
    }

    public DailyForecasts() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(DayTemperature temperature) {
        this.temperature = temperature;
    }

    public WeatherEvent getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(WeatherEvent dayWeather) {
        this.dayWeather = dayWeather;
    }

    public WeatherEvent getNightWeather() {
        return nightWeather;
    }

    public void setNightWeather(WeatherEvent nightWeather) {
        this.nightWeather = nightWeather;
    }

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
