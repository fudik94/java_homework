package challenge11;

public class Main {

    public static void main(String[] args) {

        FuelPoweredCar ford  = new FuelPoweredCar("Ford Focus", "petrol", 50.0);
        ElectricCar    tesla = new ElectricCar("Tesla Model 3", 85, 450);
        HybridCar      prius = new HybridCar("Toyota Prius", "petrol", 60);

        // individual calls
        System.out.println("--- Individual cars ---");
        ford.startEngine();
        ford.drive();
        System.out.println();
        tesla.startEngine();
        tesla.drive();
        System.out.println();
        prius.startEngine();
        prius.drive();

        // array of Car - polymorphism in action
        System.out.println("\n--- Polymorphic loop ---");
        Car[] cars = {ford, tesla, prius};
        for (Car car : cars) {
            car.startEngine();
            car.drive();
            System.out.println();
        }
    }
}
