import java.util.ArrayList;
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
        return selectedPassenger.getBagCount() * 10;
    }

    public HashMap<String, Integer> getListOfPassengerBaggageWeights() {
        HashMap<String, Integer> baggageWeightList = new HashMap<String, Integer>();
        ArrayList<Passenger> passengerList = this.flight.getPassengers();

        for (Passenger currentPassenger : passengerList){
            baggageWeightList.put(currentPassenger.getName(), currentPassenger.getBagCount()*2);
        }
        return baggageWeightList;
    }

//    public int getPassengerTotalBaggageWeight() {
//        return this.flight.;
//    }
}
