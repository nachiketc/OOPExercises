package com.oop.practice.models.vehicle;

import com.oop.practice.enums.TransmissionType;
import com.oop.practice.utils.ValidationUtil;

public class ElectricCar extends Car {

    private double batteryCapacity;
    private double currentCharge; //perentage

    public ElectricCar(String make, String model, int year, double speed, int capacity,
                       TransmissionType transmissionType, int numDoors, double batteryCapacity, double currentCharge) {
        super(make, model, year, speed, capacity, transmissionType, numDoors);
        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
    }

    public void chargeBattery(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Charge Amoutn can only be greater than 0");
        } else {

            if ( currentCharge + amount/batteryCapacity > 100){
                currentCharge = 100;
            } else  {
                currentCharge += amount/batteryCapacity;
            }
        }
    }

    public double getCurrentCharge() {
        return currentCharge;
    }

    @Override
    public void turnEngineOn() {
        if (currentCharge > 0) {
            super.turnEngineOn();
        } else {
            System.out.println("There is no charge to start the vehicle");
        }
    }

    @Override
    public String getVehicleInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicle(Electric Car) information : ");
        stringBuilder.append("Make : ").append(super.getMake());
        stringBuilder.append("Model : ").append(super.getModel());
        stringBuilder.append("Year : ").append(super.getYear());
        stringBuilder.append("Speed : ").append(super.getSpeed());
        stringBuilder.append("Capacity : ").append(super.getCapacity());
        stringBuilder.append("Number of doors: ").append(super.getNumDoors());
        stringBuilder.append("TransmissionType : ").append(super.getTransmissionType().getLabel());
        stringBuilder.append("Battery Capacity : ").append(batteryCapacity).append(" kWh");
        stringBuilder.append("Cuurent Charge : ").append(currentCharge).append(" %");
        return stringBuilder.toString();
    }
}
