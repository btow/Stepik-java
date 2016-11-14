package BasicJava.lession_5_3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Программа читает текст из System.in и выводит в System.out
 * сумму всех встреченных в тексте вещественных чисел
 * с точностью до шестого знака после запятой.
 *
 * Created by btow on 14.11.2016.
 */
public class Main {
    public static void main(String[] args) {

//        String[][] testsValues = {{"1 2 3", "6.000000"},
//                                  {"a1 b2 c3", "0.000000"},
//                                  {"-1e3\n" + "18 .111 11bbb", "-981.889000"}};

//        for (String[] testsValue : testsValues) {
        Double numberForOut = 0.000000;
        try (InputStream inputStream = System.in) {
            Scanner inputScanner = new Scanner(inputStream);
            while (inputScanner.hasNext()) {
                if (inputScanner.hasNextDouble()) {
                    numberForOut += inputScanner.nextDouble();
                } else {
                    inputScanner.next();
                }
            }
//            try {
//                Double numberForOut = readAsDoubleSum(testsValue[0]);

            System.out.printf("%.6f", numberForOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
//            System.out.println(". The correctly tests value is " + testsValue[1].toString() + ".");
//        }
    }

    /**
     * Числом считается последовательность символов,
     * отделенная от окружающего текста пробелами
     * или переводами строк и успешно разбираемая методом Double.parseDouble.
     * @param inputString - String;
     * @return Double
     */
    private static Double readAsDoubleSum(final String inputString) {
        Double resultDouble = 0.000000;
        String resultString;
        int beginIndex = 0; byte currentByte;
        boolean indexOfFirstWordsChar = true, wordHasNonNumeCharacter = false,
                wordHasOneCharacterE = false, wordHasOneCharacterDot = false;
        byte[] bytes = inputString.getBytes(), bytes1;
        for (int i = 0; i < bytes.length; i++) {
            currentByte = bytes[i];
            if ((currentByte > 47 & currentByte < 58) | (currentByte > 44 & currentByte < 47)) {
                if (indexOfFirstWordsChar) {
                    beginIndex = i;
                    indexOfFirstWordsChar = false;
                }
            } else if (currentByte == 32 | currentByte == 10) {
                indexOfFirstWordsChar = true;
                if (!wordHasNonNumeCharacter) {
                    bytes1 = Arrays.copyOfRange(bytes, beginIndex, i);
                    resultString = new String(bytes1, StandardCharsets.UTF_8);
                    resultDouble += Double.parseDouble(resultString);
                }
                wordHasNonNumeCharacter = false;
                wordHasOneCharacterE = false;
                wordHasOneCharacterDot = false;
            } else {
                if (currentByte == 101) {
                    if (!wordHasOneCharacterE) {
                        wordHasOneCharacterE = true;
                    } else {
                        wordHasNonNumeCharacter = true;
                    }
                } else if (currentByte == 46) {
                    if (!wordHasOneCharacterDot) {
                        wordHasOneCharacterDot = true;
                    } else {
                        wordHasNonNumeCharacter = true;
                    }
                } else {
                    wordHasNonNumeCharacter = true;
                }
            }
        }
        return resultDouble;
    }


}
