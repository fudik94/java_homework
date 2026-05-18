package challenge15;

public class Place {

    private String name;
    private int distance; // km from Tallinn

    public Place(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() { return name; }
    public int getDistance() { return distance; }

    @Override
    public String toString() {
        return name + " (" + distance + " km)";
    }
}
