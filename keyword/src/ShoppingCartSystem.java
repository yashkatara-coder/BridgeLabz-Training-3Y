// File: ShoppingCartSystem.java


// Blueprint for a Product.
class Product {
    // static variable: discount is the same for all products.
    private static double discount = 0.0;

    // final variable: productID is unique and cannot be changed.
    private final String productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // static method: Updates the shared discount for all products.
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0.0 && newDiscount <= 100.0) {
            discount = newDiscount;
        } else {
            System.out.println("Invalid discount percentage. Must be between 0 and 100.");
        }
    }

    public double getDiscountedPrice() {
        return this.price - (this.price * discount / 100);
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Product Name: " + this.productName);
            System.out.println("Price: $" + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.printf("Price after Discount: $%.2f\n", getDiscountedPrice());
        }
    }
}

// Main class to run the program.
public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product.updateDiscount(10.0); // Set a 10% discount for all products

        Product product1 = new Product("P001", "Laptop", 1200.00, 5);
        Product product2 = new Product("P002", "Smartphone", 800.00, 10);

        System.out.println("--- Product 1 Details ---");
        product1.displayProductDetails();
        System.out.println("\n--- Product 2 Details ---");
        product2.displayProductDetails();
    }
}
