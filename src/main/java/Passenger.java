public class Passenger {

    private String name;
    private int numberOfBags;
    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags, Flight flight) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.flight = flight;
        this.seatNumber = seatNumber;
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

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void addSeatNumber(int newSeatNumber) {
        this.seatNumber = newSeatNumber;
    }
}
