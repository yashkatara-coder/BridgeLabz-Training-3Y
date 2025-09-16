// File: BankAccountSystem.java
 // Or remove this line if you are not using packages

import java.util.Scanner;

// This class is the blueprint for a bank account.
// It is NOT public, so it can live in the same file as the main public class.
class BankAccount {
    // Static variables are shared across ALL BankAccount objects
    private static String bankName = "State bank of India";
    private static int totalAccounts = 0;

    // final means the account number cannot be changed after it's created
    private final String accountNumber;

    // Instance variables are unique to each BankAccount object
    private String accountHolderName;
    private double balance;

    // Constructor: Used to create a new BankAccount object
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        // 'this' is used to distinguish between the instance variable (this.accountHolderName)
        // and the parameter (accountHolderName)
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++; // Increment the static counter for every new account
    }

    // Static method: Belongs to the class, not a specific object
    public static void displayTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }

    // Instance method: Belongs to a specific object (account1, account2, etc.)
    public void displayAccountDetails() {
        // 'instanceof' checks if 'this' object is actually of the BankAccount type.
        // This is a bit redundant here but demonstrates the keyword's usage.
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName); // Accessing static variable
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Balance: $" + this.balance);
        } else {
            System.out.println("Invalid account instance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount; // Corrected logic to update balance
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.err.println("Insufficient balance or invalid amount.");
        }
    }
}

// This is the main public class. Its name MUST match the file name.
public class BankAccountSystem {
    public static void main(String[] args) {
        // Create two bank account objects (instances)
        BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000.00);
        BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500.00);

        // Display initial details
        System.out.println("--- Account 1 Details ---");
        account1.displayAccountDetails();
        System.out.println("\n--- Account 2 Details ---");
        account2.displayAccountDetails();

        // Call the static method on the class itself
        System.out.println("\n--- Bank Stats ---");
        BankAccount.displayTotalAccounts();

        // Perform transactions
        System.out.println("\n--- Transactions on Account 1 ---");
        account1.deposit(200);
        account1.withdraw(150);
        account1.displayAccountDetails();
    }
}