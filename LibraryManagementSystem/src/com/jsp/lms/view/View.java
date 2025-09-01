package com.jsp.lms.view;

import java.util.List;
import java.util.Scanner;

import com.jsp.lms.controller.Controller;
import com.jsp.lms.model.Book;
import com.jsp.lms.model.Library;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private final Controller controller;
    private final Library library;
    
    public View() {
        this.library = new Library();
        this.controller = new Controller(library);
    }
    
    public static Library getLibrary() {
        return new Library();
    }
    
    public void start() {
        initializeLibrary();
        showMainMenu();
    }
    
    private void initializeLibrary() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                WELCOME TO LIBRARY MANAGEMENT SYSTEM         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        System.out.print("Enter library name: ");
        String libraryName = getValidStringInput("Library name cannot be empty");
        library.setLibraryName(libraryName);
        
        System.out.print("Enter library address: ");
        String libraryAddress = getValidStringInput("Library address cannot be empty");
        library.setLibraryAddress(libraryAddress);
        
        System.out.print("Enter pincode (6 digits): ");
        int pincode = getValidPincode();
        library.setPincode(pincode);
        
        System.out.println("\n✓ Library initialized successfully!");
        System.out.println(library);
    }
    
    private void showMainMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                        MAIN MENU                             ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║ 1. Add Book                   2. Remove Book                ║");
            System.out.println("║ 3. Update Book                4. Search Book                ║");
            System.out.println("║ 5. Borrow Book                6. Return Book                ║");
            System.out.println("║ 7. View All Books             8. View Available Books       ║");
            System.out.println("║ 9. Search by Author           10. Library Statistics        ║");
            System.out.println("║ 0. Exit                                                      ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            
            System.out.print("Enter your choice: ");
            int choice = getValidIntegerInput(0, 10);
            
            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    viewAllBooks();
                    break;
                case 8:
                    viewAvailableBooks();
                    break;
                case 9:
                    searchByAuthor();
                    break;
                case 10:
                    showLibraryStatistics();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void addBook() {
        System.out.println("\n=== ADD NEW BOOK ===");
        
        System.out.print("Enter book name: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        System.out.print("Enter author name: ");
        String authorName = getValidStringInput("Author name cannot be empty");
        
        System.out.print("Enter book price: $");
        double price = getValidDoubleInput(0.0, Double.MAX_VALUE);
        
        System.out.print("Enter ISBN (optional, press Enter to skip): ");
        String isbn = scanner.nextLine().trim();
        if (isbn.isEmpty()) {
            isbn = null;
        }
        
        System.out.print("Enter quantity (default: 1): ");
        int quantity = getValidIntegerInput(1, Integer.MAX_VALUE);
        
        Book book = new Book(bookName, authorName, price, isbn, quantity);
        
        if (controller.addBook(book)) {
            System.out.println("✓ Book added successfully!");
        } else {
            System.out.println("✗ Failed to add book. Please try again.");
        }
    }
    
    private void removeBook() {
        System.out.println("\n=== REMOVE BOOK ===");
        
        System.out.print("Enter book name to remove: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        if (controller.removeBook(bookName)) {
            System.out.println("✓ Book removed successfully!");
        } else {
            System.out.println("✗ Book not found or could not be removed.");
        }
    }
    
    private void updateBook() {
        System.out.println("\n=== UPDATE BOOK ===");
        
        System.out.print("Enter book name to update: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        Book existingBook = controller.getBook(bookName);
        if (existingBook == null) {
            System.out.println("✗ Book not found.");
            return;
        }
        
        System.out.println("Current book details:");
        System.out.println(existingBook);
        
        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Book name");
        System.out.println("2. Author name");
        System.out.println("3. Book price");
        System.out.println("4. ISBN");
        System.out.println("5. Quantity");
        System.out.println("0. Cancel");
        
        System.out.print("Enter your choice: ");
        int choice = getValidIntegerInput(0, 5);
        
        if (choice == 0) {
            System.out.println("Update cancelled.");
            return;
        }
        
        Book updatedBook = new Book(
            existingBook.getBookName(),
            existingBook.getBookAuthor(),
            existingBook.getBookPrice(),
            existingBook.getIsbn(),
            existingBook.getQuantity()
        );
        
        switch (choice) {
            case 1:
                System.out.print("Enter new book name: ");
                updatedBook.setBookName(getValidStringInput("Book name cannot be empty"));
                break;
            case 2:
                System.out.print("Enter new author name: ");
                updatedBook.setBookAuthor(getValidStringInput("Author name cannot be empty"));
                break;
            case 3:
                System.out.print("Enter new book price: $");
                updatedBook.setBookPrice(getValidDoubleInput(0.0, Double.MAX_VALUE));
                break;
            case 4:
                System.out.print("Enter new ISBN: ");
                updatedBook.setIsbn(scanner.nextLine().trim());
                break;
            case 5:
                System.out.print("Enter new quantity: ");
                updatedBook.setQuantity(getValidIntegerInput(0, Integer.MAX_VALUE));
                break;
        }
        
        if (controller.updateBook(existingBook, updatedBook)) {
            System.out.println("✓ Book updated successfully!");
        } else {
            System.out.println("✗ Failed to update book.");
        }
    }
    
    private void searchBook() {
        System.out.println("\n=== SEARCH BOOK ===");
        
        System.out.print("Enter book name to search: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        Book book = controller.getBook(bookName);
        if (book != null) {
            System.out.println("✓ Book found!");
            System.out.println(book);
        } else {
            System.out.println("✗ Book not found.");
        }
    }
    
    private void borrowBook() {
        System.out.println("\n=== BORROW BOOK ===");
        
        System.out.print("Enter book name to borrow: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        if (controller.borrowBook(bookName)) {
            System.out.println("✓ Book borrowed successfully!");
        } else {
            System.out.println("✗ Book not available for borrowing.");
        }
    }
    
    private void returnBook() {
        System.out.println("\n=== RETURN BOOK ===");
        
        System.out.print("Enter book name to return: ");
        String bookName = getValidStringInput("Book name cannot be empty");
        
        if (controller.returnBook(bookName)) {
            System.out.println("✓ Book returned successfully!");
        } else {
            System.out.println("✗ Book not found in library.");
        }
    }
    
    private void viewAllBooks() {
        System.out.println("\n=== ALL BOOKS IN LIBRARY ===");
        controller.displayAllBooks();
    }
    
    private void viewAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        controller.displayAvailableBooks();
    }
    
    private void searchByAuthor() {
        System.out.println("\n=== SEARCH BY AUTHOR ===");
        
        System.out.print("Enter author name: ");
        String authorName = getValidStringInput("Author name cannot be empty");
        
        List<Book> books = controller.searchBooksByAuthor(authorName);
        if (books.isEmpty()) {
            System.out.println("No books found by this author.");
        } else {
            System.out.println("Books by " + authorName + ":");
            books.forEach(System.out::println);
        }
    }
    
    private void showLibraryStatistics() {
        System.out.println("\n=== LIBRARY STATISTICS ===");
        controller.displayLibraryInfo();
        System.out.println("Total unique books: " + controller.getTotalBooks());
        System.out.println("Total book copies: " + controller.getTotalBookCopies());
    }
    
    private void exit() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    THANK YOU FOR USING LMS!                  ║");
        System.out.println("║                         GOODBYE!                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        scanner.close();
        System.exit(0);
    }
    
    // Input validation methods
    private String getValidStringInput(String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("✗ " + errorMessage);
            System.out.print("Please try again: ");
        }
    }
    
    private int getValidIntegerInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("✗ Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("✗ Please enter a valid number");
            }
            System.out.print("Please try again: ");
        }
    }
    
    private double getValidDoubleInput(double min, double max) {
        while (true) {
            try {
                double input = Double.parseDouble(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("✗ Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("✗ Please enter a valid number");
            }
            System.out.print("Please try again: ");
        }
    }
    
    private int getValidPincode() {
        while (true) {
            try {
                int pincode = Integer.parseInt(scanner.nextLine().trim());
                if (pincode > 0 && String.valueOf(pincode).length() == 6) {
                    return pincode;
                }
                System.out.println("✗ Pincode must be a 6-digit positive number");
            } catch (NumberFormatException e) {
                System.out.println("✗ Please enter a valid 6-digit pincode");
            }
            System.out.print("Please try again: ");
        }
    }
    
    public static void main(String[] args) {
        View view = new View();
        view.start();
    }
}
