import java.util.*;
//Problem 1: Library and Books (Aggregation)


class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showDetails() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.showDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b2 = new Book("1984", "George Orwell");

        Library lib1 = new Library("City Library");
        lib1.addBook(b1);
        lib1.addBook(b2);

        Library lib2 = new Library("College Library");
        lib2.addBook(b1); // Same book can exist in another library

        lib1.showBooks();
        lib2.showBooks();
    }
}

//Problem 2: Bank and Account Holders (Association)
class Customer {
    private String name;
    private double balance;

    public Customer(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void viewBalance() {
        System.out.println(name + " balance: " + balance);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, double initialDeposit) {
        customers.add(customer);
        customer.deposit(initialDeposit);
        System.out.println("Account opened for " + customer + " at " + bankName);
    }

    public void showCustomers() {
        System.out.println("Bank: " + bankName + " has customers: " + customers.size());
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.openAccount(c1, 5000);
        bank.openAccount(c2, 3000);

        c1.viewBalance();
        c2.viewBalance();
    }
}

//Problem 3: Company and Departments (Composition)


class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void show() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) e.show();
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void showCompany() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) d.show();
    }
}

public class Main {
    public static void main(String[] args) {
        Company c = new Company("Google");
        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("John"));
        d1.addEmployee(new Employee("Mary"));

        Department d2 = new Department("HR");
        d2.addEmployee(new Employee("Sarah"));

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showCompany();
    }
}

//Problem 1: School and Students with Courses
class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Course: " + courseName + " has students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }

    @Override
    public String toString() {
        return courseName;
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course c) {
        courses.add(c);
        c.enrollStudent(this);
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c);
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showStudents() {
        System.out.println("School: " + name + " has students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Sunrise Public School");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        school.showStudents();
        c1.showStudents();
        c2.showStudents();
    }
}

//Problem 2: University with Faculties and Departments

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void show() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void show() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department d : departments) d.show();
        System.out.println("Faculties:");
        for (Faculty f : faculties) f.show();
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Oxford");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Physics");

        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");

        uni.addDepartment(d1);
        uni.addDepartment(d2);
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.show();
    }
}

//Problem 3: Hospital, Doctors, and Patients

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " is consulting Patient " + p.getName());
    }
}

class Hospital {
    private String hospitalName;

    public Hospital(String name) {
        this.hospitalName = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital h = new Hospital("Apollo Hospital");

        Doctor d1 = new Doctor("Dr. Adams");
        Doctor d2 = new Doctor("Dr. Green");

        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Emma");

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
    }
}

//Problem 4: E-commerce Platform
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void show() {
        System.out.println("Product: " + name + " ($" + price + ")");
    }
}

class Order {
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showOrder() {
        System.out.println("Order contains:");
        double total = 0;
        for (Product p : products) {
            p.show();
            total += p.getPrice();
        }
        System.out.println("Total = $" + total);
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder(Product... items) {
        Order order = new Order();
        for (Product p : items) {
            order.addProduct(p);
        }
        System.out.println(name + " placed an order.");
        return order;
    }
}

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alice");

        Product p1 = new Product("Laptop", 800);
        Product p2 = new Product("Mouse", 20);

        Order order1 = c1.placeOrder(p1, p2);
        order1.showOrder();
    }
}

//Problem 5: University Management System

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor p) {
        this.professor = p;
        System.out.println("Professor " + p.getName() + " assigned to " + courseName);
    }

    public void enrollStudent(Student s) {
        students.add(s);
        System.out.println(s.getName() + " enrolled in " + courseName);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getName());
        }
        System.out.println("Enrolled students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course c) {
        c.enrollStudent(this);
    }
}

class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Professor p1 = new Professor("Dr. Smith");

        Course c1 = new Course("Data Structures");
        c1.assignProfessor(p1);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);

        c1.showCourseDetails();
    }
}