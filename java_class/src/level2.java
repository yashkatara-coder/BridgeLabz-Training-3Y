//********** LEVEL-2 PRACTICE PROGRAMS *************************

//--- 1. Program to Simulate Student Report ---
class Student {
    String name;
    String rollNumber;
    double[] marks;

    // Constructor
    public Student(String name, String rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate the average of marks
    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    // Method to calculate grade based on the average
    public String calculateGrade() {
        double average = calculateAverage();
        if (average >= 80) return "Grade A";
        if (average >= 60) return "Grade B";
        if (average >= 50) return "Grade C";
        if (average >= 40) return "Grade D";
        return "Grade F";
    }

    // Method to display the student's details and grade
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Roll Number: " + rollNumber);
        System.out.println("Student Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("  Mark " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Final Grade: " + calculateGrade());
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Student Reports ---");
        double[] marks1 = {80, 70, 75};
        Student student1 = new Student("Thamarai", "ECE001", marks1);

        double[] marks2 = {60, 65, 50};
        Student student2 = new Student("Kannan", "CSC002", marks2);

        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}

//--- 2. Program to Simulate an ATM ---
class BankAccount {
    // Attributes
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount to deposit must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount <= balance) {
            balance -= amount; // Corrected logic
            System.out.println("Withdrawn amount is: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current balance for " + accountHolder + ": " + balance);
    }

    public static void main(String[] args) {
        System.out.println("--- ATM Simulation ---");
        BankAccount account = new BankAccount("Lynda", "123456789", 700.00);

        account.displayBalance(); // Initial balance
        account.deposit(200.00);
        account.displayBalance();
        account.withdraw(100.00);
        account.displayBalance();
        account.withdraw(900.00); // Try to withdraw more than balance
        account.displayBalance();
    }
}

//--- 3. Program to Check Palindrome String ---
class PalindromeChecker {
    // Attribute
    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        // Remove spaces and punctuation, and convert to lower case
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // Reverse the string
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        // Compare the clean text with its reversed version
        return cleanText.equals(reversedText);
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("'" + text + "' is a palindrome.");
        } else {
            System.out.println("'" + text + "' is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Palindrome Checks ---");
        PalindromeChecker checker1 = new PalindromeChecker("A man, a plan, a canal: Panama");
        checker1.displayResult();

        PalindromeChecker checker2 = new PalindromeChecker("Hello World");
        checker2.displayResult();
    }
}

//--- 4. Program to Model a Movie Ticket Booking System ---
class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;

    // Constructor
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "N/A";
        this.price = 0.0;
        this.isBooked = false;
    }

    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        if (isBooked) {
            System.err.println("Sorry, this ticket has already been booked for seat " + this.seatNumber);
        } else {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket successfully booked!");
        }
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Movie: " + this.movieName);
        if (this.isBooked) {
            System.out.println("Status: Booked");
            System.out.println("Seat Number: " + this.seatNumber);
            System.out.println("Price: $" + this.price);
        } else {
            System.out.println("Status: Not Booked Yet");
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Dragon");
        ticket1.displayTicketDetails(); // Display before booking

        ticket1.bookTicket("A10", 120.0); // Book the ticket
        ticket1.displayTicketDetails(); // Display after booking

        ticket1.bookTicket("B11", 150.0); // Try to book again
    }
}


//--- 5. Program to Simulate a Shopping Cart Item ---
class CartItem {
    // Attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items to the cart
    public void addItem(int quantityToAdd) {
        if (quantityToAdd > 0) {
            this.quantity += quantityToAdd;
            System.out.println("Added " + quantityToAdd + " of " + this.itemName + " to the cart.");
        }
    }

    // Method to remove items from the cart
    public void removeItem(int quantityToRemove) {
        if (quantityToRemove <= 0) {
            System.out.println("Quantity to remove must be positive.");
        } else if (quantityToRemove > this.quantity) {
            System.out.println("Cannot remove " + quantityToRemove + " of " + this.itemName +
                    " as there are only " + this.quantity + " left.");
        } else {
            this.quantity -= quantityToRemove; // Corrected logic
            System.out.println("Removed " + quantityToRemove + " of " + this.itemName + " from the cart.");
        }
    }

    // Method to calculate the total cost
    public double getTotalCost() {
        return this.price * this.quantity;
    }

    // Method to display the item details
    public void displayItem() {
        System.out.println("Item: " + this.itemName + ", Price: $" + this.price +
                ", Current Quantity: " + this.quantity);
    }

    public static void main(String[] args) {
        System.out.println("--- Shopping Cart Simulation ---");
        CartItem item1 = new CartItem("Laptop", 999.99, 1);
        item1.displayItem(); // Display initial details

        item1.addItem(2); // Adding 2 more laptops
        item1.removeItem(1); // Removing 1 laptop

        item1.displayItem(); // Display final details
        System.out.printf("Final total cost: $%.2f\n", item1.getTotalCost());
    }
}