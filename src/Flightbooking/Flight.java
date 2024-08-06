package Flightbooking;

public class Flight {
    int seats;
    int id;
    String name;

    public int getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Flight(int id, String name, int seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
    }

}
