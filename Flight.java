package Flight;

import java.util.LinkedList;
import java.util.Queue;

public class Flight {
    String flightNumber;
    String destination;
    String departureTime;
    int availableEconomySeats;
    int availableBusinessSeats;
    Queue<Passenger> economyQueue;
    Queue<Passenger> businessQueue;

    public Flight(String flightNumber, String destination, String departureTime, int economySeats, int businessSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableEconomySeats = economySeats;
        this.availableBusinessSeats = businessSeats;
        this.economyQueue = new LinkedList<>();
        this.businessQueue = new LinkedList<>();
    }

    public void displayFlightDetails() {
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Available Economy Seats: " + availableEconomySeats);
        System.out.println("Available Business Seats: " + availableBusinessSeats);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passenger.seatClass.equalsIgnoreCase("business")) {
            if (availableBusinessSeats > 0) {
                businessQueue.offer(passenger);
                availableBusinessSeats--;
                System.out.println(passenger.name + " has been added to the business class queue.");
                return true;
            } else {
                System.out.println("No available business class seats for " + passenger.name);
                return false;
            }
        } else if (passenger.seatClass.equalsIgnoreCase("economy")) {
            if (availableEconomySeats > 0) {
                economyQueue.offer(passenger);
                availableEconomySeats--;
                System.out.println(passenger.name + " has been added to the economy class queue.");
                return true;
            } else {
                System.out.println("No available economy seats for " + passenger.name);
                return false;
            }
        }
        return false;
    }

    public void reserveSeat(String seatClass) {
        if (seatClass.equalsIgnoreCase("business") && !businessQueue.isEmpty()) {
            Passenger passenger = businessQueue.poll();
            passenger.isBooked = true;
            System.out.println("Reservation confirmed for " + passenger.name + " in business class.");
        } else if (seatClass.equalsIgnoreCase("economy") && !economyQueue.isEmpty()) {
            Passenger passenger = economyQueue.poll();
            passenger.isBooked = true;
            System.out.println("Reservation confirmed for " + passenger.name + " in economy class.");
        } else {
            System.out.println("No passengers in the " + seatClass + " class queue or no seats available.");
        }
    }

    public void cancelReservation(Passenger passenger) {
        if (passenger.seatClass.equalsIgnoreCase("business")) {
            businessQueue.remove(passenger);
            availableBusinessSeats++;
            System.out.println("Reservation canceled for " + passenger.name + " in business class.");
        } else if (passenger.seatClass.equalsIgnoreCase("economy")) {
            economyQueue.remove(passenger);
            availableEconomySeats++;
            System.out.println("Reservation canceled for " + passenger.name + " in economy class.");
        }
    }
}
