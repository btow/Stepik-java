package BasicJava.lesson_6_1;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Generic-класс Pair похож на Optional, но содержит пару элементов разных типов
 * и не запрещает элементам принимать значение null.
 * Created by btow on 21.11.2016.
 */
class Pair <T1, T2> {

    private final T1 first;
    private final T2 second;

    /**
     * Common instance for {@code empty()}.
     */
    private static final Pair<?, ?> EMPTY = new Pair();

    /**
     * Constructs an empty instance.
     *
     * @implNote Generally only one empty instance, {@link Pair#EMPTY},
     * should exist per VM.
     */
    private Pair () {
        this.first  = null;
        this.second = null;
    }

    /**
     * Returns an empty {@code Pair} instance.  No value is present for this
     * Pair.
     *
     * @apiNote Though it may be tempting to do so, avoid testing if an object
     * is empty by comparing with {@code ==} against instances returned by
     * {@code Pair.empty()}. There is no guarantee that it is a singleton.
     * @see Pair#firstIsPresent()
     * @see Pair#secondIsPresent()
     *
     * @param <T1> Type of the non-existent value
     * @param <T2> Type of the non-existent value
     * @return an empty {@code Pair}
     */
    private static<T1, T2> Pair<T1, T2> empty() {

        @SuppressWarnings("unchecked")
        Pair<T1, T2> t = (Pair<T1, T2>) EMPTY;
        return t;

    }

    /**
     * Constructs an instance with the value present.
     *
     * @param first the nullable value to be present
     * @param second the nullable value to be present
     */
    private Pair(T1 first, T2 second) {

        this.first  = first;
        this.second = second;

    }

    /**
     * Returns an {@code Pair} with the specified present nullable value.
     *
     * @param <T1> the class of the first value
     * @param <T2> the class of the second value
     * @param first the value to be present, which must be nullable
     * @param second the value to be present, which must be nullable
     * @return an {@code Pair} with the value present
     */
    public static <T1, T2> Pair <T1, T2> of(T1 first, T2 second) {

        return new Pair<>(first, second);

    }

    /**
     * If a value is present in this {@code Pair}, returns the value,
     * otherwise return {@code null}.
     *
     * @return the non-null or nullable value held by this {@code Pair}
     *
     * @see Pair#firstIsPresent()
     */
    public T1 getFirst() {

        return first;

    }

    /**
     * If a value is present in this {@code Pair}, returns the value,
     * otherwise return {@code null}.
     *
     * @return the non-null or nullable value held by this {@code Pair}
     *
     * @see Pair#secondIsPresent()
     */
    public T2 getSecond() {

        return second;

    }

    /**
     * Return {@code true} if there is a value of first present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value of first present, otherwise {@code false}
     */
    public boolean firstIsPresent() {
        return first != null;
    }

    /**
     * Return {@code true} if there is a value of first present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value of first present, otherwise {@code false}
     */
    public boolean secondIsPresent() {
        return second != null;
    }

    /**
     * If a values is present, invoke the specified consumers with the values,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if a value is present
     */
    public void ifPresent(BiConsumer<? super T1, ? super T2> consumer) {
        if ((first != null) & (second != null))
            consumer.accept(first, second);
    }

    /**
     * Indicates whether some other object is "equal to" this Paur. The
     * other object is considered equal if:
     * <ul>
     * <li>it is also an {@code Pair} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via {@code equals()}.
     * </ul>
     *
     * @param obj an object to be tested for equality
     * @return {code true} if the other object is "equal to" this object
     * otherwise {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<?, ?> other = (Pair<?,?>) obj;
        return (Objects.equals(first, other.first) & Objects.equals(second, other.second));
    }

    /**
     * Returns the sum of hash codes values of the present values, if any, or 0 (zero) if
     * no values is present.
     *
     * @return sum of hash codes values of the present values or 0 if no values is present
     */
    @Override
    public int hashCode() {

        return Objects.hashCode(first) + Objects.hashCode(second);

    }

}
