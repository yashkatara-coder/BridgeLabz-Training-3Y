//********** LEVEL-1 PRACTICE PROGRAMS *************************

//--- 1. Program to Display Employee Details ---
class Employee {
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor to initialize the attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        System.out.println("--- Employee 1 ---");
        Employee emp = new Employee("Rohan", 1, 500000); // Creating an object and calling the constructor
        emp.displayEmployee(); // Calling the display method
    }
}

//--- 2. Program to Compute Area of a Circle ---
class Circle {
    // Attribute
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method for calculating the area of a circle
    public void areaCircle() {
        System.out.printf("Area of circle: %.4f", (Math.PI * radius * radius));
    }

    // Method for calculating the circumference of a circle
    public void circumferenceCircle() {
        System.out.printf("\nCircumference of circle: %.4f", (2 * Math.PI * radius));
    }

    public static void main(String[] args) {
        System.out.println("--- Circle Details ---");
        Circle circle = new Circle(2.5); // Constructor invoked
        circle.areaCircle(); // Area method called
        circle.circumferenceCircle(); // Circumference method called
        System.out.println("\n"); // for new line
    }
}

//--- 3. Program to Handle Book Details ---
class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display the book details
    public void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Book Details ---");
        Book book1 = new Book("2 States", "Chetan Bhagat", 500);
        Book book2 = new Book("Wings Of Fire", "A. P. J. Abdul Kalam", 550);

        book1.displayBookDetails();
        book2.displayBookDetails();
    }
}


//--- 4. Program to Track Inventory of Items (Improved Version) ---
class Item {
    // Attributes for a single item
    String itemCode;
    String itemName;
    double price;

    // Constructor
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + price);
    }

    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        System.out.println("--- Inventory Details ---");
        // Create an array of Item objects
        Item[] inventory = new Item[3];
        inventory[0] = new Item("01AA", "Water Bottle", 500.0);
        inventory[1] = new Item("01BB", "Rice Bag", 700.0);
        inventory[2] = new Item("02AA", "Blackboard", 400.0);

        // Loop through and display each item
        for (Item item : inventory) {
            item.displayItemDetails();
            System.out.println("Total cost for quantity 5: " + item.calculateTotalCost(5));
            System.out.println("-------------------------");
        }
    }
}

//--- 5. Program to Handle Mobile Phone Details ---
class MobilePhone {
    // Attributes
    String brand;
    String model;
    double price;

    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    public void displayMobile() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Mobile Phone Details ---");
        MobilePhone mobile1 = new MobilePhone("VIVO", "VIVO V29", 15999);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS", "ONE PLUS Nord 4", 39999);
        MobilePhone mobile3 = new MobilePhone("APPLE", "iPhone 16 Pro", 79999);

        mobile1.displayMobile();
        mobile2.displayMobile();
        mobile3.displayMobile();
    }
}