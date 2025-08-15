package com.oop.practice.models.library;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: Title, author, and ISBN cannot be null or empty");
            return;
        }
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
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Title cannot be null or empty");
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(books.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .toList().get(0));
        }
    }

    public Optional<Book> searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author cannot be null or empty");
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(books.stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .collect(Collectors.toList()).get(0));
        }
    }

    public Optional<Book> searchByISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: ISBN cannot be null or empty");
            return Optional.empty();
        }
        if (books.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.ofNullable(books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .collect(Collectors.toList()).get(0));
        }
    }

    public List<Book> filterByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Title cannot be null or empty");
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
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author cannot be null or empty");
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
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Error: ISBN cannot be null or empty");
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
