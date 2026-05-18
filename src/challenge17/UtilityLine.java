package challenge17;

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
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
            case FIBER_OPTIC -> Color.GREEN  + " " + LineMarkers.DOTTED;
            case ELECTRICAL  -> Color.YELLOW + " " + LineMarkers.DASHED;
            case WATER       -> Color.BLUE   + " " + LineMarkers.SOLID;
            case GAS         -> Color.ORANGE + " " + LineMarkers.DASHED;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() +
                String.format(", \"name\": \"%s\", \"utility\": \"%s\"", name, type);
    }
}
