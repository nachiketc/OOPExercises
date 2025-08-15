package com.oop.practice.models.library;

import com.oop.practice.pojos.ValidationResponse;
import com.oop.practice.utils.ValidationUtil;

import java.util.*;
import java.util.stream.Collectors;

import static com.oop.practice.constants.LibraryConstants.*;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        // Validate inputs first
        ValidationUtil.validateStringAndThrow(title, TITLE);
        ValidationUtil.validateStringAndThrow(author, AUTHOR);
        ValidationUtil.validateStringAndThrow(isbn, ISBN);
        if (books.stream().anyMatch(book -> book.exists(title,author,isbn))) {
            System.out.println("Book already exists");
        } else {
            Book book = new Book(title,author,isbn);
            books.add(book);
            System.out.println("Added a new book to the library");
            System.out.println(book.toString());
        }

    }

    public void removeBook(Book book) {
        if (book == null) {
            System.out.println("Error: Book cannot be null");
            return;
        }
        if (!books.contains(book)){
            System.out.println("Book doesn't exist");
        } else {
            books.remove(book);
        }
    }

    public void listAllBooks() {
        books.stream().forEach(book -> System.out.println(book.toString()));
    }

    public void checkOutBook(Book book, Date checkOutDate, Date dueDate) {
        if (book == null || checkOutDate == null || dueDate == null) {
            System.out.println("Error: Book and dates cannot be null");
            return;
        }
        if (!book.isAvailable()){
            System.out.println("Book is not available for checkout");
        } else {
            book.checkOutBook(checkOutDate,dueDate);
            System.out.println("Checkout out a book till " + dueDate);
            System.out.println(book.toString());
        }
    }
    public void checkInBook(Book book, Date checkInDate) {
        if (book == null || checkInDate == null) {
            System.out.println("Error: Book and check-in date cannot be null");
            return;
        }
        book.checkLateFees(checkInDate);
        if (book.isLate()){
            System.out.println("Check in date is past due date");
            System.out.println("The late fee charges are : Rs. " + book.getLateFees());
        } else {
            book.checkInBook();
            System.out.println("Book returned successfully");
            System.out.println(book.toString());
        }
    }

    public void checkinBookWithLateFees(Book book, Date checkInDate, int lateFees) {
        if (book == null || checkInDate == null) {
            System.out.println("Error: Book and check-in date cannot be null");
            return;
        }
        book.checkLateFees(checkInDate);
        if (lateFees == book.getLateFees()){
            System.out.println("Late fees paid");
            book.checkInBook();
            System.out.println("Book returned successfully");
            System.out.println(book.toString());
        }
    }

    public Optional<Book> searchByTitle(String title) {
        ValidationResponse validationResponse = ValidationUtil.validateString(title,TITLE);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return books.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .findFirst();
        }
    }

    public Optional<Book> searchByAuthor(String author) {
        ValidationResponse validationResponse = ValidationUtil.validateString(author,AUTHOR);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return books.stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .findFirst();
        }
    }

    public Optional<Book> searchByISBN(String isbn) {
        ValidationResponse validationResponse = ValidationUtil.validateString(isbn,ISBN);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .findFirst();
        }
    }

    public List<Book> filterByTitle(String title) {
        ValidationResponse validationResponse = ValidationUtil.validateString(title,TITLE);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Collections.emptyList();
        }
        if (books.isEmpty()){
            return Collections.emptyList();
        } else {
            return books.stream()
                    .filter(book -> book.getTitle().contains(title))
                    .collect(Collectors.toList());
        }
    }

    public List<Book> filterByAuthor(String author) {
        ValidationResponse validationResponse = ValidationUtil.validateString(author,AUTHOR);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Collections.emptyList();
        }
        if (books.isEmpty()){
            return Collections.emptyList();
        } else {
            return books.stream()
                    .filter(book -> book.getAuthor().contains(author))
                    .collect(Collectors.toList());
        }
    }

    public List<Book> filterByISBN(String isbn) {
        ValidationResponse validationResponse = ValidationUtil.validateString(isbn,ISBN);
        if(!validationResponse.isValid()){
            System.out.println("Error: "+validationResponse.getErrorMessage());
            return Collections.emptyList();
        }
        if (books.isEmpty()){
            return Collections.emptyList();
        } else {
            return books.stream()
                    .filter(book -> book.getIsbn().contains(isbn))
                    .collect(Collectors.toList());
        }
    }
}
