

// Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass 1
class Car extends Vehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n-- Car Info --");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Subclass 2
class Truck extends Vehicle {
    double cargoCapacity;

    public Truck(int maxSpeed, String fuelType, double cargoCapacity) {
        super(maxSpeed, fuelType);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n-- Truck Info --");
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
    }
}

// Subclass 3
class Motorcycle extends Vehicle {
    boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n-- Motorcycle Info --");
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}

// Main class to test polymorphism
public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle[] transportFleet = new Vehicle[3];
        transportFleet[0] = new Car(180, "Gasoline", 5);
        transportFleet[1] = new Truck(120, "Diesel", 10.5);
        transportFleet[2] = new Motorcycle(200, "Gasoline", false);

        for (Vehicle v : transportFleet) {
            v.displayInfo();
        }
    }
}
