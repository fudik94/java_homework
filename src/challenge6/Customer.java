package challenge6;

public class Customer {

    private String name;
    private double creditLimit;
    private String email;

    // all three fields
    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    // no-args constructor
    public Customer() {
        this("Default Name", 500.0, "default@email.com");
    }

    // name and email only
    public Customer(String name, String email) {
        this(name, 1000.0, email);
    }

    public String getName() { return name; }
    public double getCreditLimit() { return creditLimit; }
    public String getEmail() { return email; }
}
