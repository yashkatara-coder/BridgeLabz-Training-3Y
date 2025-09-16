// File: EmployeeManagementSystem.java


// Blueprint for an Employee object.
class Employee {
    // static variables are shared by all employees.
    private static String companyName;
    private static int totalEmployees = 0;

    // final variable: cannot be changed once assigned.
    private final int id;

    // Instance variables
    private String name;
    private String designation;

    public Employee(String name, int id, String designation) {
        // 'this' refers to the instance variables of the object being created.
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increment the shared counter.
    }

    // static method to set the shared company name.
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // static method to display the shared employee count.
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Instance method to display details of a specific employee.
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + this.id);
            System.out.println("Name: " + this.name);
            System.out.println("Designation: " + this.designation);
        }
    }
}

// Main class to run the program.
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee.setCompanyName("Tech Solutions Inc.");

        System.out.println("--- Creating Employees ---");
        Employee emp1 = new Employee("Thamarai", 101, "Software Engineer");
        Employee emp2 = new Employee("Rohan", 102, "Project Manager");

        Employee.displayTotalEmployees();

        System.out.println("\n--- Employee 1 Details ---");
        emp1.displayEmployeeDetails();
        System.out.println("\n--- Employee 2 Details ---");
        emp2.displayEmployeeDetails();
    }
}
