package challenge4;

public class DigitSum {

    public static int sumDigits(int number) {
        if (number < 0) return -1; // invalid

        if (number < 10) return number; // single digit

        int sum = 0;
        while (number > 0) {
            sum += number % 10; // last digit
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(125));  // 8
        System.out.println(sumDigits(-5));   // -1
        System.out.println(sumDigits(7));    // 7
        System.out.println(sumDigits(999));  // 27
    }
}
