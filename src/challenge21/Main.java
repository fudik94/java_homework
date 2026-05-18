package challenge21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // mixed case, Anna and Hannah are palindromes
        String[] names = {"Alice", "Bob", "Anna", "Charlie", "Eve", "Hannah", "David"};
        List<String> nameList = Arrays.asList(names); // backed by array

        // 1. to uppercase
        nameList.replaceAll(name -> name.toUpperCase());
        System.out.println("--- Uppercase ---");
        nameList.forEach(System.out::println);

        // 2. add random middle initial
        nameList.replaceAll(name -> name + " " + (char) ('A' + random.nextInt(26)) + ".");
        System.out.println("\n--- With middle initial ---");
        nameList.forEach(System.out::println);

        // 3. last name = reverse of first name
        nameList.replaceAll(name -> {
            String first = name.split(" ")[0];
            String last = new StringBuilder(first).reverse().toString();
            return name + " " + last;
        });
        System.out.println("\n--- With last name ---");
        nameList.forEach(System.out::println);

        // remove names where last name equals first name (palindromes)
        ArrayList<String> result = new ArrayList<>(nameList);
        result.removeIf(name -> {
            String[] parts = name.split(" ");
            return parts[0].equals(parts[2]);
        });
        System.out.println("\n--- After removing palindrome names ---");
        result.forEach(System.out::println);
    }
}
