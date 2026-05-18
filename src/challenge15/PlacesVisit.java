package challenge15;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlacesVisit {

    private LinkedList<Place> list = new LinkedList<>();
    private ListIterator<Place> iterator;
    private boolean goingForward = true;

    // insert in order by distance, skip duplicates
    public void addPlace(Place place) {
        for (Place p : list) {
            if (p.getName().equalsIgnoreCase(place.getName())) return; // no duplicates
        }
        for (int i = 0; i < list.size(); i++) {
            if (place.getDistance() < list.get(i).getDistance()) {
                list.add(i, place);
                return;
            }
        }
        list.add(place); // largest distance goes last
    }

    public void printList() {
        System.out.println("\nPlaces in itinerary:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + list.get(i));
        }
        System.out.println();
    }

    public void printMenu() {
        System.out.println("\nAvailable actions (select word or letter):");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
    }

    public static void main(String[] args) {
        PlacesVisit app = new PlacesVisit();

        // ordered by distance from Tallinn
        app.addPlace(new Place("Tallinn",  0));
        app.addPlace(new Place("Pärnu",  127));
        app.addPlace(new Place("Viljandi", 147));
        app.addPlace(new Place("Tartu",  179));
        app.addPlace(new Place("Põlva",  224));
        app.addPlace(new Place("Võru",   246));

        app.iterator = app.list.listIterator();

        Scanner scanner = new Scanner(System.in);
        app.printMenu();

        while (true) {
            System.out.print("\nEnter action: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "F": case "FORWARD":
                    if (!app.goingForward) {
                        // compensate cursor when switching direction
                        if (app.iterator.hasNext()) app.iterator.next();
                        app.goingForward = true;
                    }
                    if (app.iterator.hasNext()) {
                        System.out.println("Going to: " + app.iterator.next());
                    } else {
                        System.out.println("End of list. Cannot go forward.");
                    }
                    break;

                case "B": case "BACKWARD":
                    if (app.goingForward) {
                        // compensate cursor when switching direction
                        if (app.iterator.hasPrevious()) app.iterator.previous();
                        app.goingForward = false;
                    }
                    if (app.iterator.hasPrevious()) {
                        System.out.println("Going back to: " + app.iterator.previous());
                    } else {
                        System.out.println("Start of list. Cannot go backward.");
                    }
                    break;

                case "L": case "LIST PLACES":
                    app.printList();
                    break;

                case "M": case "MENU":
                    app.printMenu();
                    break;

                case "Q": case "QUIT":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please use F, B, L, M or Q.");
            }
        }
    }
}
