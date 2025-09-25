package com.oop.practice.pojos;

public record TemperatureLog(double finalTemp, String message) {

    public static TemperatureLog logTemp(double finalTemp, String message) {
        return new TemperatureLog( finalTemp, message);
    }
}
