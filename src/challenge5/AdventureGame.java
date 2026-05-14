package challenge5;

import java.util.Scanner;

public class AdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== THE LOST KINGDOM ===");

        while (true) {
            // main menu
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Start your journey");
            System.out.println("2. Visit the village");
            System.out.println("3. Enter the dark forest");
            System.out.println("4. Go to the castle");
            System.out.println("5. Check your inventory");
            System.out.println("0. Exit game");
            System.out.print("Choose: ");

            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                System.out.println("Goodbye, adventurer!");
                break;
            }

            switch (input) {
                case "1":
                    showLevel2(scanner, "You set off on a long road. The path splits ahead...");
                    break;
                case "2":
                    showLevel2(scanner, "The village is quiet. A merchant offers you supplies.");
                    break;
                case "3":
                    showLevel2(scanner, "The forest is dark and full of strange sounds.");
                    break;
                case "4":
                    showLevel2(scanner, "The castle gates are locked. A guard blocks your way.");
                    break;
                case "5":
                    showLevel2(scanner, "Inventory: Sword, Shield, 3 Health Potions");
                    break;
                default:
                    // ignore invalid input
                    break;
            }
        }

        scanner.close();
    }

    public static void showLevel2(Scanner scanner, String text) {
        System.out.println("\n" + text);
        System.out.println("[Press Q to return to main menu]");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            // ignore everything else
        }
    }
}
