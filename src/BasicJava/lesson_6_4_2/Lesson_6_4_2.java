package BasicJava.lesson_6_4_2;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание №2.
 * Created by btow on 23.11.2016.
 */
public class Lesson_6_4_2 {

    public static void main(String[] args) {
        findMinMax(new ArrayList<Integer>().stream(),
                (o1, o2) -> o1 - o2,
                (o1, o2) -> {
                    assert o1 == null && o2 == null : "Null expected";
                }
        );
    }

    /**
     * Метод находит в стриме минимальный и максимальный элементы
     * в соответствии порядком, заданным Comparator'ом.
     * Найденные минимальный и максимальный элементы передаются
     * в minMaxConsumer следующим образом:
     * minMaxConsumer.accept(min, max);
     * Если стрим не содержит элементов, то вызовается
     * minMaxConsumer.accept(null, null);
     *
     * @param stream         - входной поток
     * @param order          - функция упорядочивания
     * @param minMaxConsumer - функция обработки минимума и максимума
     * @param <T>            - тип данных.
     */
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        Collection<? extends T> forFindMinMax = stream.collect(Collectors.toList());
        Optional<? extends T> minOpt = forFindMinMax.stream().min(order);
        Optional<? extends T> maxOpt = forFindMinMax.stream().max(order);
        T min = null, max = null;
        if (minOpt.isPresent() & maxOpt.isPresent()) {
            min = minOpt.get();
            max = maxOpt.get();
        }
        minMaxConsumer.accept(min, max);
    }

}
