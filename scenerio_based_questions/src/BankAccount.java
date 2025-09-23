public class BankAccount {
    private final String accountNumber;
    private double balance; // [cite: 45]

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    public void deposit(double amount) { // [cite: 46]
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f\n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


    public void withdraw(double amount) { // [cite: 46]
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient funds.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew: $%.2f\n", amount);
        }
    }


    public double checkBalance() { // [cite: 46]
        return this.balance;
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", 500.00);
        System.out.printf("Initial Balance: $%.2f\n", myAccount.checkBalance());

        myAccount.deposit(200.00);
        System.out.printf("Current Balance: $%.2f\n", myAccount.checkBalance());

        myAccount.withdraw(150.00);
        System.out.printf("Current Balance: $%.2f\n", myAccount.checkBalance());

        myAccount.withdraw(600.00); // Attempt to overdraft
        System.out.printf("Final Balance: $%.2f\n", myAccount.checkBalance());
    }
}