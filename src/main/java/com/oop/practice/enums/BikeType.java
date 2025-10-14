package com.oop.practice.enums;

public enum BikeType {

    CRUISER("Cruiser"),
    SPORTS("Sports");

    private final String label;


    BikeType(String label) { this.label = label;}

    public String getLabel() {
        return label;
    }
}
