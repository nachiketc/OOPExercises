package com.oop.practice.classes_objects.exercises;

// Import model classes
import com.oop.practice.models.car.Car;
import com.oop.practice.models.bank.BankAccount;
import com.oop.practice.models.student.Student;

/**
 * OOP Practice Exercises
 * 
 * This is the main class containing exercises for practicing OOP concepts in Java.
 * Each exercise uses classes from their respective packages.
 * Uncomment the exercise you want to run in the main method.
 */
public class OOPExercises {
    
    public static void main(String[] args) {
        System.out.println("=== OOP Practice Exercises ===\n");
        
        // Uncomment the exercise you want to test
        // exercise1_Car();
        // exercise2_BankAccount();
        // exercise3_Student();
    }

    /**
     * Exercise 1: Basic Car Class
     * 
     * The Car class is located in: com.oop.practice.models.car.Car
     * 
     * Implement the following in the Car class:
     * - Fields: make, model, year, currentSpeed, isEngineOn
     * - Methods: startEngine(), stopEngine(), accelerate(), brake(), getCurrentSpeed(), getCarInfo()
     * - Constructors: No-arg and parameterized
     * - Input validation
     */
    private static void exercise1_Car() {
        System.out.println("\n--- Exercise 1: Car Class ---");
        // Test your Car class here
        // Example:
        // Car myCar = new Car("Toyota", "Camry", 2023);
        // myCar.startEngine();
        // myCar.accelerate(50);
        // System.out.println("Current speed: " + myCar.getCurrentSpeed());
    }

    /**
     * Exercise 2: Bank Account Class
     * 
     * The BankAccount class is located in: com.oop.practice.models.bank.BankAccount
     * 
     * Implement the following in the BankAccount class:
     * - Fields: accountNumber, accountHolder, balance
     * - Methods: deposit(), withdraw(), getBalance(), displayAccountInfo()
     * - Ensure proper encapsulation with private fields and public methods
     * - Add validation for negative amounts and insufficient funds
     */
    private static void exercise2_BankAccount() {
        System.out.println("\n--- Exercise 2: Bank Account ---");
        // Test your BankAccount class here
    }

    /**
     * Exercise 3: Student Class
     * 
     * The Student class is located in: com.oop.practice.models.student.Student
     * 
     * Implement the following in the Student class:
     * - Fields: name, rollNumber, subjects (array), grades (array)
     * - Methods: addSubject(), addGrade(), calculateGPA(), getStudentInfo()
     * - Add validation for grades (e.g., A, B, C, D, F)
     */
    private static void exercise3_Student() {
        System.out.println("\n--- Exercise 3: Student ---");
        // Test your Student class here
    }
}
