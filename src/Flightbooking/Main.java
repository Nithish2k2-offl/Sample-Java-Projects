package Flightbooking;

import java.util.Scanner;

public class Main {
    static int choice;
    static Scanner s = new Scanner(System.in);
    static String passengerName, desiredFlight;
    static int seats;
    static int price = 5000;

    static int flightID = 0;

    public static void main(String[] args) {
        System.out.println("Welcome");
        Lists.flightsList.add(new Flight(++flightID, "air", 50));
        Lists.flightsList.add(new Flight(++flightID, "deccan", 50));
        Lists.flightsList.add(new Flight(++flightID, "qatar", 50));

        mainmenu();
    }

    static void mainmenu() {
        System.out.println("1. book 2. cancel 3. print 4. exit");
        choice = s.nextInt();
        switch (choice) {
            case 1:
                bookTicket();
                mainmenu();
                break;
            case 2:
                cancelTicket();
                mainmenu();
                break;
            case 3:
                print();
                mainmenu();
                break;
            case 4:
            System.exit(0);
        }
    }

    static void bookTicket() {
        System.out.println("enter passenger details");
        passengerName = s.next();
        System.out.println("enter no. of seats");
        seats = s.nextInt();
        System.out.println("enter your flight name...");
        desiredFlight = s.next();

        for (Flight f : Lists.flightsList) {
            if (f.getName().equals(desiredFlight)) {
                if (f.getSeats() >= seats) {
                    int currentprice = seats * price;
                    Lists.passengersList.add(new Passenger(passengerName, desiredFlight, seats, currentprice));

                    // reducing the available seats in the current flight
                    int currentseats = f.getSeats() - seats;
                    f.setSeats(currentseats);

                    System.out.println("\n-----booked successfully\n");
                    price += 200;
                    break;
                } else {
                    System.out.println("Seats not available");
                    System.out.println("Maximum available seats are: " + f.getSeats());
                }
            }
        }
    }

    static void cancelTicket() {
        boolean temp = false;
        System.out.println("Enter the name of the passenger");
        passengerName = s.next();
        for (Passenger p : Lists.passengersList) {
            if (p.getName().equals(passengerName)) // if passenger found
            {
                for (Flight f : Lists.flightsList) {
                    if (p.getFlight().equals(f.getName())) {
                        f.setSeats(f.getSeats() + p.getSeatsRequired());
                        System.out.println("cancelled successfully");
                        temp = true;
                        break;
                    }
                }
                if (temp) {
                    Lists.passengersList.remove(Lists.passengersList.indexOf(p));
                    // List.indexOf("item") -----> returns the index of the 'item' in the list
                    break;
                }
            } else {
                System.out.println("passenger not found...");
            }
        }

    }

    static void print() {
        System.out.println();
        System.out.println("------------------\nPassenger details\n---------------");
        for (Passenger p : Lists.passengersList) {
            System.out
                    .println("Name: " + p.getName() + " seats: " + p.getSeatsRequired() + " " + p.getFlight()
                            + " total cost: "
                            + p.getCost());
        }
        System.out.println("\n--------------\nFlight details\n---------------");
        for (Flight f : Lists.flightsList) {
            System.out.println(f.id + " " + f.getName() + " " + f.getSeats());
        }
        System.out.println();
    }
}
