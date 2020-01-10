public enum PlaneType {

    BOEING747(200, 6000),
    BOEING636(150, 5000),
    BOEING858(250, 7000),
    BOEING969(300, 8000);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getWeight() {
        return this.weight;
    }
}
