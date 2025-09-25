package com.oop.practice.constants;

import java.math.BigDecimal;

public class ThermostatConstants {
    // Temperature settings
    public static final double DEFAULT_TEMP = 25.0;
    public static final double LOWER_LIMIT = 15.0;
    public static final double UPPER_LIMIT = 32.0;

    // Error messages
    public static final String ERR_NEGATIVE_CHANGE = "Temperature change cannot be negative";
    public static final String ERR_ABOVE_MAX = "Temperature cannot exceed " + UPPER_LIMIT + "°C";
    public static final String ERR_BELOW_MIN = "Temperature cannot be below " + LOWER_LIMIT + "°C";

    // Log messages
    public static final String INITIALIZED = "Thermostat initialized at %.1f°C";
    public static final String LOG_TEMP_CHANGE = "Temperature changed to %.1f°C";
    public static final String LOG_INCREASE = "Increased by %.1f°C to %.1f°C";
    public static final String LOG_DECREASE = "Decreased by %.1f°C to %.1f°C";
}
