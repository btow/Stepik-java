package BasicJava.lession_2_2;

/**
 * The program performs conversion of Unicode characters
 * Created by btow on 24.10.2016.
 */
public class ConvertUnicode {

    public static void main(String[] args) {

        int[] testsValue = {-100, -75, -52, -29, -4, 29, 32, 59, 78, 111};
        char[] testResult = {'\uFFF7', '\u0011', '(', '?', 'X', 'y', '|', '\u0097', 'ª', 'Ë'};

        int index = 0;
        String stopText = "It's very good!";

        for (int testValue : testsValue) {

            if (testResult[index] != charExpression(testValue)) {

                stopText = "Test number " + index + " isn't correct.";
                System.out.println(stopText);

            }

            index++;

        }

    }

    public static char charExpression(int a) {

        char startChar = '\\';
        int codeStartChar = startChar;
        int codeResultChar = codeStartChar + a;

        if (codeResultChar < 0) {codeResultChar += 65535;}

        char resultChar = Character.toChars(codeResultChar)[0];
        return resultChar;
    }

}