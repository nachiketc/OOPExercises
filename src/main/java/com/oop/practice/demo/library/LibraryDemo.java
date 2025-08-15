package com.oop.practice.demo.library;

import com.oop.practice.models.library.Book;
import com.oop.practice.models.library.Library;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Demo class for the Library Management System.
 * Demonstrates the functionality of the Library and Book classes.
 */
public class LibraryDemo {
    
    /**
     * Runs the library system demo.
     */
    public static void run() {
        System.out.println("\n===== Starting Library Management System Demo =====");
        
        // Initialize library
        Library library = new Library();
        
        // Add some books
        System.out.println("\n=== Adding Books to Library ===");
        library.addBook("1984", "George Orwell", "978-0451524935");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        
        // Try to add a duplicate
        System.out.println("\n=== Attempting to Add Duplicate Book ===");
        library.addBook("1984", "George Orwell", "978-0451524935");
        
        // List all books
        System.out.println("\n=== Listing All Books ===");
        library.listAllBooks();
        
        // Search for a book
        System.out.println("\n=== Searching for Books ===");
        Optional<Book> book = library.searchByTitle("1984");
        book.ifPresent(b -> System.out.println("Found book: " + b));
        
        // Check out a book
        System.out.println("\n=== Checking Out a Book ===");
        book.ifPresent(b -> {
            Date today = new Date();
            Date dueDate = new Date(today.getTime() + TimeUnit.DAYS.toMillis(14)); // 2 weeks from now
            library.checkOutBook(b, today, dueDate);
            
            // Try to check out the same book again
            System.out.println("\n=== Attempting to Check Out Already Checked Out Book ===");
            library.checkOutBook(b, today, dueDate);
            
            // Check in the book
            System.out.println("\n=== Checking In the Book ===");
            library.checkInBook(b, dueDate);
            
            // Test late return
            System.out.println("\n=== Testing Late Return ===");
            library.checkOutBook(b, today, dueDate);
            Date lateReturnDate = new Date(dueDate.getTime() + TimeUnit.DAYS.toMillis(5)); // 5 days late
            library.checkInBook(b, lateReturnDate);
        });
        
        // Test search and filter
        System.out.println("\n=== Testing Search and Filter ===");
        System.out.println("Books by 'Harper Lee':");
        library.searchByAuthor("Harper Lee").ifPresent(System.out::println);
        
        System.out.println("\nBooks containing 'Great':");
        library.filterByTitle("Great").forEach(System.out::println);
        
        System.out.println("\n===== Library Management System Demo Completed =====\n");
    }
}
