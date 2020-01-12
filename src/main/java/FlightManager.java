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

//    public ArrayList<Passenger> getPassengersOrderedBySeatNumber() {
//        ArrayList<Passenger> sortedList = new ArrayList<Passenger>(this.flight.getPassengers());
//        Passenger temp;
//        for (int i = 0; i<sortedList.size()-1;i++){
//            for (int j =0; j<sortedList.size()-1-i; j++){
//                if(sortedList.get(j).getSeatNumber() > sortedList.get(j+1).getSeatNumber()){
//                    temp = sortedList.get(j);
//                    sortedList.get(j) = sortedList.get(j+1);
//                    sortedList.get(j+1) = temp;
//                }
//            }
//        }
//        return sortedList;
//    }
}
