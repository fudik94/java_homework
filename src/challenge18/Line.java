package challenge18;

import java.util.Arrays;

public abstract class Line implements Mappable {

    private double[][] locations;

    public Line(String... locationStrings) {
        locations = new double[locationStrings.length][];
        for (int i = 0; i < locationStrings.length; i++) {
            locations[i] = Mappable.stringToLatLon(locationStrings[i]);
        }
    }

    private String locations() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < locations.length; i++) {
            sb.append(Arrays.toString(locations[i]));
            if (i < locations.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }
}
