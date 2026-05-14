package challenge6;

public class Account {

    private long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough funds. Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New balance: " + balance);
        }
    }
}
