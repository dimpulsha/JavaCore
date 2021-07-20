package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayTemperature {
    @JsonProperty(value = "Minimum")
    private TemperatureItem minimum;
    @JsonProperty(value = "Maximum")
    private TemperatureItem maximum;

    public DayTemperature(TemperatureItem minimum, TemperatureItem maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public DayTemperature() {
    }

    public TemperatureItem getMinimum() {
        return minimum;
    }

    public void setMinimum(TemperatureItem minimum) {
        this.minimum = minimum;
    }

    public TemperatureItem getMaximum() {
        return maximum;
    }

    public void setMaximum(TemperatureItem maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "DayTemperature{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }
}
