package challenge7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // --- Carpet test ---
        Carpet.squareMeterCost = 8.0;
        Carpet room1 = new Carpet(12, 10);
        Carpet room2 = new Carpet(5, 7);
        Carpet room3 = new Carpet(-3, 4); // invalid width -> 0

        System.out.printf("Room1: area=%.1f m2, cost=%.2f€%n", room1.getArea(), room1.getTotalCost());
        System.out.printf("Room2: area=%.1f m2, cost=%.2f€%n", room2.getArea(), room2.getTotalCost());
        System.out.printf("Room3: area=%.1f m2, cost=%.2f€%n", room3.getArea(), room3.getTotalCost());

        // --- ComplexNumber test ---
        ComplexNumber c1 = new ComplexNumber(5, 3);
        ComplexNumber c2 = new ComplexNumber(4, 2);

        System.out.println("\nc1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("Static add: " + ComplexNumber.addNumbers(c1, c2));
        System.out.println("Static subtract: " + ComplexNumber.subtractNumbers(c1, c2));

        c1.add(1, 1);
        System.out.println("c1 after instance add: " + c1);
        c1.subtract(2, 2);
        System.out.println("c1 after instance subtract: " + c1);

        // --- Bus stops test ---
        // Place stops.txt (from estonia_unified_gtfs.zip) into src/challenge7/
        System.out.println("\nReading bus stops data...");
        List<BusStop> stops = readBusStops("./src/challenge7/stops.txt");

        System.out.println("Calculating distances between bus stops...");
        System.out.println("Checking if bus stops are in the same area...\n");

        for (int i = 0; i < 5; i++) {
            BusStop a = getRandomStop(stops);
            BusStop b = getRandomStop(stops);
            double distance = BusStop.getDistance(a, b);
            boolean sameArea = BusStop.isSameArea(a, b);
            System.out.printf("Distance between %s in %s and %s in %s is %.1f km%n",
                    a.name(), a.area(), b.name(), b.area(), distance);
            System.out.println("Are they in the same area? " + sameArea);
        }
    }

    // reads stops.txt (GTFS format): stop_id, stop_code, stop_name, lat, lon, ..., stop_area (col 15), ...
    public static List<BusStop> readBusStops(String filePath) {
        List<BusStop> stops = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) scanner.nextLine(); // skip header

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 16) continue;

                String id   = parts[0].trim();
                String name = parts[2].trim();
                double lat  = Double.parseDouble(parts[3].trim());
                double lon  = Double.parseDouble(parts[4].trim());
                String area = parts[15].trim(); // stop_area column

                if (!area.isEmpty()) {
                    stops.add(new BusStop(id, name, lat, lon, area));
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return stops;
    }

    public static BusStop getRandomStop(List<BusStop> stops) {
        int index = (int) (Math.random() * stops.size());
        return stops.get(index);
    }
}
