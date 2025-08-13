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
        
        // Run the exercises (uncomment the one you want to test)
        exercise1_Car();
        // exercise2_BankAccount();
        // exercise3_Student();
    }

    /**
     * Exercise 1: Car Class Demo
     * 
     * This method demonstrates the functionality of the Car class by simulating
     * a car rental scenario with different operations.
     */
    private static void exercise1_Car() {
        System.out.println("\n=== Car Rental System Demo ===");
        
        // Create a new car
        System.out.println("\n1. Creating a new car...");
        Car myCar = new Car("Toyota", "Camry", 2023);
        
        // Display initial car information
        System.out.println("\n2. Car Information:");
        myCar.getCarInfo();
        
        // Test engine operations
        System.out.println("\n3. Testing Engine Operations:");
        System.out.println("   - Starting engine...");
        myCar.startEngine();
        
        // Try to start engine again (should show it's already on)
        System.out.println("   - Trying to start engine again...");
        myCar.startEngine();
        
        // Test driving operations
        System.out.println("\n4. Testing Driving Operations:");
        System.out.println("   - Accelerating to 30 km/h...");
        myCar.accelerate(30);
        
        System.out.println("   - Accelerating by 20 km/h more...");
        myCar.accelerate(20);
        
        System.out.println("   - Current speed: " + myCar.getCurrentSpeed() + " km/h");
        
        // Test braking
        System.out.println("\n5. Testing Braking:");
        System.out.println("   - Braking by 15 km/h...");
        myCar.brake(15);
        System.out.println("   - Current speed: " + myCar.getCurrentSpeed() + " km/h");
        
        // Try to stop while moving (should fail)
        System.out.println("\n6. Trying to stop engine while moving...");
        myCar.stopEnginge();
        
        // Come to a complete stop
        System.out.println("\n7. Coming to a complete stop...");
        myCar.brake(35);
        
        // Now stop the engine
        System.out.println("\n8. Stopping the engine...");
        myCar.stopEnginge();
        
        // Try to accelerate with engine off (should fail)
        System.out.println("\n9. Trying to accelerate with engine off...");
        myCar.accelerate(20);
        
        // Final car status
        System.out.println("\n10. Final Car Status:");
        myCar.getCarInfo();
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
