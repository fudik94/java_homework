package challenge8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // --- Employee test ---
        SalariedEmployee liisi = new SalariedEmployee("Liisi", "1985-06-15", 1001L, "2010-03-01", 36000);
        HourlyEmployee priit   = new HourlyEmployee("Priit", "1990-11-22", 1002L, "2015-07-12", 15.0);

        System.out.println("Age of Liisi: " + liisi.getAge());
        System.out.println("Age of Priit: " + priit.getAge());

        System.out.printf("Liisi monthly pay: %.2f€%n", liisi.collectPay());
        System.out.printf("Priit monthly pay: %.2f€%n", priit.collectPay());
        System.out.printf("Priit double pay rate: %.2f€/h%n", priit.getDoublePay());

        liisi.retire();
        System.out.printf("Liisi pay after retirement: %.2f€%n", liisi.collectPay());
        liisi.terminate("2026-06-01");

        System.out.println(liisi);
        System.out.println(priit);

        // --- Pond lifecycle ---
        System.out.println("\n--- Pond lifecycle ---");

        List<Stone> pond = new ArrayList<>();

        Stone s1 = new Stone(2, 3);
        Stone s2 = new Stone(5, 5);
        Weed  w1 = new Weed(1, 1);
        Weed  w2 = new Weed(4, 2);
        Fish  f1 = new Fish(0, 0, "Nemo");
        Fish  f2 = new Fish(3, 3, "Dory");

        pond.add(s1);
        pond.add(s2);
        pond.add(w1);
        pond.add(w2);
        pond.add(f1);
        pond.add(f2);

        for (int cycle = 1; cycle <= 3; cycle++) {
            System.out.println("\n-- Cycle " + cycle + " --");
            for (Stone obj : pond) {
                if (obj instanceof Fish fish) {
                    // move one step in random direction
                    int newX = fish.getX() + (int) (Math.random() * 3) - 1;
                    int newY = fish.getY() + (int) (Math.random() * 3) - 1;
                    fish.move(newX, newY, pond);
                } else if (obj instanceof Weed weed) {
                    if (Math.random() < 0.6) weed.grow();
                    else weed.die();
                }
            }
        }
    }
}
