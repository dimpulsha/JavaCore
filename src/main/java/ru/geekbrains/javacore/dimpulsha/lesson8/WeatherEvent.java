package ru.geekbrains.javacore.dimpulsha.lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEvent {
    @JsonProperty(value = "IconPhrase")
    private String description;

    @Override
    public String toString() {
        return "WeatherEvent{" +
                "description='" + description + '\'' +
                '}';
    }
    //      "IconPhrase": "Преимущественно облачно с ливнями",
}
