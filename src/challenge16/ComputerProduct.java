package challenge16;

public class ComputerProduct extends ProductForSale {

    public ComputerProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + " is a modern computer");
        System.out.println("The price of the piece is " + price + " euro.");
        System.out.println(description);
    }
}
