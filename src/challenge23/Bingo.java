package challenge23;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bingo {

    public static void main(String[] args) {

        // B column 1-15, using rangeClosed
        Stream<String> bBalls = IntStream.rangeClosed(1, 15)
                .mapToObj(n -> "B" + n);

        // I column 16-30, using iterate
        Stream<String> iBalls = Stream.iterate(16, n -> n + 1)
                .limit(15)
                .map(n -> "I" + n);

        // N column 31-45, using Arrays.stream
        int[] nNumbers = {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
        Stream<String> nBalls = Arrays.stream(nNumbers)
                .mapToObj(n -> "N" + n);

        // G column 46-60, using Stream.of
        Stream<String> gBalls = Stream.of(46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60)
                .map(n -> "G" + n);

        // O column 61-75, using generate with a counter
        AtomicInteger counter = new AtomicInteger(61);
        Stream<String> oBalls = Stream.generate(() -> "O" + counter.getAndIncrement())
                .limit(15);

        // join all five streams together
        Stream<String> allBalls = Stream.concat(
                Stream.concat(
                        Stream.concat(bBalls, iBalls),
                        Stream.concat(nBalls, gBalls)),
                oBalls);

        // print each label
        allBalls.forEach(System.out::println);
    }
}
