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
        this.currentSpeed = 0;
        this.isEngineOn = false;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("Engine started.");
    }

    public void stopEnginge() {
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

    public void getCarInfo() {
        System.out.println("Make : " + this.make);
        System.out.println("Model : " + this.model);
        System.out.println("Year : " + this.year);
        System.out.println("Current Speed : " + this.currentSpeed);
        System.out.println("Engine State : " + (this.isEngineOn ? "On" : "Off"));
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public boolean isEngineOn() {
        return this.isEngineOn;
    }

}
