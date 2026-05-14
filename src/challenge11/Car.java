package challenge11;

public class Car {

    protected String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println(description + ": starting engine...");
        runEngine();
    }

    public void drive() {
        System.out.println(description + ": driving...");
        runEngine();
    }

    protected void runEngine() {
        // prints actual runtime type - shows polymorphism in action
        System.out.println("Engine running [" + getClass().getSimpleName() + "]");
    }
}
