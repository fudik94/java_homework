package challenge14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GroceryList {

    private ArrayList<String> list = new ArrayList<>();

    public void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (trimmed.isEmpty()) continue;
            if (list.contains(trimmed)) {
                System.out.println("\"" + trimmed + "\" is already in the list, skipping.");
            } else {
                list.add(trimmed);
                System.out.println("\"" + trimmed + "\" added.");
            }
        }
    }

    public void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (list.remove(trimmed)) {
                System.out.println("\"" + trimmed + "\" removed.");
            } else {
                System.out.println("\"" + trimmed + "\" not found in list.");
            }
        }
    }

    public void printList() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        ArrayList<String> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        System.out.println("\nGrocery list:");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryList groceryList = new GroceryList();

        System.out.println("Available actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add item(s) to list (comma delimited list)");
        System.out.println("2 - to remove any items (comma delimited list)");

        while (true) {
            System.out.print("\nEnter a number for which action you want to do: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "0":
                    System.out.println("Shutting down. Goodbye!");
                    scanner.close();
                    return;
                case "1":
                    System.out.print("Enter item(s) to add (comma separated): ");
                    groceryList.addItems(scanner.nextLine());
                    groceryList.printList();
                    break;
                case "2":
                    System.out.print("Enter item(s) to remove (comma separated): ");
                    groceryList.removeItems(scanner.nextLine());
                    groceryList.printList();
                    break;
                default:
                    System.out.println("Invalid option. Please enter 0, 1 or 2.");
            }
        }
    }
}
