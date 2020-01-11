import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;

public class Flight {

    private ArrayList<Passenger> passengers;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;
    private Plane plane;

    public Flight(String flightNumber, String destination, String departureAirport, String departureTime, Plane plane) {
        this.passengers = new ArrayList<Passenger>();
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.plane = plane;
    }

    public int passengerCount() {
       ArrayList<Passenger> listOfPassengers = new ArrayList<Passenger>(this.passengers);
       return listOfPassengers.size();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public PlaneType getFlightPlane() {
        return this.plane.getTypeOfPlane();
    }

    public boolean flightHasSeatsAvailable() {
        return this.passengerCount() < this.plane.getCapacityOfPlane();
    }

    public int getNumberOfSeatsAvailable() {
        return this.plane.getCapacityOfPlane() - this.passengerCount();
    }

    public void addPassenger(Passenger passenger) {
        if (this.flightHasSeatsAvailable()) {
            this.passengers.add(passenger);
        }
    }

    public Passenger getPassenger(Passenger passenger1) {
        for (Passenger currentPassenger : this.passengers) {
            if (currentPassenger == passenger1) {
                return currentPassenger;
            }
        }
        return null;
    }

    public ArrayList<Passenger> getPassengers() {
        ArrayList<Passenger> listOfPassengers = new ArrayList<Passenger>(this.passengers);
        return listOfPassengers;
    }

    public void addGroupOfPassengers(ArrayList<Passenger> passengers) {
        for (Passenger currentPassenger : passengers){
            this.passengers.add(currentPassenger);
        }
    }
}
