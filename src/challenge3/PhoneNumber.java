package challenge3;

public class PhoneNumber {

    public static String getCountry(String number) {

        if (number.startsWith("+372")) {
            return "Estonia";
        }

        return "Unknown country";
    }

    public static String getCountry(long number) {
        return getCountry(String.valueOf(number));
    }

    public static void main(String[] args) {
        System.out.println(getCountry("+37212345678"));
        System.out.println(getCountry(37212345678L));
    }
}