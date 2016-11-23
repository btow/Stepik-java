package BasicJava.lesson_6_2_3;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Программа читает из System.in последовательность целых чисел,
 * разделенных пробелами, затем удаляет из неё все числа,
 * стоящие на четных позициях, и затем выводит получившуюся
 * последовательность в обратном порядке в System.out.
 * Created by btow on 22.11.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Set<Integer> set = new LinkedHashSet<Integer>();
        Scanner scanner = new Scanner(inputStream);

        scanner.forEachRemaining(s -> set.add(new Integer(s)));
        Iterator<Integer> iterator = set.iterator();
        boolean evenNumber = true;
        while (iterator.hasNext()) {
            iterator.next();
            if (evenNumber) {
                iterator.remove();
            }
            evenNumber = !evenNumber;
        }

        Integer[] integers = new Integer[set.size()];
        set.toArray(integers);

        for (int i = integers.length - 1; i > -1; i--) {
            System.out.print(integers[i]);
            if (i > 0) {
                System.out.print(" ");
            }
        }

    }

}
