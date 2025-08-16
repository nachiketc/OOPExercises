package com.oop.practice.models.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car testCar;

    @BeforeEach
    void setUp() {
        testCar = new Car("Toyota", "Camry", 2023);
    }

    @Test
    void testCarCreation() {
        assertNotNull(testCar, "Car should be created");
        assertEquals("Toyota", testCar.getMake(), "Make should be Toyota");
        assertEquals("Camry", testCar.getModel(), "Model should be Camry");
        assertEquals(2023, testCar.getYear(), "Year should be 2023");
        assertEquals(0, testCar.getCurrentSpeed(), "Initial speed should be 0");
        assertFalse(testCar.isEngineOn(), "Engine should be off initially");
    }

    @Test
    void testStartEngine() {
        testCar.startEngine();
        assertTrue(testCar.isEngineOn(), "Engine should be on after starting");
    }

    @Test
    void testStopEngineWhenMoving() {
        testCar.startEngine();
        testCar.accelerate(30);
        testCar.stopEngine();
        assertTrue(testCar.isEngineOn(), "Engine should still be on when trying to stop while moving");
    }

    @Test
    void testAccelerate() {
        testCar.startEngine();
        testCar.accelerate(30);
        assertEquals(30, testCar.getCurrentSpeed(), "Speed should be 30 after accelerating by 30");
    }

    @Test
    void testAccelerateWhenEngineOff() {
        testCar.accelerate(20);
        assertEquals(0, testCar.getCurrentSpeed(), "Speed should remain 0 when accelerating with engine off");
    }

    @Test
    void testBrake() {
        testCar.startEngine();
        testCar.accelerate(50);
        testCar.brake(20);
        assertEquals(30, testCar.getCurrentSpeed(), "Speed should be 30 after braking by 20 from 50");
    }

    @Test
    void testBrakeBelowZero() {
        testCar.startEngine();
        testCar.accelerate(20);
        testCar.brake(30);
        assertEquals(0, testCar.getCurrentSpeed(), "Speed should not go below 0");
    }

    @Test
    void testCarCreationWithValidYear() {
        assertDoesNotThrow(() -> new Car("Toyota", "Camry", 2023));
        assertDoesNotThrow(() -> new Car("Toyota", "Camry", 1865));
        assertDoesNotThrow(() -> new Car("Toyota", "Camry", 2024));
    }

    @ParameterizedTest
    @ValueSource(ints = {1864, 1000, -1, 0})
    void testCarCreationWithYearBefore1865_ShouldThrowException(int year) {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Car("Toyota", "Camry", year));
        assertTrue(exception.getMessage().contains("cannot be less than 1865"));
    }

    @Test
    void testCarCreationWithFutureYear_ShouldThrowException() {
        int futureYear = java.time.Year.now().getValue() + 1;
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Car("Toyota", "Camry", futureYear));
        assertTrue(exception.getMessage().contains("cannot be greater than"));
    }
}
