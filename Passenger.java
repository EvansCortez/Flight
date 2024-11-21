package Flight;

public class Passenger {
    String name;
    String seatClass; // Business or Economy
    boolean isBooked;

    public Passenger(String name, String seatClass) {
        this.name = name;
        this.seatClass = seatClass;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Passenger Name: " + name + ", Seat Class: " + seatClass;
    }
}
