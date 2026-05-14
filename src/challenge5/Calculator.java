package challenge5;

import java.util.Scanner;

public class Calculator {

    public static void calculate() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.println("Enter integers (any letter to stop):");

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                sum += number;
                count++;
            } catch (NumberFormatException e) {
                break; // stop reading
            }
        }

        double avg = count == 0 ? 0 : (double) sum / count;
        System.out.printf("SUM = %d AVG = %.2f%n", sum, avg);
        scanner.close();
    }

    public static void main(String[] args) {
        calculate();
    }
}
