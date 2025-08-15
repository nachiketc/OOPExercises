package com.oop.practice.models.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book;
    private Date today;
    private Date tomorrow;

    @BeforeEach
    void setUp() {
        book = new Book("Test Book", "Test Author", "123-4567890123");
        today = new Date();
        tomorrow = new Date(today.getTime() + TimeUnit.DAYS.toMillis(1));
    }

    @Test
    void testBookCreation() {
        assertNotNull(book);
        assertEquals("Test Book", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("123-4567890123", book.getIsbn());
        assertTrue(book.isAvailable());
    }

    @Test
    void testCheckOutBook() {
        book.checkOutBook(today, tomorrow);
        assertFalse(book.isAvailable());
    }

    @Test
    void testCheckInBook() {
        book.checkOutBook(today, tomorrow);
        book.checkInBook();
        assertTrue(book.isAvailable());
        assertEquals(0, book.getLateFees());
    }

    @Test
    void testLateFeesCalculation() {
        // First check out the book
        book.checkOutBook(today, tomorrow);
        
        // Set check-in date to 5 days after due date
        Date lateCheckIn = new Date(tomorrow.getTime() + TimeUnit.DAYS.toMillis(5));
        book.checkLateFees(lateCheckIn);
        
        // Should be 5 days * 10 = 50 in late fees
        assertEquals(50, book.getLateFees());
        assertTrue(book.isLate());
    }

    @Test
    void testExists() {
        assertTrue(book.exists("Test Book", "Test Author", "123-4567890123"));
        assertFalse(book.exists("Wrong Title", "Test Author", "123-4567890123"));
    }

    @Test
    void testInvalidCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "Author", "123"));
        assertThrows(IllegalArgumentException.class, () -> new Book("Title", null, "123"));
        assertThrows(IllegalArgumentException.class, () -> new Book("Title", "Author", null));
        assertThrows(IllegalArgumentException.class, () -> new Book("", "Author", "123"));
    }
}
