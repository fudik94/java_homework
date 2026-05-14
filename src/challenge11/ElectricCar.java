package challenge11;

public class ElectricCar extends Car {

    private int batteryLevel; // percent
    private int range;        // km

    public ElectricCar(String description, int batteryLevel, int range) {
        super(description);
        this.batteryLevel = batteryLevel;
        this.range = range;
    }

    @Override
    public void startEngine() {
        System.out.println(description + ": powering up electric motor...");
        runEngine();
    }

    @Override
    public void drive() {
        System.out.println(description + ": driving silently on battery...");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.println("Electric motor running (battery: " + batteryLevel + "%, range: " + range + "km) [" + getClass().getSimpleName() + "]");
    }
}
