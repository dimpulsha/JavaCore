package ru.geekbrains.javacore.dimpulsha.lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureItem {

    @JsonProperty(value = "Value")
    private float value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private String unitType;

    public TemperatureItem(float value, String unit, String unitType) {
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    public TemperatureItem() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "TemperatureItem{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", unitType='" + unitType + '\'' +
                '}';
    }

}
