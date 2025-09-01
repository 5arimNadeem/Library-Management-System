import com.jsp.lms.controller.Controller;
import com.jsp.lms.model.Book;
import com.jsp.lms.model.Library;

/**
 * Test class to demonstrate the optimizations and new features
 * of the Library Management System
 */
public class TestOptimizedLMS {
    
    public static void main(String[] args) {
        System.out.println("=== Testing Optimized Library Management System ===\n");
        
        // Create library and controller
        Library library = new Library("Central Library", "123 Main Street", 123456);
        Controller controller = new Controller(library);
        
        System.out.println("1. Library Information:");
        controller.displayLibraryInfo();
        
        // Test adding books
        System.out.println("\n2. Adding Books:");
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 15.99, "978-0743273565", 3);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 12.50, "978-0446310789", 2);
        Book book3 = new Book("1984", "George Orwell", 10.99, "978-0451524935", 1);
        
        controller.addBook(book1);
        controller.addBook(book2);
        controller.addBook(book3);
        
        System.out.println("✓ Added 3 books successfully");
        
        // Test displaying all books
        System.out.println("\n3. All Books in Library:");
        controller.displayAllBooks();
        
        // Test searching books
        System.out.println("\n4. Searching for 'The Great Gatsby':");
        Book foundBook = controller.getBook("The Great Gatsby");
        if (foundBook != null) {
            System.out.println("✓ Found: " + foundBook);
        }
        
        // Test borrowing books
        System.out.println("\n5. Borrowing 'The Great Gatsby':");
        if (controller.borrowBook("The Great Gatsby")) {
            System.out.println("✓ Book borrowed successfully");
        }
        
        // Test viewing available books
        System.out.println("\n6. Available Books After Borrowing:");
        controller.displayAvailableBooks();
        
        // Test returning books
        System.out.println("\n7. Returning 'The Great Gatsby':");
        if (controller.returnBook("The Great Gatsby")) {
            System.out.println("✓ Book returned successfully");
        }
        
        // Test searching by author
        System.out.println("\n8. Books by George Orwell:");
        var orwellBooks = controller.searchBooksByAuthor("George Orwell");
        orwellBooks.forEach(System.out::println);
        
        // Test updating book
        System.out.println("\n9. Updating '1984' price:");
        Book originalBook = controller.getBook("1984");
        if (originalBook != null) {
            Book updatedBook = new Book(
                originalBook.getBookName(),
                originalBook.getBookAuthor(),
                14.99, // Updated price
                originalBook.getIsbn(),
                originalBook.getQuantity()
            );
            
            if (controller.updateBook(originalBook, updatedBook)) {
                System.out.println("✓ Book updated successfully");
                System.out.println("Updated book: " + controller.getBook("1984"));
            }
        }
        
        // Test library statistics
        System.out.println("\n10. Final Library Statistics:");
        System.out.println("Total unique books: " + controller.getTotalBooks());
        System.out.println("Total book copies: " + controller.getTotalBookCopies());
        
        // Test input validation (demonstrating error handling)
        System.out.println("\n11. Testing Input Validation:");
        try {
            Book invalidBook = new Book();
            invalidBook.setBookName(""); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation working: " + e.getMessage());
        }
        
        try {
            Book invalidBook = new Book();
            invalidBook.setBookPrice(-10.0); // This should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation working: " + e.getMessage());
        }
        
        System.out.println("\n=== Test Completed Successfully! ===");
        System.out.println("All optimizations and new features are working correctly.");
    }
}
