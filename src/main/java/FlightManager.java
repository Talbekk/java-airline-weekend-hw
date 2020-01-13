import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public int getTotalBaggageAllowance() {
        PlaneType plane = this.flight.getFlightPlane();
        return plane.getWeight() / 2;
    }

    public int getPassengerBaggageAllowance() {
        int totalAllowance = this.getTotalBaggageAllowance();
        PlaneType plane = this.flight.getFlightPlane();
        return totalAllowance / plane.getCapacity();
    }

    public int getPassengerTotalBaggageWeight() {
        ArrayList<Passenger> passengerList = this.flight.getPassengers();
        Passenger selectedPassenger = passengerList.get(0);
        return selectedPassenger.getTotalBagWeight();
    }

    public HashMap<String, Integer> getListOfPassengerBaggageWeights() {
        HashMap<String, Integer> baggageWeightList = new HashMap<String, Integer>();
        ArrayList<Passenger> passengerList = this.flight.getPassengers();

        for (Passenger currentPassenger : passengerList){
            baggageWeightList.put(currentPassenger.getName(), currentPassenger.getTotalBagWeight());
        }
        return baggageWeightList;
    }

    public int getTotalBaggageWeight() {
        HashMap<String, Integer> baggageWeightList = this.getListOfPassengerBaggageWeights();
        Collection<Integer> valuesSet = baggageWeightList.values();
        ArrayList<Integer> listOfWeights = new ArrayList<Integer>(valuesSet);
        int total = 0;
        for (int bagWeight : listOfWeights){
            total += bagWeight;
        }
        return total;
    }

    public int getRemainingBaggageCapacity() {
        int result = this.getTotalBaggageAllowance() - getTotalBaggageWeight();
        return result;
    }

    public int[] getSortedListOfSeats() {
        ArrayList<Passenger> sortedList = new ArrayList<Passenger>();
        int temp = 0;
        int arrayLength = this.getSeatNumbers().length;
        int[] seatsList = this.getSeatNumbers();
        for (int i = 0; i<arrayLength-1;i++){
            for (int j =0; j<arrayLength-1-i; j++){
                if(seatsList[j] > seatsList[j+1]){
                    temp = seatsList[j];
                    seatsList[j] = seatsList[j+1];
                    seatsList[j+1] = temp;
                }
            }
        }
        return seatsList;
    }
    
    public int[] getSeatNumbers() {
        int[] seatNumbers = new int[this.flight.passengerCount()];
        for(int i = 0; i < seatNumbers.length; i++){
            seatNumbers[i] = this.flight.getPassengers().get(i).getSeatNumber();
        }
        return seatNumbers;
    }

    public ArrayList<Passenger> getPassengersOrderedBySeatNumber() {
        int[] seats = this.getSortedListOfSeats();
        ArrayList<Passenger> passengerList = this.flight.getPassengers();
        ArrayList<Passenger> sortedList = new ArrayList<Passenger>();

        for ( int currentSeat : seats){
            for (Passenger passenger: passengerList) {
                if (currentSeat == passenger.getSeatNumber()) {
                    sortedList.add(passenger);
                }
            }
        }
        return sortedList;
    }
}
