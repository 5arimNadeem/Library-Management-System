package com.jsp.lms.controller;

import com.jsp.lms.model.Book;
import com.jsp.lms.model.Library;

public class Controller {
    private final Library library;
    
    public Controller(Library library) {
        this.library = library;
    }
    
    public Controller() {
        this(new Library());
    }
    
    // Book management methods
    public boolean addBook(Book book) {
        try {
            return library.addBook(book);
        } catch (Exception e) {
            System.err.println("Error adding book: " + e.getMessage());
            return false;
        }
    }
    
    public Book getBook(String bookName) {
        try {
            return library.findBookByName(bookName);
        } catch (Exception e) {
            System.err.println("Error finding book: " + e.getMessage());
            return null;
        }
    }
    
    public boolean updateBook(Book existingBook, Book updatedBook) {
        try {
            return library.updateBook(existingBook, updatedBook);
        } catch (Exception e) {
            System.err.println("Error updating book: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removeBook(String bookName) {
        try {
            return library.removeBook(bookName);
        } catch (Exception e) {
            System.err.println("Error removing book: " + e.getMessage());
            return false;
        }
    }
    
    // Additional business methods
    public boolean borrowBook(String bookName) {
        try {
            return library.borrowBook(bookName);
        } catch (Exception e) {
            System.err.println("Error borrowing book: " + e.getMessage());
            return false;
        }
    }
    
    public boolean returnBook(String bookName) {
        try {
            return library.returnBook(bookName);
        } catch (Exception e) {
            System.err.println("Error returning book: " + e.getMessage());
            return false;
        }
    }
    
    public java.util.List<Book> searchBooksByAuthor(String authorName) {
        try {
            return library.findBooksByAuthor(authorName);
        } catch (Exception e) {
            System.err.println("Error searching books by author: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
    
    public java.util.List<Book> getAvailableBooks() {
        try {
            return library.getAvailableBooks();
        } catch (Exception e) {
            System.err.println("Error getting available books: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
    
    public java.util.List<Book> getAllBooks() {
        try {
            return library.getBooks();
        } catch (Exception e) {
            System.err.println("Error getting all books: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
    
    public int getTotalBooks() {
        return library.getTotalBooks();
    }
    
    public int getTotalBookCopies() {
        return library.getTotalBookCopies();
    }
    
    public Library getLibrary() {
        return library;
    }
    
    // Utility methods
    public boolean isBookAvailable(String bookName) {
        Book book = getBook(bookName);
        return book != null && book.isAvailable();
    }
    
    public void displayLibraryInfo() {
        System.out.println("=== Library Information ===");
        System.out.println(library);
        System.out.println("===========================");
    }
    
    public void displayAllBooks() {
        java.util.List<Book> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("=== All Books in Library ===");
            books.forEach(System.out::println);
            System.out.println("============================");
        }
    }
    
    public void displayAvailableBooks() {
        java.util.List<Book> books = getAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No books available for borrowing.");
        } else {
            System.out.println("=== Available Books ===");
            books.forEach(System.out::println);
            System.out.println("=======================");
        }
    }
}
