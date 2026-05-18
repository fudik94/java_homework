package challenge20;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    // inner class — specialized Item with toppings
    public class Burger extends Item {

        private List<Item> toppings = new ArrayList<>();

        public Burger(String name, double basePrice) {
            super(name, "Burger", basePrice);
        }

        public void addTopping(Item topping) {
            toppings.add(topping);
        }

        public double getTotalPrice() {
            double total = getPrice();
            for (Item t : toppings) total += t.getPrice();
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getName()).append(" - base: ").append(String.format("%.2f€", getPrice()));
            for (Item t : toppings) {
                sb.append("\n  + ").append(t);
            }
            sb.append(String.format("%n  Total: %.2f€", getTotalPrice()));
            return sb.toString();
        }
    }

    private Burger burger;

    public Meal(String burgerName, double basePrice) {
        this.burger = new Burger(burgerName, basePrice);
    }

    // delegate topping creation to burger
    public void addToppings(String... toppingNames) {
        for (String t : toppingNames) {
            // free toppings cost 0, extras cost 0.50
            double price = t.equalsIgnoreCase("lettuce") || t.equalsIgnoreCase("ketchup") ? 0.0 : 0.50;
            burger.addTopping(new Item(t, "Topping", price));
        }
    }

    public Burger getBurger() { return burger; }

    @Override
    public String toString() {
        return "Meal: " + burger;
    }
}
