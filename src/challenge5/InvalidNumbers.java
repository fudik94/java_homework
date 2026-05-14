package challenge5;

import java.util.Scanner;

public class InvalidNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        while (count < 5) {
            System.out.print("Enter number #" + (count + 1) + ": ");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }

        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
