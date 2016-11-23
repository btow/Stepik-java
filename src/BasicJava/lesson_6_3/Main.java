package BasicJava.lesson_6_3;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Дан предикат condition и две функции ifTrue и ifFalse.
 * Метод ternaryOperator, который из них строит новую функцию,
 * возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
 * Created by btow on 22.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

    }

    /**
     * Результирующая функция для нулевых ссылок на String возвращает 0,
     * а для ненулевых ссылок - длину строки.
     * @param condition
     * @param ifTrue
     * @param ifFalse
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (x) -> (condition.test(x)) ? ifTrue.apply(x) : ifFalse.apply(x); // your implementation here

    }

}
