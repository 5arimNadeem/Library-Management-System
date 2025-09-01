package com.jsp.lms.model;

import java.util.Objects;

public class Book {
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String isbn;
    private int quantity;
    
    // Default constructor
    public Book() {
        this.quantity = 1;
    }
    
    // Parameterized constructor
    public Book(String bookName, String bookAuthor, double bookPrice) {
        this();
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }
    
    // Full constructor
    public Book(String bookName, String bookAuthor, double bookPrice, String isbn, int quantity) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.isbn = isbn;
        this.quantity = quantity;
    }
    
    // Getters and Setters with validation
    public String getBookName() {
        return bookName;
    }
    
    public void setBookName(String bookName) {
        if (bookName != null && !bookName.trim().isEmpty()) {
            this.bookName = bookName.trim();
        } else {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public void setBookAuthor(String bookAuthor) {
        if (bookAuthor != null && !bookAuthor.trim().isEmpty()) {
            this.bookAuthor = bookAuthor.trim();
        } else {
            throw new IllegalArgumentException("Author name cannot be null or empty");
        }
    }
    
    public double getBookPrice() {
        return bookPrice;
    }
    
    public void setBookPrice(double bookPrice) {
        if (bookPrice >= 0) {
            this.bookPrice = bookPrice;
        } else {
            throw new IllegalArgumentException("Book price cannot be negative");
        }
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
    
    // Business methods
    public boolean isAvailable() {
        return quantity > 0;
    }
    
    public void incrementQuantity() {
        this.quantity++;
    }
    
    public boolean decrementQuantity() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }
    
    // Override methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(bookName, book.bookName) && 
               Objects.equals(bookAuthor, book.bookAuthor);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookAuthor);
    }
    
    @Override
    public String toString() {
        return String.format("Book [Name: %s, Author: %s, Price: $%.2f, ISBN: %s, Quantity: %d, Available: %s]",
                bookName, bookAuthor, bookPrice, isbn != null ? isbn : "N/A", 
                quantity, isAvailable() ? "Yes" : "No");
    }
}
