package challenge10;

public class Main {

    public static void main(String[] args) {

        SmartKitchen kitchen = new SmartKitchen();

        // way 1: access each appliance directly via getter
        System.out.println("--- Direct appliance access ---");
        kitchen.addWater();
        kitchen.pourMilk();
        kitchen.loadDishwasher();

        kitchen.getBrewMaster().brewCoffee();
        kitchen.getIceBox().orderFood();
        kitchen.getDishWasher().doDishes();

        // way 2: delegate all work through doKitchenWork()
        System.out.println("\n--- Using doKitchenWork() ---");
        kitchen.setKitchenState(true, true, true);
        kitchen.doKitchenWork();

        // nothing should happen - all flags are false now
        System.out.println("\n--- No work left ---");
        kitchen.doKitchenWork();
    }
}
