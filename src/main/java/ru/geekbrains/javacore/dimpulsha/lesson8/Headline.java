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
public class Headline {
    @JsonProperty(value = "EffectiveEpochDate")
    private String effectiveEpochDate;
    @JsonProperty(value = "EndEpochDate")
    private String endEpochDate;

    @Override
    public String toString() {
        return "Headline{" +
                "effectiveEpochDate='" + effectiveEpochDate + '\'' +
                ", endEpochDate='" + endEpochDate + '\'' +
                '}';
    }
}
