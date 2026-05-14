package challenge6;

public class Main {

    public static void main(String[] args) {

        // --- Bank Account test ---
        Account account = new Account();
        account.setAccountNumber(123456L);
        account.setCustomerName("John Doe");
        account.setEmail("john@example.com");
        account.setPhoneNumber("+37212345678");
        account.setBalance(1000.0);

        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0); // should fail

        // --- Calculator test ---
        Calculator calculator = new Calculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println("add= " + calculator.getAdditionResult());
        System.out.println("subtract= " + calculator.getSubtractionResult());

        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        System.out.println("multiply= " + calculator.getMultiplicationResult());
        System.out.println("divide= " + calculator.getDivisionResult());

        // --- Customer test ---
        Customer c1 = new Customer("Alice", 2000.0, "alice@mail.com");
        Customer c2 = new Customer();
        Customer c3 = new Customer("Bob", "bob@mail.com");

        System.out.println(c1.getName() + " / " + c1.getCreditLimit() + " / " + c1.getEmail());
        System.out.println(c2.getName() + " / " + c2.getCreditLimit() + " / " + c2.getEmail());
        System.out.println(c3.getName() + " / " + c3.getCreditLimit() + " / " + c3.getEmail());
    }
}
