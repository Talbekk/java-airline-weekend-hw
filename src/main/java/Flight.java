import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;
    private Plane plane;

    public Flight(){

    }

    public Flight(String flightNumber, String destination, String departureAirport, Date departureTime, Plane plane) {
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

    public Date getDepartureTime() {
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
            int seatNumber = this.getAvailableSeat();
            passenger.addSeatNumber(seatNumber);
//            this.bookSeat(seatNumber);
        }
    }

    public void testToAddPassengerOnSameSeat(Passenger passenger, int seat) {
        if (this.flightHasSeatsAvailable()) {
            if (this.getRemainingSeats().contains(seat)) {
                this.passengers.add(passenger);
                passenger.addSeatNumber(seat);
            }
//            this.bookSeat(seat);
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
        for (Passenger currentPassenger : passengers) {
                this.addPassenger(currentPassenger);
        }
    }

    public ArrayList<Integer> getAllSeats() {
         ArrayList<Integer> seatList = new ArrayList<Integer>();
         for( Integer currentSeat = 1; currentSeat <= this.plane.getCapacityOfPlane();currentSeat++ ) {
             seatList.add(currentSeat);
         }
         return seatList;
    }

    public ArrayList<Integer> getRemainingSeats(){
        ArrayList<Integer> seatList = new ArrayList<Integer>(this.getAllSeats());
        for(Passenger currentPassenger: this.passengers){
            seatList.remove((Integer)currentPassenger.getSeatNumber());
        }
        return seatList;
    }

    public int getAvailableSeat() {
        ArrayList<Integer> listOfSeats = new ArrayList<Integer>(this.getRemainingSeats());
        Random random = new Random();
        Integer result = listOfSeats.get(random.nextInt(listOfSeats.size()));
        return result;
    }

//    public void bookSeat(Integer chosenSeat){
//        ArrayList<Integer> seatList = this.getRemainingSeats();
//        seatList.remove(chosenSeat);
//    }

    public boolean checkIfFunctionReturnsAValidSeat() {
        if( this.getAvailableSeat() <= this.getFlightPlane().getCapacity()){
        return true;
        }
        return false;
    }
}
