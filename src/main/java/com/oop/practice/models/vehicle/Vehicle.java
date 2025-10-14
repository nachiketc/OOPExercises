package com.oop.practice.models.vehicle;

public class Vehicle {

    private String make;
    private String model;
    private int year;
    private double speed;
    private int capacity;
    private boolean isEngineOn;

    public Vehicle(String make, String model,int year, double speed, int capacity){
        this.make = make;
        this.model = model;
        this.year = year;
        this.speed = speed;
        this.capacity=capacity;
        this.isEngineOn=false;
    }

    public void turnEngineOn(){
        //check if engine is on ? if on notify the engine is on: turn on the engine
        if (isEngineOn){
            System.out.println("Engine is already turned on");
        }
        isEngineOn=true;
    }

    public void turnEngineOff() {
        //check if speed is not 0
        if (speed!=0){
            System.out.println("Engine can't be turned off for a moving vehicle");
        }
        isEngineOn=false;
    }

    public void accelerate(int speedInc){
        if (!isEngineOn) {
            System.out.println("Engine is turned off, vehicle can't accelerate");
        } else {
            speed += speedInc;
            System.out.println("Speed Increased to " + speed + " km/h");
        }
    }

    public void decelerate(int speedDec) {
        if (!isEngineOn) {
            System.out.println("Engine is turned off, vehicle can't decelerate");
        } else if (speed == 0) {
            System.out.println("Vehicle is already stationary, vehicle can't decelerate");
        } else {
            if (speed>speedDec){
                speed -= speedDec;
                System.out.println("Speed decreased to " + speed + " km/h");
            } else {
                speed = 0;
                System.out.println("Speed decreased to 0 km/h");
            }
        }
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public double getSpeed() {
        return speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicle information : ");
        stringBuilder.append("Make : ").append(make);
        stringBuilder.append("Model : ").append(model);
        stringBuilder.append("Year : ").append(year);
        stringBuilder.append("Speed : ").append(speed);
        stringBuilder.append("Capacity : ").append(capacity);
        return stringBuilder.toString();
    }
}
 