import java.util.InputMismatchException;
import java.util.Scanner;

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class SimpleBankingApp {
    private static double balance = 0.0;

    public static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Successfully deposited $%.2f. New balance: $%.2f\n", amount, balance);
    }

    public static void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            // Throw exception if withdrawal amount exceeds balance [cite: 67]
            throw new InsufficientFundsException("Withdrawal failed. You only have $" + balance);
        }
        balance -= amount;
        System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f\n", amount, balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter initial balance: "); // [cite: 65]
                balance = scanner.nextDouble();
                if (balance < 0) {
                    System.out.println("Initial balance cannot be negative.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) { // [cite: 68]
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        while (true) {
            System.out.println("\nChoose an option: 1. Deposit 2. Withdraw 3. Check Balance 4. Exit");
            try {
                int choice = scanner.nextInt();
                double amount;
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        amount = scanner.nextDouble();
                        deposit(amount); // [cite: 66]
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        amount = scanner.nextDouble();
                        withdraw(amount);
                        break;
                    case 3:
                        System.out.printf("Current balance is: $%.2f\n", balance);
                        break;
                    case 4:
                        System.out.println("Exiting. Thank you!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear buffer
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}