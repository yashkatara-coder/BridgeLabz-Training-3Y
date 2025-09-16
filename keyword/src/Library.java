// File: Library.java


// The Book class acts as a blueprint for book objects.
// It is not public, so it can be in the same file as the public Library class.
class Book {
    // static variable: Shared across all Book objects. There is only one libraryName.
    private static String libraryName;

    // final variable: Cannot be changed after the object is created.
    private final String isbn;

    // Instance variables: Each book object gets its own copy of these.
    private String title;
    private String author;

    // Constructor to create a new Book object.
    public Book(String title, String author, String isbn) {
        // 'this' keyword refers to the current object's variables.
        // It's used here to distinguish them from the constructor's parameters.
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // static method: Can be called on the class itself (Book.setLibraryName(...)).
    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance method: Must be called on an object (e.g., book1.displayBookDetails()).
    public void displayBookDetails() {
        // 'instanceof' checks if the object is of the Book type.
        if (this instanceof Book) {
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }
}

// The main public class. Its name MUST match the file name.
public class Library {
    public static void main(String[] args) {
        // Call the static method to set the shared library name.
        Book.setLibraryName("Egmore Library");
        Book.displayLibraryName();

        System.out.println("\n--- Book Details ---");
        // Create an instance (object) of the Book class.
        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

        // Call the instance method on the object.
        book1.displayBookDetails();
    }
}