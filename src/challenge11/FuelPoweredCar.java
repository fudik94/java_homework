package challenge11;

public class FuelPoweredCar extends Car {

    private String fuelType;
    private double tankSize;

    public FuelPoweredCar(String description, String fuelType, double tankSize) {
        super(description);
        this.fuelType = fuelType;
        this.tankSize = tankSize;
    }

    @Override
    public void startEngine() {
        System.out.println(description + ": igniting " + fuelType + " engine...");
        runEngine();
    }

    @Override
    public void drive() {
        System.out.println(description + ": driving on " + fuelType + "...");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("Fuel engine running (" + fuelType + ", tank: " + tankSize + "L) [" + getClass().getSimpleName() + "]");
    }
}
