package com.oop.practice.models.thermostat;

import com.oop.practice.constants.ThermostatConstants;
import com.oop.practice.pojos.TemperatureLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    private Thermostat thermostat;
    private static final double INITIAL_TEMP = ThermostatConstants.DEFAULT_TEMP;
    private static final double TEST_INCREMENT = 5.0;
    private static final double TEST_DECREMENT = 3.0;

    @BeforeEach
    void setUp() {
        thermostat = new Thermostat();
    }

    @Test
    void testInitialTemperature() {
        assertEquals(INITIAL_TEMP, thermostat.getTemp(),
            "Initial temperature should match default temperature");
    }

    @Test
    void testIncreaseTemperature() {
        // When
        double newTemp = thermostat.increaseTemp(TEST_INCREMENT);

        // Then
        double expectedTemp = INITIAL_TEMP + TEST_INCREMENT;
        assertEquals(expectedTemp, newTemp,
            "Temperature should increase by the specified amount");
        assertEquals(expectedTemp, thermostat.getTemp(),
            "Current temperature should be updated");
    }

    @Test
    void testDecreaseTemperature() {
        // When
        double newTemp = thermostat.decreaseTemp(TEST_DECREMENT);

        // Then
        double expectedTemp = INITIAL_TEMP - TEST_DECREMENT;
        assertEquals(expectedTemp, newTemp,
            "Temperature should decrease by the specified amount");
        assertEquals(expectedTemp, thermostat.getTemp(),
            "Current temperature should be updated");
    }

    @Test
    void testIncreaseTemperatureBeyondUpperLimit() {
        // Given
        double tooHighIncrement = ThermostatConstants.UPPER_LIMIT + 1;

        // When/Then
        assertThrows(IllegalStateException.class,
            () -> thermostat.increaseTemp(tooHighIncrement),
            "Should throw when trying to exceed upper temperature limit");
    }

    @Test
    void testDecreaseTemperatureBelowLowerLimit() {
        // Given
        double tooHighDecrement = ThermostatConstants.LOWER_LIMIT + 1;

        // When/Then
        assertThrows(IllegalStateException.class,
            () -> thermostat.decreaseTemp(tooHighDecrement),
            "Should throw when trying to go below lower temperature limit");
    }

    @Test
    void testNegativeTemperatureChange() {
        // When/Then
        assertThrows(IllegalArgumentException.class,
            () -> thermostat.increaseTemp(-1.0),
            "Should throw when trying to increase with negative value");

        assertThrows(IllegalArgumentException.class,
            () -> thermostat.decreaseTemp(-1.0),
            "Should throw when trying to decrease with negative value");
    }

    @Test
    void testTemperatureLogging() {
        // When
        thermostat.increaseTemp(5.0);
        thermostat.decreaseTemp(3.0);

        // Then
        List<TemperatureLog> logs = thermostat.getTemperatureLogList();
        assertNotNull(logs, "Log list should not be null");
        assertEquals(3, logs.size(), "Should have exactly 3 log entries (initial + increase + decrease)");
        
        // Verify log messages in order
        assertTrue(logs.get(0).message().contains("initialized"),
            "First log should contain initialization message");
            
        assertTrue(logs.get(1).message().contains("Increased") || logs.get(1).message().contains("increased"),
            "Second log should be for temperature increase");
            
        assertTrue(logs.get(2).message().contains("Decreased") || logs.get(2).message().contains("decreased"),
            "Third log should be for temperature decrease");
            
        // Verify temperature values in logs
        assertEquals(25.0, logs.get(0).finalTemp(), 0.001, "Initial temperature should be 25.0");
        assertEquals(30.0, logs.get(1).finalTemp(), 0.001, "Temperature after increase should be 30.0");
        assertEquals(27.0, logs.get(2).finalTemp(), 0.001, "Temperature after decrease should be 27.0");
    }

    @Test
    void testLogsAreImmutable() {
        // When
        List<TemperatureLog> logs = thermostat.getTemperatureLogList();

        // Then
        assertThrows(UnsupportedOperationException.class,
            () -> logs.add(TemperatureLog.logTemp(25.0, "test")),
            "Should not be able to modify logs list directly");
    }

    @Test
    void testMultipleOperations() {
        // When - using safe values within limits
        thermostat.increaseTemp(5.0);  // 25 + 5 = 30
        thermostat.decreaseTemp(3.0);  // 30 - 3 = 27
        thermostat.increaseTemp(2.0);  // 27 + 2 = 29

        // Then
        assertEquals(29.0, 
            thermostat.getTemp(), 
            0.001, 
            "Should handle multiple operations correctly");
    }
}
