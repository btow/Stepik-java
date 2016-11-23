package BasicJava.lesson_6_4_1;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Lesson 6.4 Stream API. The job number 1.
 * Created by btow on 23.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        Stream<BigInteger> stream = pseudoRandomStream(13);
        stream.map((bI) -> bI.toString().concat(" ")).limit(10).forEach(System.out::print);

    }

    private static Stream<BigInteger> pseudoRandomStream(int i) {

        Stream<BigInteger> result = Stream.iterate(i,i -> i * i, )

        return result;

    }

}
