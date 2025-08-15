package com.oop.practice.models.library;

import com.oop.practice.utils.ValidationUtil;

import java.net.IDN;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;

import static com.oop.practice.constants.LibraryConstants.*;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isAvailable;
    private Date checkIn;
    private Date checkOut;
    private int lateFees;
    private boolean isLate;
    private final int LATE_FEE_PER_DAY = 10;

    public Book(String title, String author, String isbn) {
        ValidationUtil.validateStringAndThrow(title,TITLE);
        ValidationUtil.validateStringAndThrow(author,AUTHOR);
        ValidationUtil.validateStringAndThrow(isbn, ISBN);
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.isAvailable = true;
        this.checkIn = new Date();
        this.checkOut = new Date();
        this.lateFees = 0;
        this.isLate = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isLate() {
        return isLate;
    }

    public int getLateFees() {
        return lateFees;
    }

    public void checkOutBook(Date checkOut, Date checkIn) {
        if (checkOut == null || checkIn == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (checkIn.before(checkOut)) {
            System.out.println("Check in date cannot be before checkout");
        } else {
            this.checkOut = checkOut;
            this.checkIn = checkIn;
            this.isAvailable = false;
            this.lateFees = 0;
            this.isLate = false;
        }
    }

    public void checkLateFees(Date checkIn) {
        if (checkIn == null) {
            throw new IllegalArgumentException("Check-in date cannot be null");
        }
        if (checkIn.before(checkOut)) {
            System.out.println("Check-in date is before check-out date");
            return;
        }
        
        // Calculate days between due date (this.checkIn) and actual check-in date
        long daysLate = ChronoUnit.DAYS.between(
            this.checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            checkIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );
        
        if (daysLate > 0) {
            calculateLateFees((int) daysLate);
        }    }

    public void checkInBook(){
        isAvailable=true;
        isLate=false;
        checkOut=new Date();
        checkIn=new Date();
        lateFees=0;
    }

    public void calculateLateFees(int days) {
        if (days > 0) {
            this.lateFees = days*LATE_FEE_PER_DAY;
            this.isLate = true;
        }
    }

    public boolean exists(String title, String author, String isbn) {
        if (title == null || author == null || isbn == null) {
            return false;
        }
        return this.title.equals(title.trim()) 
               && this.author.equals(author.trim()) 
               && this.isbn.equals(isbn.trim());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book Details :")
                .append("\nTitle :\t ").append(title)
                .append("\nAuthor :\t ").append(author)
                .append("\nISBN : \t").append(isbn);
        return stringBuilder.toString();
    }

}
