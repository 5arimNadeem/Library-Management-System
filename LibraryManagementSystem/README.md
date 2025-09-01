# Library Management System - Optimized Version

## Overview
This is an optimized version of a Library Management System built in Java using the MVC (Model-View-Controller) architecture pattern. The system has been completely refactored to improve code quality, performance, user experience, and maintainability.

## 🚀 Key Optimizations Made

### 1. **Code Quality Improvements**
- **Proper Encapsulation**: Added validation in all setter methods
- **Input Validation**: Comprehensive input validation with user-friendly error messages
- **Exception Handling**: Proper try-catch blocks with meaningful error messages
- **Consistent Naming**: Improved variable and method naming conventions
- **Code Documentation**: Added meaningful comments and documentation

### 2. **Architecture Enhancements**
- **Loose Coupling**: Removed static dependencies between components
- **Single Responsibility**: Each class now has a clear, single responsibility
- **Dependency Injection**: Controller now accepts Library instance through constructor
- **Defensive Programming**: Added null checks and validation throughout

### 3. **Performance Optimizations**
- **Efficient Data Structures**: Used Stream API for searching and filtering
- **Reduced Object Creation**: Minimized unnecessary object instantiation
- **Optimized Searching**: Implemented efficient book search algorithms
- **Memory Management**: Proper resource cleanup and management

### 4. **User Experience Improvements**
- **Beautiful UI**: Added ASCII art borders and clear menu structure
- **Input Validation**: Real-time validation with helpful error messages
- **Enhanced Menu**: More intuitive menu with additional features
- **Better Feedback**: Clear success/error messages with visual indicators

### 5. **New Features Added**
- **Book Borrowing/Returning**: Complete borrowing system with quantity tracking
- **Author Search**: Search books by author name
- **Library Statistics**: View comprehensive library information
- **ISBN Support**: Optional ISBN field for books
- **Quantity Management**: Track multiple copies of the same book
- **Available Books View**: See only books available for borrowing

## 📁 Project Structure

```
src/
├── com/jsp/lms/
│   ├── model/
│   │   ├── Book.java          # Enhanced book model with validation
│   │   └── Library.java       # Optimized library with business logic
│   ├── controller/
│   │   └── Controller.java    # Streamlined controller with error handling
│   └── view/
│       └── View.java          # Completely redesigned user interface
```

## 🛠️ How to Run

### Prerequisites
- Java 8 or higher
- Command line terminal

### Compilation
```bash
javac -d bin src/com/jsp/lms/model/*.java src/com/jsp/lms/controller/*.java src/com/jsp/lms/view/*.java
```

### Execution
```bash
java -cp bin com.jsp.lms.view.View
```

## 🎯 Features

### Core Features
1. **Add Book** - Add new books with validation
2. **Remove Book** - Remove books from library
3. **Update Book** - Update book details
4. **Search Book** - Find books by name
5. **Borrow Book** - Borrow books (decreases quantity)
6. **Return Book** - Return books (increases quantity)
7. **View All Books** - Display all books in library
8. **View Available Books** - Show only available books
9. **Search by Author** - Find books by author
10. **Library Statistics** - View library information

### Enhanced Features
- **Input Validation**: All inputs are validated with helpful error messages
- **Quantity Management**: Track multiple copies of books
- **ISBN Support**: Optional ISBN field for better book identification
- **Beautiful UI**: ASCII art borders and clear menu structure
- **Error Handling**: Comprehensive error handling with user-friendly messages

## 🔧 Technical Improvements

### Model Layer (`Book.java`)
- Added constructors (default, parameterized, full)
- Input validation in all setter methods
- Business methods (`isAvailable()`, `incrementQuantity()`, `decrementQuantity()`)
- Proper `equals()`, `hashCode()`, and `toString()` methods
- Added ISBN and quantity fields

### Model Layer (`Library.java`)
- Proper initialization with constructors
- Business logic methods for book management
- Efficient searching using Stream API
- Defensive copying for data integrity
- Comprehensive validation

### Controller Layer (`Controller.java`)
- Dependency injection through constructor
- Exception handling with meaningful error messages
- Delegation of business logic to model layer
- Utility methods for display and statistics
- Clean separation of concerns

### View Layer (`View.java`)
- Complete UI redesign with ASCII art
- Comprehensive input validation
- User-friendly error messages
- Enhanced menu structure
- Better user experience

## 📊 Performance Metrics

### Before Optimization
- ❌ Inefficient linear search (O(n))
- ❌ No input validation
- ❌ Poor error handling
- ❌ Static dependencies
- ❌ Basic UI

### After Optimization
- ✅ Efficient Stream-based search
- ✅ Comprehensive input validation
- ✅ Robust error handling
- ✅ Loose coupling with dependency injection
- ✅ Beautiful, user-friendly UI
- ✅ Additional features (borrowing, statistics, etc.)

## 🎨 User Interface

The new interface features:
- ASCII art borders for visual appeal
- Clear menu structure with numbered options
- Real-time input validation
- Success/error indicators (✓/✗)
- Comprehensive help messages
- Professional-looking output formatting

## 🔒 Data Integrity

- **Validation**: All inputs are validated before processing
- **Defensive Copying**: Collections are protected from external modification
- **Null Safety**: Comprehensive null checks throughout the codebase
- **Exception Handling**: Graceful error handling with user feedback

## 🚀 Future Enhancements

Potential improvements for future versions:
- Database integration for persistent storage
- User authentication and authorization
- Book categories and genres
- Due date tracking for borrowed books
- Fine calculation for late returns
- Export/import functionality
- Web-based interface
- REST API for external integrations

## 📝 License

This project is open source and available under the MIT License.

---

**Note**: This optimized version maintains backward compatibility while significantly improving code quality, performance, and user experience.
