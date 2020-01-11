import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

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

}
