package BasicJava.lesson_6_4_1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lesson 6.4 Stream API. The job number 1.
 * Created by btow on 23.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        IntStream stream = pseudoRandomStream(13);
        stream.limit(10)
              .forEach(System.out::print);

    }

    /**
     *  Алгоритм генерации чисел следующий:
     *  1. Берется какое-то начальное неотрицательное число (оно передаётся в метод).
     *  2. Первый элемент последовательности устанавливается равным этому числу.
     *  3. Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(R2n),
     *  где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа.
     *  Например, mid(123456)=345.
     * @param i - начальное неотрицательное число;
     * @return
     */
    private static IntStream pseudoRandomStream(int seed) {

        return IntStream.iterate(seed, n -> {
            String mr = String.valueOf(n * n);
            int endIndex    = (mr.length() < 1) ? 0 : mr.length() - 1,
                beginIndex  = (mr.length() < 4) ? 0 : endIndex - 3;
            return (endIndex - beginIndex == 0) ? 0 : Integer.parseInt(mr.substring(beginIndex, endIndex),10);
        });

    }

}
