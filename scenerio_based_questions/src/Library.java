import java.util.ArrayList;
import java.util.List;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author + " | Status: " + (isAvailable ? "Available" : "Checked Out");
    }
}

public class Library {
    private final List<Book> books; // [cite: 93]

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByPartialTitle(String keyword) { // [cite: 94, 96]
        System.out.println("\nSearching for books with keyword: '" + keyword + "'");
        boolean found = false;
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(" - " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching your search.");
        }
    }

    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isAvailable) {
                    book.isAvailable = false; // [cite: 96]
                    System.out.println("\nSuccessfully checked out '" + title + "'.");
                } else {
                    // Throw custom exception [cite: 97]
                    throw new BookNotAvailableException("Sorry, '" + title + "' is already checked out.");
                }
                return;
            }
        }
        System.out.println("\nError: The book '" + title + "' was not found in the library.");
    }

    public void displayAllBooks() {
        System.out.println("\n--- Library Catalog ---");
        for(Book book : books) {
            System.out.println(book);
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        myLibrary.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        myLibrary.addBook(new Book("1984", "George Orwell"));
        myLibrary.displayAllBooks();

        myLibrary.searchByPartialTitle("Gatsby");

        try {
            myLibrary.checkoutBook("1984");
            myLibrary.checkoutBook("1984"); // Try to check out again
        } catch (BookNotAvailableException e) {
            System.err.println("Checkout Error: " + e.getMessage());
        }
        myLibrary.displayAllBooks();
    }
}