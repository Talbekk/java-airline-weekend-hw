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
}
