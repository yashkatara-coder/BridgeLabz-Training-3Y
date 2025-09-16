// File: LibraryManagementSingle.java


// NOTE: This is a poor design choice made to demonstrate single inheritance as requested.
// In a real-world scenario, a Book "has-a" Author (Composition) is a much better model.
class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("--- Book and Author Details ---");
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagementSingle {
    public static void main(String[] args) {
        Author authorBook = new Author("The Hobbit", 1937, "J.R.R. Tolkien", "An English writer and philologist.");
        authorBook.displayInfo();
    }
}