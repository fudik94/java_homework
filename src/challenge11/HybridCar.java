package challenge11;

public class HybridCar extends Car {

    private String fuelType;
    private int batteryLevel; // percent

    public HybridCar(String description, String fuelType, int batteryLevel) {
        super(description);
        this.fuelType = fuelType;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void startEngine() {
        System.out.println(description + ": starting hybrid system...");
        runEngine();
    }

    @Override
    public void drive() {
        System.out.println(description + ": switching between " + fuelType + " and battery...");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("Hybrid engine running (" + fuelType + " + battery: " + batteryLevel + "%) [" + getClass().getSimpleName() + "]");
    }
}
