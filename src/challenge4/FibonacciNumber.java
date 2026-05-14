package challenge4;

public class FibonacciNumber {

    public static boolean isFibonacci(int number) {
        if (number < 0) return false;

        int a = 0;
        int b = 1;

        // generate until we reach or pass the number
        while (a < number) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return a == number;
    }

    public static void main(String[] args) {
        System.out.println(isFibonacci(8));   // true
        System.out.println(isFibonacci(10));  // false
        System.out.println(isFibonacci(13));  // true
        System.out.println(isFibonacci(0));   // true
    }
}
