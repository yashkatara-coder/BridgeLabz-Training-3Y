// File: EmployeeManagement.java


// Base class
class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass 1
class Manager extends Employee {
    int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Manager Details ---");
        super.displayDetails(); // Call superclass method
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass 2
class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Developer Details ---");
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass 3
class Intern extends Employee {
    String university;

    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Intern Details ---");
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

// Main class to test
public class EmployeeManagement {
    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 101, 90000, 10);
        Developer developer = new Developer("Bob", 202, 75000, "Java");
        Intern intern = new Intern("Charlie", 303, 30000, "Tech University");

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}