Library Management System
Overview
A console-based Library Management System (LMS) in Java 
allowing librarians to perform operations like adding, 
removing, updating, and searching for books, while also storing 
information about the library such as name, address, and pin 
code.
➢ How to Create the Project
Step 1: In Eclipse first to create a new Java project
Step 2: After that in src folder to create a three packages
- com.jsp.lms. controller
- com.jsp.lms.model
- com.jsp.lms. view
com:- It is a reverse domain name
jsp :- Java Server Pages
Step 3: Inside the model package create a two entities / classes
-Book.java
-Library.java
1.Book.java
The Book class represents a book entity within the Library 
Management System. It encapsulates information about a book, 
including its name, author, and price.
Attributes:
• bookName: A string representing the name of the book.
• bookAuthor: A string representing the author of the book.
• bookPrice: A double representing the price of the book.
Access Modifier: private
It ensures that the bookName, bookAuthor, bookPrice attribute 
cannot be accessed or modified directly from outside the Book
class.
Getter and Setter Methods:
getter and setter methods are commonly used to encapsulate the 
filed of class and provide controlled access to them
• getBookName(): Returns the name of the book.
• setBookName(String bookName): Sets the name of the 
book.
• getBookAuthor (): Returns the author of the book.
• setBookAuthor (String bookAuthor): Sets the author of 
the book.
• getBookPrice (): Returns the price of the book.
• setBookPrice (double bookPrice): Sets the price of the 
book.
toString () Method:
• Overrides the toString () method to provide a string 
representation of the Book object.
• Returns a string containing the book's name, author, and 
price.
2.Library Class
The library class represents a library entity within the 
Library Management System. It encapsulates information 
about a library, including its library Name, Address, and 
Pin Code.
Attributes:
• libraryName: Represents the name of the library.
• libraryAddress: Represents the address of the library.
• pincode: Represents the pin code of the library.
• books: Represents a list of Book objects available in the 
library.
Getter and Setter Methods:
• getLibraryName(): Retrieves the name of the library.
• setLibraryName(String libraryName): Sets the name of 
the library.
• getLibraryAddress (): Retrieves the address of the 
library.
• setLibraryAddress (String libraryAddress): Sets the 
address of the library.
• getPincode (): Retrieves the pin code of the library.
• setPincode (int pincode): Sets the pin code of the library.
• getBooks (): Retrieves the list of books available in the 
library.
• setBooks (List<Book> books): Sets the list of books 
available in the library.
Step 4: Inside the controller package create a class
- Controller.java
Controller.java
The Controller class serves as a controller component within 
the Library Management System, responsible for handling 
various operations related to books and the library.
private Library library = View.getLibrary();
Attributes:
• library: Represents an instance of the library class, 
obtained from the View class.
1.addBook (Book book):
• Adds a new book to the library.
• Retrieves the list of books from the library.
• If the list is null (indicating no books are present), 
initializes it with a new Array List.
• Adds the new book to the list of books.
• Sets the updated list of books back to the library.
public void addBook (Book book) {
List<Book> books = library. getBooks ();
if(books==null);
{
books = new ArrayList<> ();
}
books.add(book);
library.setBooks(books);
}
2.getBook (String bookName):
• Retrieves a book from the library based on its name.
• Retrieves the list of books from the library.
• Iterates through the list of books to find a book with a 
matching name (ignoring case).
• If a book with the specified name is found, it is returned. 
Otherwise, null is returned.
public Book getBook(String bookName) {
List<Book> books = library.getBooks();
if (books != null) {//list of book are exist
for (Book book : books) {
if
(book.getBookName().equalsIgnoreCase(bookName)) {
return book;
}
}
}
return null;
}
3.update (Book bookExist, Book bookUpdate):
• Updates the details of an existing book in the library.
• Retrieves the list of books from the library.
• Iterates through the list of books to find the book to be 
updated based on its name.
• Removes the existing book from the list and adds the 
updated book.
• Returns true if the update is successful, otherwise false.
public boolean update (Book bookExist,Book
bookUpdate) {
List<Book> books = library.getBooks();
for (Book book : books) {
if
(book.getBookName().equalsIgnoreCase(bookExist.getBoo
kName())) {
books.remove(bookExist);
books.add(bookUpdate);
return true;
}
}
return false;
}
4.removeBook(String bookName):
• Removes a book from the library based on its name.
• Calls the getBook() method to retrieve the book with the 
specified name.
• If the book exists in the library, it is removed from the list 
of books.
• Returns true if the book is successfully removed, 
otherwise false.
public boolean removeBook(String bookName) {
Book book = getBook(bookName);
if (book != null) {// Book Exist
List<Book> books = library.getBooks();
boolean remove = books.remove(book);
library.setBooks(books);
return true;
}
return false;
}
}
• The Controller class provides methods to interact with 
the library and perform operations such as adding, 
updating, and removing books.
• It acts as an intermediary between the view (user interface) 
and the model (library and books), executing business 
logic and handling data manipulation tasks.
Step 5: Inside the View package create a class
- View.java
View.java
The View class is responsible for providing the user interface 
which can take input from user and provide output in the 
Library Management System
Attributes:
• library: Represents an instance of the Library class, 
initialized statically.
• book: Represents an instance of the Book class (not used 
in this class).
public static Library library = new Library();
Book book = new Book();
• Methods:
1. getLibrary():
• Static method that returns the instance of the library.
• Allows other classes to access the library instance 
without instantiating the View class.
public static Library getLibrary() {
return library;
}
2. setLibrary(Library library):
• Static method used to set the library instance.
• Allows external classes to set the library instance, 
though it's not used in this code.
public static void setLibrary (Library library) {
View.library = library;
}
3. Static Initialization Block:
• Prints a welcome message and prompts the user to 
input the library's name, address, and pincode.
• Retrieves input from the user using a Scanner.
• Sets the obtained values to the library instance.
static {
inside this block write a code to collects information about the library 
from the user and sets it to the Library object.
}
4. main (String[] args):
• The main method of the class, responsible for user 
interaction.
• Displays a menu of options for the user to perform 
various operations on the library books.
• Accepts user input and calls appropriate methods 
from the Controller class based on the selected 
option.
• The program runs in a loop until the user chooses to 
exit.
public static void main (String[] args) {
The user is prompted to select an option to perform various operations.
do {
Based on the user's input, different cases are handled in do block:
Option 0: Exit the program.
Option 1: Add a new book to the library
Option 2: Remove a book from the library
Option 3: Update details of an existing book.
Option 4: Get details of a specific book.
default:
break;
}
} while (true);
}
}
➢ How to Run the Project
1. The user is prompted to enter the name of the library.
2. Prompts for the address of the library, pin code, and the 
option selection.
3. They prompted to select the desire options
Option 1: Add Book
Option 2: Remove Book
Option 3: Update Book
Option 4: GetBook
Option 0: Exit
➢ Flow Chart of the Library Management System's 
Architecture :
 

