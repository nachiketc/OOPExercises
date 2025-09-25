package com.oop.practice.demo.thermostat;

import com.oop.practice.models.thermostat.Thermostat;
import com.oop.practice.pojos.TemperatureLog;

import java.util.List;
import java.util.Scanner;

/**
 * Demo class to demonstrate the functionality of the Thermostat class.
 */
public class ThermostatDemo {
    private final Thermostat thermostat;
    private final Scanner scanner;

    public ThermostatDemo() {
        this.thermostat = new Thermostat();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n===== Thermostat Demo =====");
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("\nSelect an option (0-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        displayCurrentTemperature();
                        break;
                    case 2:
                        increaseTemperature();
                        break;
                    case 3:
                        decreaseTemperature();
                        break;
                    case 4:
                        displayTemperatureLogs();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting Thermostat Demo...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nCurrent Temperature: " + thermostat.getTemp() + "°C");
        System.out.println("\n1. Display Current Temperature");
        System.out.println("2. Increase Temperature");
        System.out.println("3. Decrease Temperature");
        System.out.println("4. View Temperature Logs");
        System.out.println("0. Back to Main Menu");
    }

    private void displayCurrentTemperature() {
        System.out.printf("\nCurrent temperature is: %.1f°C%n", thermostat.getTemp());
    }

    private void increaseTemperature() {
        try {
            System.out.print("Enter temperature to increase by: ");
            double increment = Double.parseDouble(scanner.nextLine());
            double newTemp = thermostat.increaseTemp(increment);
            System.out.printf("Temperature increased to: %.1f°C%n", newTemp);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void decreaseTemperature() {
        try {
            System.out.print("Enter temperature to decrease by: ");
            double decrement = Double.parseDouble(scanner.nextLine());
            double newTemp = thermostat.decreaseTemp(decrement);
            System.out.printf("Temperature decreased to: %.1f°C%n", newTemp);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayTemperatureLogs() {
        List<TemperatureLog> logs = thermostat.getTemperatureLogList();
        System.out.println("\n===== Temperature Logs =====");
        if (logs.isEmpty()) {
            System.out.println("No temperature logs available.");
        } else {
            for (int i = 0; i < logs.size(); i++) {
                TemperatureLog log = logs.get(i);
                System.out.printf("%d. [%.1f°C] %s%n",
                    i + 1, log.finalTemp(), log.message());
            }
        }
    }
}
