package com.oop.practice.models.car;

/**
 * Represents a car with basic functionality like starting/stopping the engine,
 * accelerating, and braking.
 */
public class Car {
    private final String make;
    private final String model;
    private final int year;
    private int currentSpeed;
    private boolean isEngineOn;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        currentSpeed = 0;
        isEngineOn = false;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started.");
    }

    public void stopEngine() {
        if (currentSpeed>0) {
            System.out.println("Engine can't be stopped because car is moving");
        } else {
            isEngineOn = false;
            System.out.println("Engine stopped");
        }
    }

    public void accelerate(int speed) {
        if (isEngineOn) {
            currentSpeed += speed;
            System.out.println("Accelerated : Car running at " + currentSpeed + " km/h ");
        } else  {
            System.out.println("Can't accelerate Engine in off");
        }
    }

    public void brake(int speed) {
        if (isEngineOn) {
            currentSpeed -= speed;
            if (currentSpeed<0) {
                currentSpeed=0;
            }
            System.out.println("Braked : Car running at " + currentSpeed + " km/h ");
        } else  {
            System.out.println("Engine in off");
        }
    }

    public String getCarInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Car Info : ");
        stringBuilder.append("\nMake : " + make);
        stringBuilder.append("\nModel : " + model);
        stringBuilder.append("\nYear : " + year);
        stringBuilder.append("\nCurrent Speed : " + currentSpeed);
        stringBuilder.append("\nEngine State : " + (isEngineOn ? "On" : "Off"));
        return stringBuilder.toString();
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

}
