package challenge17;

public class Building implements Mappable {

    private String name;
    private UsageType type;

    public Building(String name, UsageType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case GOVERNMENT   -> Color.RED    + " " + PointMarkers.STAR;
            case ENTERTAINMENT -> Color.GREEN  + " " + PointMarkers.TRIANGLE;
            case SPORTS       -> Color.ORANGE  + " " + PointMarkers.PUSH_PIN;
            case BUSINESS     -> Color.BLUE    + " " + PointMarkers.CIRCLE;
            default           -> Color.BLACK   + " " + PointMarkers.DIAMOND;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() +
                String.format(", \"name\": \"%s\", \"usage\": \"%s\"", name, type);
    }
}
