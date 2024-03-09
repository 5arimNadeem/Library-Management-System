# Library Management System (LMS)

## Overview
This is a console-based Library Management System (LMS) developed in Java. It allows librarians to perform various operations such as adding, removing, updating, and searching for books, while also managing information about the library such as its name, address, and pin code.

## MVC Architecture
The project follows the Model-View-Controller (MVC) architecture:
- **Model**: In Java, the Model represents the data and business logic of the application. It consists of Java classes that encapsulate data and define operations on that data. These classes often interact with a database or other data sources to fetch and manipulate data.
- **View**:The View is responsible for presenting the data to the user. In Java, the View typically consists of user interface components such as Swing or JavaFX elements. It displays the data retrieved from the Model and handles user interactions.

- **Controller**:The Controller acts as an intermediary between the Model and the View. It receives user input from the View, interacts with the Model to perform operations, and updates the View accordingly.

## Project Structure
- `com.jsp.lms.controller`: Contains classes for controlling library operations.
- `com.jsp.lms.model`: Contains classes representing entities like Book and Library.
- `com.jsp.lms.view`: Contains classes for user interface components.
- 
## Class Descriptions

### Book.java
The `Book` class represents a book entity within the Library Management System. It encapsulates information about a book, including its name, author, and price.

**Attributes:**
- `bookName`: A string representing the name of the book.
- `bookAuthor`: A string representing the author of the book.
- `bookPrice`: A double representing the price of the book.

**Access Modifier:** 
`private`: It ensures that the `bookName`, `bookAuthor`, and `bookPrice` attributes cannot be accessed or modified directly from outside the `Book` class.

**Getter and Setter Methods:**
- `getBookName()`: Returns the name of the book.
- `setBookName(String bookName)`: Sets the name of the book.
- `getBookAuthor()`: Returns the author of the book.
- `setBookAuthor(String bookAuthor)`: Sets the author of the book.
- `getBookPrice()`: Returns the price of the book.
- `setBookPrice(double bookPrice)`: Sets the price of the book.

**toString() Method:**
- Overrides the `toString()` method to provide a string representation of the `Book` object.
- Returns a string containing the book's name, author, and price.

### Library.java
The `Library` class represents a library entity within the Library Management System. It encapsulates information about a library, including its name, address, pin code, and the list of books available.

**Attributes:**
- `libraryName`: Represents the name of the library.
- `libraryAddress`: Represents the address of the library.
- `pincode`: Represents the pin code of the library.
- `books`: Represents a list of Book objects available in the library.

**Getter and Setter Methods:**
- `getLibraryName()`: Retrieves the name of the library.
- `setLibraryName(String libraryName)`: Sets the name of the library.
- `getLibraryAddress()`: Retrieves the address of the library.
- `setLibraryAddress(String libraryAddress)`: Sets the address of the library.
- `getPincode()`: Retrieves the pin code of the library.
- `setPincode(int pincode)`: Sets the pin code of the library.
- `getBooks()`: Retrieves the list of books available in the library.
- `setBooks(List<Book> books)`: Sets the list of books available in the library.

### Controller.java
The `Controller` class serves as a controller component within the Library Management System, responsible for handling various operations related to books and the library.

**Attributes:**
- `library`: Represents an instance of the library class, obtained from the View class.

**Methods:**
1. `addBook(Book book)`:
   - Adds a new book to the library.
   - Retrieves the list of books from the library.
   - If the list is null (indicating no books are present), initializes it with a new ArrayList.
   - Adds the new book to the list of books.
   - Sets the updated list of books back to the library.
  
2. `getBook(String bookName)`:
   - Retrieves a book from the library based on its name.
   - Retrieves the list of books from the library.
   - Iterates through the list of books to find a book with a matching name (ignoring case).
   - If a book with the specified name is found, it is returned. Otherwise, null is returned.
  
3. `update(Book bookExist, Book bookUpdate)`:
   - Updates the details of an existing book in the library.
   - Retrieves the list of books from the library.
   - Iterates through the list of books to find the book to be updated based on its name.
   - Removes the existing book from the list and adds the updated book.
   - Returns true if the update is successful, otherwise false.
  
4. `removeBook(String bookName)`:
   - Removes a book from the library based on its name.
   - Calls the getBook() method to retrieve the book with the specified name.
   - If the book exists in the library, it is removed from the list of books.
   - Returns true if the book is successfully removed, otherwise false.

The Controller class provides methods to interact with the library and perform operations such as adding, updating, and removing books. It acts as an intermediary between the view (user interface) and the model (library and books), executing business logic and handling data manipulation tasks.

### View.java

The `View` class is responsible for providing the user interface in the Library Management System.

**Attributes:**
- `library`: Represents an instance of the Library class, initialized statically.
- `book`: Represents an instance of the Book class (not used in this class).

**Methods:**
1. `getLibrary()`:
   - Static method that returns the instance of the library.
   - Allows other classes to access the library instance without instantiating the View class.

2. `setLibrary(Library library)`:
   - Static method used to set the library instance.
   - Allows external classes to set the library instance.

3. Static Initialization Block:
   - Prints a welcome message and prompts the user to input the library's name, address, and pincode.
   - Retrieves input from the user using a Scanner.
   - Sets the obtained values to the library instance.

4. `main(String[] args)`:
   - The main method of the class, responsible for user interaction.
   - Displays a menu of options for the user to perform various operations on the library books.
   - Accepts user input and calls appropriate methods from the Controller class based on the selected option.
   - The program runs in a loop until the user chooses to exit.

## How to Run the Project
## User Interaction Flow

1. **Enter Library Name:**
   - The user is prompted to enter the name of the library.
   ![Enter Library Name](https://github.com/pwrpriya/Library-Management-System/assets/161859666/fc723180-1cd9-4575-9d67-83f2655552d4)

2. **Enter Library Address, Pin Code, and Option Selection:**
   - Prompts for the address of the library, pin code, and the option selection.
   ![Address, Pin Code, and Option Selection](https://github.com/pwrpriya/Library-Management-System/assets/161859666/52c69ce5-93c4-45c3-a83b-e07d2a14df51)

3. **Select Desired Options:**
   - The user is prompted to select one of the following options:
   - Option 1: Add Book
     ![Add Book](https://github.com/pwrpriya/Library-Management-System/assets/161859666/91032ca7-aad0-49e0-b9ac-f3f3eec4e8c9)
   - Option 2: Remove Book
     ![Remove Book](https://github.com/pwrpriya/Library-Management-System/assets/161859666/926a7b07-04e4-4348-8c68-15ae1b1bb003)
   - Option 3: Update Book
     ![Update Book](https://github.com/pwrpriya/Library-Management-System/assets/161859666/f030401e-98d0-4d79-b2d1-1fa5920eaeb5)
   - Option 4: Get Book
     ![Get Book](https://github.com/pwrpriya/Library-Management-System/assets/161859666/0157ec4b-0611-4835-a332-711db8542b47)
   - Option 0: Exit
     ![Exit](https://github.com/pwrpriya/Library-Management-System/assets/161859666/3e3f1788-af16-477a-b055-d7f4990d78ab)

## Flow Chart of Library Management System Architecture

![Flow Chart 1](https://github.com/pwrpriya/Library-Management-System/assets/161859666/2c37859f-737e-41b4-9c63-5e9095ddeb70)

![Flow Chart 2](https://github.com/pwrpriya/Library-Management-System/assets/161859666/050e1130-f0e8-4380-a85d-fdb07d4fdd5b)


## Conclusion
This project demonstrates a simple implementation of a Library Management System in Java, following the MVC architecture. It provides librarians with basic functionalities to manage books and library information effectively.
