package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headline {
    @JsonProperty(value = "EffectiveEpochDate")
    private String effectiveEpochDate;
    @JsonProperty(value = "EndEpochDate")
    private String endEpochDate;

    public Headline() {
    }

    public Headline(String effectiveEpochDate, String endEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
        this.endEpochDate = endEpochDate;
    }

    public String getEffectiveEpochDate() {
        return effectiveEpochDate;
    }

    public void setEffectiveEpochDate(String effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
    }

    public String getEndEpochDate() {
        return endEpochDate;
    }

    public void setEndEpochDate(String endEpochDate) {
        this.endEpochDate = endEpochDate;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "effectiveEpochDate='" + effectiveEpochDate + '\'' +
                ", endEpochDate='" + endEpochDate + '\'' +
                '}';
    }
}
