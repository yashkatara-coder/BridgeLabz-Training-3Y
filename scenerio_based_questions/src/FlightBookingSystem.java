import java.util.ArrayList;
import java.util.List;

class Flight {
    String flightNumber;
    String destination;
    int availableSeats;

    public Flight(String flightNumber, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
}

class Booking {
    String passengerName;
    Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void displayDetails() {
        System.out.println("Booking Confirmation: " + passengerName + " on flight " + flight.flightNumber + " to " + flight.destination);
    }
}

public class FlightBookingSystem {
    private final Flight[] availableFlights; // [cite: 110]
    private final List<Booking> userBookings; // [cite: 111]

    public FlightBookingSystem(Flight[] flights) {
        this.availableFlights = flights;
        this.userBookings = new ArrayList<>();
    }

    public void searchFlights(String destination) { // [cite: 112, 113]
        System.out.println("\nSearching for flights to: " + destination);
        boolean found = false;
        for (Flight flight : availableFlights) {
            // Case-insensitive search
            if (flight.destination.equalsIgnoreCase(destination) && flight.availableSeats > 0) {
                System.out.printf("Flight %s to %s has %d seats available.\n",
                        flight.flightNumber, flight.destination, flight.availableSeats);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available flights found for the specified destination.");
        }
    }

    public void bookFlight(String flightNumber, String passengerName) { // [cite: 113]
        for (Flight flight : availableFlights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                if (flight.availableSeats > 0) {
                    flight.availableSeats--;
                    Booking newBooking = new Booking(passengerName, flight);
                    userBookings.add(newBooking);
                    System.out.println("\nBooking successful!");
                    newBooking.displayDetails();
                } else {
                    System.out.println("Booking failed. Flight " + flightNumber + " is full.");
                }
                return;
            }
        }
        System.out.println("Booking failed. Flight " + flightNumber + " not found.");
    }

    public void displayAllBookings() { // [cite: 113]
        System.out.println("\n--- All User Bookings ---");
        if(userBookings.isEmpty()) {
            System.out.println("No bookings have been made yet.");
        } else {
            for (Booking booking : userBookings) {
                booking.displayDetails();
            }
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Flight[] flights = {
                new Flight("AI202", "New York", 5),
                new Flight("BA144", "London", 10),
                new Flight("EK516", "Dubai", 2)
        };
        FlightBookingSystem system = new FlightBookingSystem(flights);

        system.searchFlights("london");
        system.bookFlight("EK516", "Alice");
        system.bookFlight("EK516", "Bob");
        system.bookFlight("EK516", "Charlie"); // This should fail
        system.displayAllBookings();
    }
}