package Flight;
import java.util.ArrayList;
import java.util.Scanner;

// Flight Reservation System class
public class FlightReservationSystem {
    private ArrayList<Flight> flights;
    private Scanner scanner;

    public FlightReservationSystem() {
        flights = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add flights
    public void addFlight(String flightNumber, String destination, String departureTime, int economySeats, int businessSeats) {
        flights.add(new Flight(flightNumber, destination, departureTime, economySeats, businessSeats));
    }

    // Method to display all available flights
    public void displayAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                flight.displayFlightDetails();
                System.out.println("----------------------------");
            }
        }
    }

    // Method to find a flight by its number
    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        System.out.println("Flight not found.");
        return null;
    }

    // Method to reserve a seat for a passenger
    public void reserveSeat() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Enter seat class (business/economy): ");
            String seatClass = scanner.nextLine();
            Passenger passenger = new Passenger(passengerName, seatClass);
            flight.addPassenger(passenger);
        }
    }

    // Method to process reservations
    public void processReservation() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.print("Enter seat class to reserve (business/economy): ");
            String seatClass = scanner.nextLine();
            flight.reserveSeat(seatClass);
        }
    }

    // Method to cancel a reservation
    public void cancelReservation() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.print("Enter passenger name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Enter seat class (business/economy): ");
            String seatClass = scanner.nextLine();
            Passenger passenger = new Passenger(passengerName, seatClass);
            flight.cancelReservation(passenger);
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        FlightReservationSystem system = new FlightReservationSystem();
        system.addFlight("AA101", "Shanghai", "2024-12-01 08:00", 10, 5);
        system.addFlight("BA202", "Tokyo", "2024-12-01 10:00", 20, 3);
        system.addFlight("CA303", "Seoul", "2024-12-02 09:00", 15, 5);
        system.addFlight("DA404", "Hong Kong", "2024-12-02 11:00", 20, 5);
        system.addFlight("EA505", "Paris", "2024-12-03 09:00", 20, 5);
        system.addFlight("FA606", "London", "2024-12-03 11:00", 20, 5);
        system.addFlight("GA707", "New York", "2024-12-04 11:00", 20, 5);
        system.addFlight("HA808", "Mexico City", "2024-12-04 11:00", 20, 5);
        system.addFlight("IA909", "Singapore", "2024-12-05 11:00", 20, 5);
        system.addFlight("JA404", "Bangkok", "2024-12-05 11:00", 20, 5);
        system.addFlight("JA404", "Rome", "2024-12-05 06:00", 24, 9);
        system.addFlight("JA404", "Hanoi", "2024-12-05 08:30", 25, 3);
        system.addFlight("NA404", "Dubai", "2024-12-05 06:00", 50, 20);
        system.addFlight("KA404", "Los Angelos", "2024-12-09 05:00", 25, 10);
        system.addFlight("VA404", "Beijing", "2024-12-10 12:00", 25, 10);
        system.addFlight("ZA404", "Taipei", "2024-12-09 13:30", 25, 10);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nFlight Reservation System");
            System.out.println("1. Display all flights");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Process reservation");
            System.out.println("4. Cancel reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = system.scanner.nextInt();
            system.scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.displayAllFlights();
                    break;
                case 2:
                    system.reserveSeat();
                    break;
                case 3:
                    system.processReservation();
                    break;
                case 4:
                    system.cancelReservation();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
