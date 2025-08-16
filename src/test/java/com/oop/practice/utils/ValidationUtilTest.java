package com.oop.practice.utils;

import com.oop.practice.pojos.ValidationResponse;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void validateString_ShouldReturnValid_WhenInputIsValid() {
        ValidationResponse response = ValidationUtil.validateString("valid", "test");
        assertTrue(response.isValid());
    }

    @Test
    void validateString_ShouldReturnInvalid_WhenInputIsNull() {
        ValidationResponse response = ValidationUtil.validateString(null, "test");
        assertFalse(response.isValid());
        assertEquals("test cannot be null or empty", response.getErrorMessage());
    }

    @Test
    void validateString_ShouldReturnInvalid_WhenInputIsEmpty() {
        ValidationResponse response = ValidationUtil.validateString("", "test");
        assertFalse(response.isValid());
        assertEquals("test cannot be null or empty", response.getErrorMessage());
    }

    @Test
    void validateString_ShouldReturnInvalid_WhenInputIsWhitespace() {
        ValidationResponse response = ValidationUtil.validateString("   ", "test");
        assertFalse(response.isValid());
        assertEquals("test cannot be null or empty", response.getErrorMessage());
    }

    @Test
    void validateNonNull_ShouldReturnValid_WhenInputIsNotNull() {
        ValidationResponse response = ValidationUtil.validateNonNull("not null", "test");
        assertTrue(response.isValid());
    }

    @Test
    void validateNonNull_ShouldReturnInvalid_WhenInputIsNull() {
        ValidationResponse response = ValidationUtil.validateNonNull(null, "test");
        assertFalse(response.isValid());
        assertEquals("test cannot be null", response.getErrorMessage());
    }

    @Test
    void validateRangeInt_ShouldReturnValid_WhenInputIsWithinRange() {
        ValidationResponse response = ValidationUtil.validateRangeInt(5, "test", 1, 10);
        assertTrue(response.isValid());
    }

    @Test
    void validateRangeInt_ShouldReturnInvalid_WhenInputIsBelowRange() {
        ValidationResponse response = ValidationUtil.validateRangeInt(0, "test", 1, 10);
        assertFalse(response.isValid());
        assertEquals("test cannot be less than 1", response.getErrorMessage());
    }

    @Test
    void validateRangeInt_ShouldReturnInvalid_WhenInputIsAboveRange() {
        ValidationResponse response = ValidationUtil.validateRangeInt(11, "test", 1, 10);
        assertFalse(response.isValid());
        assertEquals("test cannot be greater than 10", response.getErrorMessage());
    }

    @Test
    void validateStringAndThrow_ShouldNotThrow_WhenInputIsValid() {
        assertDoesNotThrow(() -> ValidationUtil.validateStringAndThrow("valid", "test"));
    }

    @Test
    void validateStringAndThrow_ShouldThrow_WhenInputIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> ValidationUtil.validateStringAndThrow("", "test"));
        assertEquals("test cannot be null or empty", exception.getMessage());
    }

    @Test
    void validateNonNullAndThrow_ShouldNotThrow_WhenInputIsValid() {
        assertDoesNotThrow(() -> ValidationUtil.validateNonNullAndThrow("valid", "test"));
    }

    @Test
    void validateNonNullAndThrow_ShouldThrow_WhenInputIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> ValidationUtil.validateNonNullAndThrow(null, "test"));
        assertEquals("test cannot be null", exception.getMessage());
    }

    @Test
    void validateRangeIntAndThrow_ShouldNotThrow_WhenInputIsInRange() {
        assertDoesNotThrow(() -> ValidationUtil.validateRangeIntAndThrow(5, "test", 1, 10));
    }

    @Test
    void validateRangeIntAndThrow_ShouldThrow_WhenInputIsBelowRange() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> ValidationUtil.validateRangeIntAndThrow(0, "test", 1, 10));
        assertEquals("test cannot be less than 1", exception.getMessage());
    }

    @Test
    void validateRangeIntAndThrow_ShouldThrow_WhenInputIsAboveRange() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> ValidationUtil.validateRangeIntAndThrow(11, "test", 1, 10));
        assertEquals("test cannot be greater than 10", exception.getMessage());
    }
}
