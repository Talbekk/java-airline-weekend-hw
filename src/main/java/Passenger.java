public class Passenger {

    private String name;
    private int numberOfBags;
    private Flight flight;

    public Passenger(String name, int numberOfBags, Flight flight) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.flight = flight;
    }

    public String getName() {
        return this.name;
    }

    public int getBagCount() {
        return this.numberOfBags;
    }


    public int getTotalBagWeight() { return this.getBagCount() * 10; }

    public Flight getFlight() {
        return this.flight;
    }

    public void addFlight(Flight flight) {
        this.flight = flight;
    }
}
