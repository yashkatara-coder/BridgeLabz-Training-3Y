import java.util.ArrayList;
import java.util.List;

class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}

class Order {
    String productName;
    int quantity;
    double price;

    public Order(String productName, int quantity, double price) throws InvalidOrderException {
        if (quantity <= 0 || price < 0) {
            // Throw exception for negative values [cite: 106]
            throw new InvalidOrderException("Order contains invalid data: quantity or price cannot be negative/zero.");
        }
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}

public class ECommerceTracker {
    private final List<Order> allOrders = new ArrayList<>(); // [cite: 102]
    private final double[] dailySales = new double[7]; // [cite: 104]

    public void addOrder(Order order, int dayOfWeek) {
        allOrders.add(order);
        if (dayOfWeek >= 0 && dayOfWeek < 7) {
            dailySales[dayOfWeek] += order.getTotalPrice();
        }
    }

    public void generateDailySummary() { // [cite: 105]
        System.out.println("\n--- Daily Sales Summary ---");
        for (int i = 0; i < dailySales.length; i++) {
            System.out.printf("Day %d Total Sales: $%.2f\n", (i + 1), dailySales[i]);
        }
        System.out.println("---------------------------");
    }

    public void filterProductsByCategory(String category) { // [cite: 103, 105]
        System.out.println("\n--- Orders in Category: " + category + " ---");
        double categoryTotal = 0;
        for (Order order : allOrders) {
            // Using String parsing to check category
            if (order.productName.toLowerCase().contains(category.toLowerCase())) {
                System.out.printf("Product: %s, Total Value: $%.2f\n", order.productName, order.getTotalPrice());
                categoryTotal += order.getTotalPrice();
            }
        }
        System.out.printf("Total Sales for Category '%s': $%.2f\n", category, categoryTotal);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        ECommerceTracker tracker = new ECommerceTracker();
        try {
            tracker.addOrder(new Order("Electronics - Laptop", 1, 1200.50), 0); // Day 1
            tracker.addOrder(new Order("Books - Java Programming", 10, 45.00), 0);
            tracker.addOrder(new Order("Electronics - Headphones", 2, 150.00), 1); // Day 2
            tracker.addOrder(new Order("Invalid Order", -1, 20.00), 2); // This will fail
        } catch (InvalidOrderException e) {
            System.err.println("Failed to add order: " + e.getMessage());
        }

        tracker.generateDailySummary();
        tracker.filterProductsByCategory("Electronics");
    }
}