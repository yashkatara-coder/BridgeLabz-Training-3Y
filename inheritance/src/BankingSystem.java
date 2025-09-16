// File: BankingSystem.java


class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountType() {
        System.out.println("This is a generic Bank Account.");
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("\n-- Account Type: Savings Account --");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("\n-- Account Type: Checking Account --");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount mySavings = new SavingsAccount("SA-001", 5000, 2.5);
        CheckingAccount myChecking = new CheckingAccount("CA-002", 1500, 500);

        mySavings.displayAccountType();
        myChecking.displayAccountType();
    }
}