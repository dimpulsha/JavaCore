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
public class TemperatureItem {

    @JsonProperty(value = "Value")
    private float value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private String unitType;

    @Override
    public String toString() {
        return "TemperatureItem{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", unitType='" + unitType + '\'' +
                '}';
    }

}
