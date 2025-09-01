package com.jsp.lms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
    private String libraryName;
    private String libraryAddress;
    private int pincode;
    private List<Book> books;
    
    // Default constructor
    public Library() {
        this.books = new ArrayList<>();
    }
    
    // Parameterized constructor
    public Library(String libraryName, String libraryAddress, int pincode) {
        this();
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.pincode = pincode;
    }
    
    // Getters and Setters with validation
    public String getLibraryName() {
        return libraryName;
    }
    
    public void setLibraryName(String libraryName) {
        if (libraryName != null && !libraryName.trim().isEmpty()) {
            this.libraryName = libraryName.trim();
        } else {
            throw new IllegalArgumentException("Library name cannot be null or empty");
        }
    }
    
    public String getLibraryAddress() {
        return libraryAddress;
    }
    
    public void setLibraryAddress(String libraryAddress) {
        if (libraryAddress != null && !libraryAddress.trim().isEmpty()) {
            this.libraryAddress = libraryAddress.trim();
        } else {
            throw new IllegalArgumentException("Library address cannot be null or empty");
        }
    }
    
    public int getPincode() {
        return pincode;
    }
    
    public void setPincode(int pincode) {
        if (pincode > 0 && String.valueOf(pincode).length() == 6) {
            this.pincode = pincode;
        } else {
            throw new IllegalArgumentException("Pincode must be a 6-digit positive number");
        }
    }
    
    public List<Book> getBooks() {
        return new ArrayList<>(books); // Return defensive copy
    }
    
    public void setBooks(List<Book> books) {
        this.books = books != null ? new ArrayList<>(books) : new ArrayList<>();
    }
    
    // Business methods
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        
        // Check if book already exists
        Book existingBook = findBookByName(book.getBookName());
        if (existingBook != null) {
            existingBook.incrementQuantity();
            return true;
        }
        
        return books.add(book);
    }
    
    public boolean removeBook(String bookName) {
        if (bookName == null || bookName.trim().isEmpty()) {
            return false;
        }
        
        Book book = findBookByName(bookName);
        if (book != null) {
            return books.remove(book);
        }
        return false;
    }
    
    public Book findBookByName(String bookName) {
        if (bookName == null || bookName.trim().isEmpty()) {
            return null;
        }
        
        return books.stream()
                .filter(book -> book.getBookName().equalsIgnoreCase(bookName.trim()))
                .findFirst()
                .orElse(null);
    }
    
    public List<Book> findBooksByAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return books.stream()
                .filter(book -> book.getBookAuthor().equalsIgnoreCase(authorName.trim()))
                .collect(Collectors.toList());
    }
    
    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
    
    public int getTotalBooks() {
        return books.size();
    }
    
    public int getTotalBookCopies() {
        return books.stream()
                .mapToInt(Book::getQuantity)
                .sum();
    }
    
    public boolean updateBook(Book existingBook, Book updatedBook) {
        if (existingBook == null || updatedBook == null) {
            return false;
        }
        
        int index = books.indexOf(existingBook);
        if (index != -1) {
            books.set(index, updatedBook);
            return true;
        }
        return false;
    }
    
    public boolean borrowBook(String bookName) {
        Book book = findBookByName(bookName);
        if (book != null && book.isAvailable()) {
            return book.decrementQuantity();
        }
        return false;
    }
    
    public boolean returnBook(String bookName) {
        Book book = findBookByName(bookName);
        if (book != null) {
            book.incrementQuantity();
            return true;
        }
        return false;
    }
    
    // Override methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library library = (Library) obj;
        return pincode == library.pincode &&
               Objects.equals(libraryName, library.libraryName) &&
               Objects.equals(libraryAddress, library.libraryAddress);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(libraryName, libraryAddress, pincode);
    }
    
    @Override
    public String toString() {
        return String.format("Library [Name: %s, Address: %s, Pincode: %d, Total Books: %d, Total Copies: %d]",
                libraryName, libraryAddress, pincode, getTotalBooks(), getTotalBookCopies());
    }
}
