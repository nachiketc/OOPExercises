package com.oop.practice.enums;

public enum TransmissionType {

    AUTOMATIC("Automatic"),
    MANUAL("Manual");

    private final String label;

    TransmissionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
