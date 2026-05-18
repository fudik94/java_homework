package challenge16;

public class FurnitureProduct extends ProductForSale {

    public FurnitureProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + " was manufactured in Estonia");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
