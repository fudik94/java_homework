package challenge16;

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("%d items at %.1f euro each (type: %s, description: %s)%n",
                quantity, price, type, description);
    }

    public abstract void showDetails();
}
