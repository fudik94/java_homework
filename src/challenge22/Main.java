package challenge22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static final Random random = new Random(42);

    // static method references
    static String addMiddleInitial(String name) {
        return name + " " + (char)('A' + random.nextInt(26)) + ".";
    }

    static String addLastName(String name) {
        String first = name.split(" ")[0];
        return name + " " + new StringBuilder(first).reverse().toString();
    }

    static String addGreeting(String name) {
        return "What's up, " + name;
    }

    // instance method — for bound method reference
    String addTitle(String name) {
        String[] titles = {"Mr.", "Ms.", "Dr."};
        return titles[random.nextInt(titles.length)] + " " + name;
    }

    // applies each function to each element using String.transform
    static void applyFunctions(String[] names, List<UnaryOperator<String>> functions) {
        for (UnaryOperator<String> fn : functions) {
            Arrays.setAll(names, i -> names[i].transform(fn));
            System.out.println(Arrays.toString(names));
        }
    }

    public static void main(String[] args) {
        String[] names = {
            "Arvo", "Liisa", "Janis", "Liga",
            "Jonas", "Mindaugas", "Emma", "Nils"
        };

        Main app = new Main();

        List<UnaryOperator<String>> functions = new ArrayList<>();

        functions.add(String::toUpperCase);                      // unbound instance method ref
        functions.add(Main::addMiddleInitial);                   // static method ref
        functions.add(Main::addLastName);                        // static method ref
        functions.add(s -> s.replaceAll("(\\w)\\.", ".$1"));    // lambda — period before initial
        functions.add(app::addTitle);                            // bound instance method ref
        functions.add(Main::addGreeting);                        // static method ref

        applyFunctions(names, functions);
    }
}
