public class Passenger {

    private String name;
    private int numberOfBags;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
    }

    public String getName() {
        return this.name;
    }

    public int getBagCount() {
        return this.numberOfBags;
    }


    public int getTotalBagWeight() { return this.getBagCount() * 10; }
}
