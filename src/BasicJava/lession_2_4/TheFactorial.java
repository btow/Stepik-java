package BasicJava.lession_2_4;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * The program calculates a factorial.
 * Created by btow on 25.10.2016.
 */
public class TheFactorial {

    public static void main(String[] args) {

        int[] testsValues = {
                1,
                3,
                6,
                11,
                28
        };

        ArrayList testsResults = new ArrayList();
        testsResults.add(new BigInteger("1"));
        testsResults.add(new BigInteger("6"));
        testsResults.add(new BigInteger("720"));
        testsResults.add(new BigInteger("39916800"));
        testsResults.add(new BigInteger("304888344611713860501504000000"));

        int testsNumber = 1;

        try {
            for (int testsValue : testsValues) {

                BigInteger testsResult = factorial(testsValue);

                if (!testsResult.equals(testsResults.get(testsNumber - 1))) {

                    String stopText = "The test number " + testsNumber + " isn't correct!";
                    System.out.println(stopText);
                    System.exit(-1);

                } else {

                    String stopText = "The test number " + testsNumber + " is in complied!";
                    System.out.println(stopText);

                }

                testsNumber++;

            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) throws IllegalArgumentException {

        BigInteger result = new BigInteger("1");

        if (value < 1) {
            throw new IllegalArgumentException("The value less then one.");
        }

        for (int i = 1; i <= value; i++) {

            BigInteger multiplier = new BigInteger(Integer.valueOf(i).toString());
            result = result.multiply(multiplier);

        }

        return result; // your implementation here
    }

}
