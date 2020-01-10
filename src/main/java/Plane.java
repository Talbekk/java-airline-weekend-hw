public class Plane {

    private PlaneType typeOfPlane;

    public Plane(PlaneType typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public PlaneType getTypeOfPlane() {
        return this.typeOfPlane;
    }

    public int getCapacityOfPlane() {
        return this.typeOfPlane.getCapacity();
    }

    public int getWeightOfPlane() {
        return this.typeOfPlane.getWeight();
    }
}
