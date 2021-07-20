package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayTemperature {
    @JsonProperty(value = "Minimum")
    private TemperatureItem minimum;
    @JsonProperty(value = "Maximum")
    private TemperatureItem maximum;

    @Override
    public String toString() {
        return "DayTemperature{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}
