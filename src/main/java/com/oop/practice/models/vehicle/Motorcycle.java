package com.oop.practice.models.vehicle;

import com.oop.practice.enums.BikeType;

public class Motorcycle extends Vehicle{

    private boolean hasSideCar;
    private BikeType bikeType;

    public Motorcycle(String make, String model, int year, double speed, int capacity, boolean hasSideCar,BikeType bikeType) {
        super(make, model, year, speed, capacity);
        this.hasSideCar = hasSideCar;
        this.bikeType = bikeType;
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public BikeType getBikeType(){
        return bikeType;
    }

    public void wheelie(){
        System.out.println("Wheeliee action!!");
    }

    @Override
    public String getVehicleInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicle(Motorcycle) information : ");
        stringBuilder.append("Make : ").append(super.getMake());
        stringBuilder.append("Model : ").append(super.getModel());
        stringBuilder.append("Year : ").append(super.getYear());
        stringBuilder.append("Speed : ").append(super.getSpeed());
        stringBuilder.append("Capacity : ").append(super.getCapacity());
        if (hasSideCar) {
            stringBuilder.append("Has Side car  ");
        } else {
            stringBuilder.append("No side car");
        }
        stringBuilder.append("Bike Type : ").append(bikeType.getLabel());
        return stringBuilder.toString();
    }
}
