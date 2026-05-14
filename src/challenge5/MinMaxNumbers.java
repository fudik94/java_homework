package challenge5;

import java.util.Scanner;

public class MinMaxNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        boolean hasNumbers = false;

        while (true) {
            System.out.print("Enter a number (or any character to quit): ");
            String input = scanner.nextLine();

            try {
                double number = Double.parseDouble(input);
                if (number < min) min = number;
                if (number > max) max = number;
                hasNumbers = true;
            } catch (NumberFormatException e) {
                break; // not a number, quit
            }
        }

        if (hasNumbers) {
            System.out.println("Min = " + min);
            System.out.println("Max = " + max);
        }

        scanner.close();
    }
}
