package BasicJava.lesson_6_4_3;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Программа читаюет из System.in текст в кодировке UTF-8,
 * подсчитывающую в нем частоту появления слов, и в конце
 * выводящую 10 наиболее часто встречающихся слов.
 * Словом считается любая непрерывная последовательность
 * символов, состоящая только из букв и цифр. Например, в строке
 * "Мама мыла раму 33 раза!" ровно пять слов:
 * "Мама", "мыла", "раму", "33" и "раза".
 * Подсчет слов выполняется без учета регистра, т.е.
 * "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Вывод слов в нижнем регистре.
 * Если в тексте меньше 10 уникальных слов,
 * то выводится сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту,
 * т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой
 * в лексикографическом порядке.
 * Created by btow on 24.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        InputStream inputStream = System.in;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            List<String> inputStringList = createListFromString(bufferedReader
                    .readLine()
                    .toLowerCase());
            Map<String, Long> resultMap = new LinkedHashMap<>();

            // Creation a map with keys and value
            Map<String, Long> preparingMap = inputStringList
                    .stream()
                    .collect(
                            Collectors.groupingBy(
                                    Function.identity(),
                                    Collectors.counting()
                            )
                    );


            //Sort a map on the value (primary) and on the keys (secondary) and add to finalMap
            preparingMap.entrySet()
                    .stream()
                    .sorted(Map.Entry
                            .<String, Long>comparingByValue()
                            .reversed()
                            .thenComparing(
                                    Map.Entry.comparingByKey())
                    )
                    .limit(10)
                    .forEachOrdered(
                            e -> resultMap
                                    .put(e.getKey(), e.getValue())
                    );

            resultMap.entrySet().forEach(e -> System.out.println(e.getKey()));

        } catch (IOException | InvalidArgumentException e) {
            e.printStackTrace();
        }

    }

    private static List<String> createListFromString(final String inputString) throws InvalidArgumentException {

        if (inputString.length() == 0) {
            throw new InvalidArgumentException(new String[]{"The input string is empty"});
        }

        char[] chars = inputString.toCharArray();
        boolean setNewBeginWord = true;
        int beginOfWord = 0;
        List<String> listString = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            beginOfWord = setNewBeginWord ? i : beginOfWord;
            setNewBeginWord = false;

            if (!Character.isLetter(currentChar)
                    & !Character.isDigit(currentChar)) {
                setNewBeginWord = true;

                if (i - beginOfWord == 0) {
                    continue;
                } else {
                    listString.add(String.copyValueOf(chars, beginOfWord, i - beginOfWord));
                }

            } else if (i == chars.length - 1) {
                listString.add(String.copyValueOf(chars, beginOfWord, chars.length - beginOfWord));
            }

        }

        return listString;

    }

}
