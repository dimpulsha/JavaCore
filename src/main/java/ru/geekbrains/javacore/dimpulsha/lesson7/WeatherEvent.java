package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherEvent {
    @JsonProperty(value = "IconPhrase")
    public String description;

    public WeatherEvent(String description) {
        this.description = description;
    }

    public WeatherEvent() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherEvent{" +
                "description='" + description + '\'' +
                '}';
    }
    //      "IconPhrase": "Преимущественно облачно с ливнями",
}
