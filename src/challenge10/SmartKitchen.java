package challenge10;

public class SmartKitchen {

    private CoffeeMaker brewMaster  = new CoffeeMaker();
    private DishWasher  dishWasher  = new DishWasher();
    private Refrigerator iceBox     = new Refrigerator();

    public CoffeeMaker getBrewMaster()  { return brewMaster; }
    public DishWasher  getDishWasher()  { return dishWasher; }
    public Refrigerator getIceBox()     { return iceBox; }

    public void addWater() {
        brewMaster.setHasWorkToDo(true);
    }

    public void pourMilk() {
        iceBox.setHasWorkToDo(true);
    }

    public void loadDishwasher() {
        dishWasher.setHasWorkToDo(true);
    }

    // set all three appliances at once
    public void setKitchenState(boolean coffeeMaker, boolean dishWasher, boolean refrigerator) {
        brewMaster.setHasWorkToDo(coffeeMaker);
        this.dishWasher.setHasWorkToDo(dishWasher);
        iceBox.setHasWorkToDo(refrigerator);
    }

    // delegates work to all appliances
    public void doKitchenWork() {
        brewMaster.brewCoffee();
        dishWasher.doDishes();
        iceBox.orderFood();
    }
}
