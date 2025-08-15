package com.oop.practice.demo.car;

import com.oop.practice.models.car.Car;

/**
 * Demo class for Car operations.
 * Demonstrates class composition, methods, and state management.
 */
public class CarDemo {
    
    /**
     * Runs the Car demo.
     */
    public static void run() {
        System.out.println("\n===== Starting Car Demo =====");
        
        // Create a new car
        Car myCar = new Car("Toyota", "Camry", 2020);
        System.out.println("\n=== Created new car ===");
        System.out.println(myCar.getCarInfo());
        
        // Start the car
        System.out.println("\n=== Starting the car ===");
        myCar.startEngine();
        System.out.println("Is engine running? " + myCar.isEngineOn());
        
        // Try to start again (should show it's already running)
        System.out.println("\n=== Trying to start again ===");
        myCar.startEngine();
        
        // Accelerate
        System.out.println("\n=== Accelerating ===");
        myCar.accelerate(30);
        System.out.println("Current speed: " + myCar.getCurrentSpeed() + " mph");
        
        // Brake
        System.out.println("\n=== Braking ===");
        myCar.brake(10);
        System.out.println("Speed after braking: " + myCar.getCurrentSpeed() + " mph");
        
        // Stop the car
        System.out.println("\n=== Stopping the car ===");
        myCar.stopEngine();
        System.out.println("Is engine running? " + myCar.isEngineOn());
        
        // Try to accelerate when engine is off
        System.out.println("\n=== Trying to accelerate when engine is off ===");
        myCar.accelerate(20);
        
        System.out.println("\n===== Car Demo Completed =====\n");
    }
}
