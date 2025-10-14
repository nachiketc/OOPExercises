package com.oop.practice.demo.vehicle;

import com.oop.practice.models.vehicle.Car;
import com.oop.practice.models.vehicle.ElectricCar;
import com.oop.practice.models.vehicle.Motorcycle;
import com.oop.practice.models.vehicle.Vehicle;
import com.oop.practice.enums.BikeType;
import com.oop.practice.enums.TransmissionType;

public class VehicleDemo {

    public static void main(String[] args) {
        System.out.println("=== Vehicle Hierarchy Demo ===\n");

        // Create different types of vehicles
        // Vehicle(String make, String model, int year, double speed, int capacity)
        Vehicle genericVehicle = new Vehicle("Generic", "Vehicle", 2023, 0.0, 4);

        // Car(String make, String model, int year, double speed, int capacity, TransmissionType transmissionType, int numDoors)
        Car sedan = new Car("Toyota", "Camry", 2023, 0.0, 5, TransmissionType.AUTOMATIC, 4);

        // Motorcycle(String make, String model, int year, double speed, int capacity, boolean hasSideCar, BikeType bikeType)
        Motorcycle harley = new Motorcycle("Harley-Davidson", "Sportster", 2023, 0.0, 2, true, BikeType.CRUISER);

        // ElectricCar(String make, String model, int year, double speed, int capacity, TransmissionType transmissionType, int numDoors, double batteryCapacity, double currentCharge)
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2023, 0.0, 5, TransmissionType.AUTOMATIC, 4, 75.0, 0.0);

        // Demonstrate method overriding
        System.out.println("=== Method Overriding ===");
        System.out.println("Generic Vehicle: " + genericVehicle.getVehicleInfo());
        System.out.println("Sedan: " + sedan.getVehicleInfo());
        System.out.println("Motorcycle: " + harley.getVehicleInfo());
        System.out.println("Electric Car: " + tesla.getVehicleInfo() + "\n");

        // Demonstrate polymorphism
        System.out.println("=== Polymorphism ===");
        Vehicle[] vehicles = {genericVehicle, sedan, harley, tesla};
        for (Vehicle vehicle : vehicles) {
            System.out.println("Starting engine for: " + vehicle.getMake() + " " + vehicle.getModel());
            vehicle.turnEngineOn();

            // Demonstrate type checking and casting
            if (vehicle instanceof Motorcycle) {
                ((Motorcycle) vehicle).wheelie();
            } else if (vehicle instanceof ElectricCar) {
                ((ElectricCar) vehicle).chargeBattery(50);
            }
            System.out.println();
        }

        // Demonstrate encapsulation
        System.out.println("=== Encapsulation ===");
        System.out.println("Tesla's current speed: " + tesla.getSpeed() + " km/h");
        tesla.accelerate(30);
        System.out.println("After accelerating: " + tesla.getSpeed() + " km/h");

        // Try to set invalid speed (will be ignored due to validation)
        tesla.accelerate(-50);
        System.out.println("After invalid speed set: " + tesla.getSpeed() + " km/h (no change)");

        // Show electric car specific functionality
        System.out.println("\n=== Electric Car Features ===");
        System.out.println("Current charge: " + tesla.getCurrentCharge() + "%");
        tesla.chargeBattery(30);
        System.out.println("After charging: " + tesla.getCurrentCharge() + "%");

        // Show motorcycle specific functionality
        System.out.println("\n=== Motorcycle Features ===");
        System.out.println("Has sidecar: " + harley.isHasSideCar());
        harley.wheelie();
    }
}
