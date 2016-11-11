package BasicJava.lession_2_2;

/**
 * The software checks the numbers on their compliance with the powers of two.
 * Created by btow on 25.10.2016.
 */
public class PowerOfTwo {

    public static void main(String[] args) {

        int[] testsValues = {0, 1, -2};
        boolean[] testsResults = {false, true, true};

        boolean resultOfTest = false;
        String stopText = "It's very good!";
        int numberTest = 1;

        for (int testValue : testsValues) {

            resultOfTest = isPowerOfTwo(testValue);

            if (resultOfTest != testsResults[numberTest - 1]) {

                stopText = "The test " + numberTest + " isn't correct.";
                System.out.println(stopText);
                System.exit(-1);

            } else {

                stopText = "The test " + numberTest + " it's complied.";
                System.out.println(stopText);

            }

            numberTest++;
        }

    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {

        int absValue = Math.abs(value);

        return ((absValue != 0)) & ((absValue & (~absValue + 1)) == absValue); // you implementation here
    }

}
