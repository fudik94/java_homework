package challenge16;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<ProductForSale> products = new ArrayList<>();
    private List<OrderItem> order = new ArrayList<>();

    public void addProduct(ProductForSale product) {
        products.add(product);
    }

    public void showProducts() {
        for (ProductForSale p : products) {
            System.out.println("----------------------------------");
            p.showDetails();
            System.out.println();
        }
    }

    public void addToOrder(int quantity, ProductForSale product) {
        order.add(new OrderItem(quantity, product));
    }

    public void clearOrder() {
        order.clear();
    }

    public void printOrder() {
        double total = 0;
        for (OrderItem item : order) {
            item.getProduct().printPricedItem(item.getQuantity());
            total += item.getProduct().getSalesPrice(item.getQuantity());
        }
        System.out.printf("Total sales: %.1f euro.%n", total);
    }

    public static void main(String[] args) {

        Store store = new Store();

        // create products
        ComputerProduct desktop  = new ComputerProduct("desktop", 700.0, "Desktop Computer");
        ComputerProduct laptop   = new ComputerProduct("laptop",  900.0, "Laptop");
        FurnitureProduct desk    = new FurnitureProduct("desk",   100.0, "Computer Desk");
        FurnitureProduct chair   = new FurnitureProduct("chair",  200.0, "Reading Chair");

        store.addProduct(desktop);
        store.addProduct(laptop);
        store.addProduct(desk);
        store.addProduct(chair);

        // show all products
        store.showProducts();

        // Order 1: 2 laptops + 1 desktop
        System.out.println("Order 1");
        store.addToOrder(2, laptop);
        store.addToOrder(1, desktop);
        store.printOrder();

        // Order 2: 5 chairs + 1 desktop + 1 desk
        store.clearOrder();
        System.out.println("\nOrder 2");
        store.addToOrder(5, chair);
        store.addToOrder(1, desktop);
        store.addToOrder(1, desk);
        store.printOrder();
    }
}
