package Flightbooking;

public class Passenger {
    String name;
    int seatsRequired;
    String flight;
    int cost;

    public Passenger(String name, String flight, int seatsRequired, int cost) {
        this.name = name;
        this.flight = flight;
        this.cost = cost;
        this.seatsRequired = seatsRequired;
    }

    public String getName() {
        return name;
    }

    public String getFlight() {
        return flight;
    }

    public int getSeatsRequired() {
        return seatsRequired;
    }

    public int getCost() {
        return cost;
    }
}
