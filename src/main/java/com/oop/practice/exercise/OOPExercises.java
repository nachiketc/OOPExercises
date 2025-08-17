package com.oop.practice.exercise;

import com.oop.practice.demo.bank.BankDemo;
import com.oop.practice.demo.car.CarDemo;
import com.oop.practice.demo.library.LibraryDemo;
import com.oop.practice.demo.student.StudentDemo;
import com.oop.practice.demo.user.UserDemo;

import java.util.Scanner;

/**
 * Main class for running OOP exercises.
 * This serves as the entry point for all OOP concept demonstrations.
 */
public class OOPExercises {
    
    /**
     * Main method to run the OOP exercises.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== OOP Exercises Menu =====");
            System.out.println("1. Bank Account Demo");
            System.out.println("2. Car Demo");
            System.out.println("3. Library Management Demo");
            System.out.println("4. Student Management Demo");
            System.out.println("5. User Authentication Demo");
            System.out.println("0. Exit");
            System.out.print("\nSelect an option (0-5): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        runBankAccountDemo();
                        break;
                    case 2:
                        runCarDemo();
                        break;
                    case 3:
                        runLibraryDemo();
                        break;
                    case 4:
                        runStudentDemo();
                        break;
                    case 5:
                        runUserAuthDemo();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        scanner.close();
        System.out.println("\n===== Thank you for using OOP Exercises =====");
    }
    
    /**
     * Runs the Bank Account demo.
     */
    private static void runBankAccountDemo() {
        System.out.println("\n[1/4] Running Bank Account Demo...");
        BankDemo.run();
    }
    
    /**
     * Runs the Car demo.
     */
    private static void runCarDemo() {
        System.out.println("\n[2/4] Running Car Demo...");
        CarDemo.run();
    }
    
    /**
     * Runs the Library Management System demo.
     */
    private static void runLibraryDemo() {
        System.out.println("\n[3/4] Running Library Management System Demo...");
        LibraryDemo.run();
    }
    
    /**
     * Runs the Student Management demo.
     */
    private static void runStudentDemo() {
        System.out.println("\n=== Running Student Management Demo ===\n");
        StudentDemo.run();
    }
    
    /**
     * Runs the User Authentication demo.
     */
    private static void runUserAuthDemo() {
        System.out.println("\n=== Running User Authentication Demo ===\n");
        UserDemo.run();
    }
}
