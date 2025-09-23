import java.util.*;

/* ===================================================
   1. Employee Management System
   =================================================== */

abstract class Employee {
    private final String employeeId;
    private String name;
    private double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        if (employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Invalid ID");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid Name");
        if (baseSalary < 0) throw new IllegalArgumentException("Negative Salary");
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public void setName(String name) { if (name != null && !name.isEmpty()) this.name = name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { if (baseSalary >= 0) this.baseSalary = baseSalary; }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.printf("ID:%s | Name:%s | BaseSalary:%.2f%n", employeeId, name, baseSalary);
    }
}

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    public FullTimeEmployee(String id, String name, double salary) {
        super(id, name, salary);
    }
    public double calculateSalary() { return getBaseSalary(); }
    public void assignDepartment(String dept) { department = dept; }
    public String getDepartmentDetails() { return department; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(String id, String name, double hourlyRate) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
    }
    public void setHoursWorked(int h) { hoursWorked = h; }
    public double calculateSalary() { return hoursWorked * hourlyRate; }
    public void assignDepartment(String dept) { department = dept; }
    public String getDepartmentDetails() { return department; }
}

/* ===================================================
   2. E-Commerce Platform
   =================================================== */
abstract class Product {
    private final String productId;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("Invalid ID");
        if (price < 0) throw new IllegalArgumentException("Negative Price");
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double p) { if (p >= 0) price = p; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.10; }
    public double calculateTax() { return getPrice() * 0.18; }
    public String getTaxDetails() { return "18% GST"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.20; }
    public double calculateTax() { return getPrice() * 0.05; }
    public String getTaxDetails() { return "5% VAT"; }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) { super(id, name, price); }
    public double calculateDiscount() { return getPrice() * 0.05; }
}

/* ===================================================
   3. Vehicle Rental System
   =================================================== */
abstract class Vehicle {
    private final String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String num, String type, double rate) {
        this.vehicleNumber = num;
        this.type = type;
        this.rentalRate = rate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String num, double rate) { super(num, "Car", rate); }
    public double calculateRentalCost(int days) { return days * 1000; }
    public double calculateInsurance() { return 2000; }
    public String getInsuranceDetails() { return "Car insurance fixed ₹2000"; }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate) { super(num, "Bike", rate); }
    public double calculateRentalCost(int days) { return days * 300; }
    public double calculateInsurance() { return 500; }
    public String getInsuranceDetails() { return "Bike insurance fixed ₹500"; }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String num, double rate) { super(num, "Truck", rate); }
    public double calculateRentalCost(int days) { return days * 2000; }
    public double calculateInsurance() { return 3000; }
    public String getInsuranceDetails() { return "Truck insurance fixed ₹3000"; }
}

/* ===================================================
   4. Banking System
   =================================================== */
abstract class BankAccount {
    private final String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String acc, String name, double bal) {
        accountNumber = acc; holderName = name; balance = bal;
    }

    public void deposit(double amt) { balance += amt; }
    public void withdraw(double amt) { if (amt <= balance) balance -= amt; }
    public double getBalance() { return balance; }
    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amt);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) { super(acc, name, bal); }
    public double calculateInterest() { return getBalance() * 0.04; }
    public void applyForLoan(double amt) { System.out.println("Savings loan applied: " + amt); }
    public boolean calculateLoanEligibility() { return getBalance() >= 10000; }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String acc, String name, double bal) { super(acc, name, bal); }
    public double calculateInterest() { return getBalance() * 0.02; }
    public void applyForLoan(double amt) { System.out.println("Current account loan applied: " + amt); }
    public boolean calculateLoanEligibility() { return getBalance() >= 50000; }
}

/* ===================================================
   5. Library Management System
   =================================================== */
abstract class LibraryItem {
    private final String itemId;
    private String title, author;

    public LibraryItem(String id, String title, String author) {
        itemId = id; this.title = title; this.author = author;
    }
    public abstract int getLoanDuration();
    public void getItemDetails() {
        System.out.println("ID:" + itemId + " | " + title + " by " + author);
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean reserved = false;
    public Book(String id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 14; }
    public void reserveItem() { reserved = true; }
    public boolean checkAvailability() { return !reserved; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 3; }
}

/* ===================================================
   6. Online Food Delivery System
   =================================================== */
abstract class FoodItem {
    private String name;
    private double price;
    public int qty;

    public FoodItem(String name, double price, int qty) {
        this.name = name; this.price = price; this.qty = qty;
    }

    public String getItemDetails() { return name + " x" + qty; }
    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() {
        int qty;
        return 100 * qty; }
    public double applyDiscount() { return 10; }
    public String getDiscountDetails() { return "₹10 off for veg items"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }
    public double calculateTotalPrice() { return 150 * qty + 50; }
    public double applyDiscount() { return 20; }
    public String getDiscountDetails() { return "₹20 off for non-veg items"; }
}

/* ===================================================
   7. Hospital Patient Management
   =================================================== */
abstract class Patient {
    private String patientId, name;
    private int age;

    public Patient(String id, String name, int age) { patientId = id; this.name = name; this.age = age; }
    public abstract double calculateBill();
    public void getPatientDetails() { System.out.println("Patient:" + name + " Age:" + age); }
}

interface MedicalRecord {
    void addRecord(String rec);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate = 1000;
    private int days;
    private List<String> records = new ArrayList<>();

    public InPatient(String id, String name, int age, int days) { super(id, name, age); this.days = days; }
    public double calculateBill() { return days * dailyRate; }
    public void addRecord(String rec) { records.add(rec); }
    public void viewRecords() { System.out.println(records); }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultFee = 500;
    private List<String> records = new ArrayList<>();

    public OutPatient(String id, String name, int age) { super(id, name, age); }
    public double calculateBill() { return consultFee; }
    public void addRecord(String rec) { records.add(rec); }
    public void viewRecords() { System.out.println(records); }
}

/* ===================================================
   8. Ride-Hailing Application
   =================================================== */
abstract class RideVehicle {
    private String vehicleId, driverName;
    private double ratePerKm;

    public RideVehicle(String id, String driver, double rate) {
        vehicleId = id; driverName = driver; ratePerKm = rate;
    }
    public abstract double calculateFare(double dist);
    public void getVehicleDetails() { System.out.println("Driver:" + driverName + " | Rate:" + ratePerKm); }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String loc);
}

class RideCar extends RideVehicle implements GPS {
    private String loc = "Unknown";
    public RideCar(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double dist) { return dist * 15; }
    public String getCurrentLocation() { return loc; }
    public void updateLocation(String loc) { this.loc = loc; }
}

class RideBike extends RideVehicle implements GPS {
    private String loc = "Unknown";
    public RideBike(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double dist) { return dist * 7; }
    public String getCurrentLocation() { return loc; }
    public void updateLocation(String loc) { this.loc = loc; }
}

class RideAuto extends RideVehicle implements GPS {
    private String loc = "Unknown";
    public RideAuto(String id, String driver, double rate) { super(id, driver, rate); }
    public double calculateFare(double dist) { return dist * 10; }
    public String getCurrentLocation() { return loc; }
    public void updateLocation(String loc) { this.loc = loc; }
}

/* ===================================================
   Main Runner
   =================================================== */
public class Main {
    public static void main(String[] args) {
        // 1. Employee
        Employee e1 = new FullTimeEmployee("E1", "Alice", 60000); ((Department)e1).assignDepartment("IT");
        Employee e2 = new PartTimeEmployee("E2", "Bob", 300); ((PartTimeEmployee)e2).setHoursWorked(100);
        System.out.println("Employee Salaries: " + e1.calculateSalary() + " , " + e2.calculateSalary());

        // 2. E-Commerce
        Product p1 = new Electronics("P1", "Laptop", 50000);
        System.out.println("Final Price Laptop: " + (p1.getPrice() + ((Taxable)p1).calculateTax() - p1.calculateDiscount()));

        // 3. Vehicle Rental
        Vehicle v1 = new Car("C1", 1000); System.out.println("Car Rent 3 days: " + v1.calculateRentalCost(3));

        // 4. Banking
        BankAccount acc = new SavingsAccount("A1", "Charlie", 20000);
        System.out.println("Savings Interest: " + acc.calculateInterest());

        // 5. Library
        LibraryItem book = new Book("B1", "Java Book", "Author A");
        book.getItemDetails();

        // 6. Food
        FoodItem food = new NonVegItem("Chicken Biryani", 200, 2);
        System.out.println("Food Price: " + food.calculateTotalPrice());

        // 7. Hospital
        Patient p = new InPatient("P1", "David", 30, 5);
        System.out.println("InPatient Bill: " + p.calculateBill());

        // 8. Ride
        RideVehicle ride = new RideBike("R1", "Eve", 7);
        System.out.println("Ride Fare: " + ride.calculateFare(10));
    }
}