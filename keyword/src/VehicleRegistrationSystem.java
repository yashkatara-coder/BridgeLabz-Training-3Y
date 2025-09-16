// File: VehicleRegistrationSystem.java


// Blueprint for a Vehicle.
class Vehicle {
    // static variable shared by all vehicles.
    private static double registrationFee = 100.0;

    // final variable cannot be changed.
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0.0) {
            registrationFee = newFee;
        } else {
            System.out.println("Invalid registration fee. Please enter a non-negative value.");
        }
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
}

// Main class to run the program.
public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(150.0);

        Vehicle vehicle1 = new Vehicle("Honest Raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Prince Danish", "SUV", "XYZ789");

        System.out.println("--- Vehicle 1 Details ---");
        vehicle1.displayRegistrationDetails();
        System.out.println("\n--- Vehicle 2 Details ---");
        vehicle2.displayRegistrationDetails();
    }
}