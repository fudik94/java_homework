package challenge3;

public class CurrencyConverter {

    public static double euroToCurrency(double amount, String currency) {

        return switch (currency) {
            case "USD" -> amount * 1.1;
            case "GBP" -> amount * 0.85;
            case "SEK" -> amount * 11.0;
            default -> -1;
        };
    }

    public static double currencyToEuro(double amount, String currency) {

        return switch (currency) {
            case "USD" -> amount / 1.1;
            case "GBP" -> amount / 0.85;
            case "SEK" -> amount / 11.0;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        System.out.println(euroToCurrency(100, "USD"));
        System.out.println(currencyToEuro(110, "USD"));
    }
}