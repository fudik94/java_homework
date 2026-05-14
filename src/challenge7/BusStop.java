package challenge7;

public record BusStop(String id, String name, double latitude, double longitude, String area) {

    private static final double EARTH_RADIUS_KM = 6371.0;

    // Haversine formula
    public static double getDistance(BusStop a, BusStop b) {
        double lat1 = Math.toRadians(a.latitude());
        double lat2 = Math.toRadians(b.latitude());
        double deltaLat = Math.toRadians(b.latitude() - a.latitude());
        double deltaLon = Math.toRadians(b.longitude() - a.longitude());

        double h = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h));
        return EARTH_RADIUS_KM * c;
    }

    public static boolean isSameArea(BusStop a, BusStop b) {
        return a.area().equals(b.area());
    }
}
