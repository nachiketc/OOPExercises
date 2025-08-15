package com.oop.practice.models.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Date today;
    private Date tomorrow;
    private Book testBook;

    @BeforeEach
    void setUp() {
        library = new Library();
        today = new Date();
        tomorrow = new Date(today.getTime() + TimeUnit.DAYS.toMillis(1));
        testBook = new Book("Test Book", "Test Author", "123-4567890123");
        library.addBook(testBook.getTitle(), testBook.getAuthor(), testBook.getIsbn());
    }

    @Test
    void testAddBook() {
        // Test adding a new book
        String title = "New Book";
        String author = "New Author";
        String isbn = "123-4567890124";
        
        // Should not exist before adding
        assertFalse(library.searchByTitle(title).isPresent());
        
        // Add the book
        library.addBook(title, author, isbn);
        
        // Should exist after adding
        Optional<Book> foundBook = library.searchByTitle(title);
        assertTrue(foundBook.isPresent());
        assertEquals(title, foundBook.get().getTitle());
        assertEquals(author, foundBook.get().getAuthor());
        assertEquals(isbn, foundBook.get().getIsbn());
    }

    @Test
    void testCheckOutBook() {
        Optional<Book> foundBook = library.searchByTitle("Test Book");
        assertTrue(foundBook.isPresent());
        
        library.checkOutBook(foundBook.get(), today, tomorrow);
        assertFalse(foundBook.get().isAvailable());
    }

    @Test
    void testCheckInBook() {
        library.checkOutBook(testBook, today, tomorrow);
        library.checkInBook(testBook, tomorrow);
        assertTrue(testBook.isAvailable());
    }

    @Test
    void testSearchMethods() {
        assertTrue(library.searchByTitle("Test Book").isPresent());
        assertTrue(library.searchByAuthor("Test Author").isPresent());
        assertTrue(library.searchByISBN("123-4567890123").isPresent());
    }

    @Test
    void testFilterMethods() {
        library.addBook("Another Book", "Test Author", "123-4567890124");
        
        assertEquals(1, library.filterByTitle("Another").size());
        assertEquals(2, library.filterByAuthor("Test").size());
        assertEquals(1, library.filterByISBN("123-4567890124").size());
    }

    @Test
    void testLateFees() {
        // Check out the book with today as due date
        library.checkOutBook(testBook, today, today);
        
        // Check in 5 days late
        Date lateCheckIn = new Date(today.getTime() + TimeUnit.DAYS.toMillis(5));
        library.checkInBook(testBook, lateCheckIn);
        
        // Should be 5 days * 10 = 50 in late fees
        assertEquals(50, testBook.getLateFees());
        assertTrue(testBook.isLate());
    }

    @Test
    void testInvalidInputs() {
        // Test null inputs in Book constructor
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "Author", "123"));
        
        // Test null/empty inputs in library methods
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, "Author", "123"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("", "Author", "123"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Title", null, "123"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Title", "", "123"));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Title", "Author", null));
        assertThrows(IllegalArgumentException.class, () -> library.addBook("Title", "Author", ""));
        
        // Test search with null/empty
        assertDoesNotThrow(() -> library.searchByTitle(null));
        assertDoesNotThrow(() -> library.searchByAuthor(""));
        assertDoesNotThrow(() -> library.searchByISBN("   "));
    }
}
