package com.oop.practice.models.vehicle;

import com.oop.practice.enums.TransmissionType;
import com.oop.practice.utils.ValidationUtil;

public class Car extends Vehicle{

    private int numDoors;
    private TransmissionType transmissionType;

    public Car(String make, String model, int year, double speed, int capacity,TransmissionType transmissionType, int numDoors) {
        super(make, model, year, speed, capacity);
        this.transmissionType = transmissionType;
        ValidationUtil.validatePositiveIntAndThrow(numDoors,"Number of doors");
        this.numDoors = numDoors;
    }

    public void honk() {
        System.out.println("HONK HONK HONK !!!");
    }

    public int getNumDoors() {
        return numDoors;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String getVehicleInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicle(Car) information : ");
        stringBuilder.append("Make : ").append(super.getMake());
        stringBuilder.append("Model : ").append(super.getModel());
        stringBuilder.append("Year : ").append(super.getYear());
        stringBuilder.append("Speed : ").append(super.getSpeed());
        stringBuilder.append("Capacity : ").append(super.getCapacity());
        stringBuilder.append("Number of doors: ").append(numDoors);
        stringBuilder.append("TransmissionType : ").append(transmissionType.getLabel());
        return stringBuilder.toString();
    }
}
