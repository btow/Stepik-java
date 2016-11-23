package BasicJava.lesson_2_4;

import java.util.Arrays;

/**
 * The program merges the sorted arrays.
 * Created by btow on 25.10.2016.
 */
public class MergeSortedArrays {

    public static void main(String[] args) {

        int[][][] testsValues = {
                {{1, 3, 4, 4}, {3, 6, 7}, {1, 3, 3, 4, 4, 6, 7}},
                {{0, 2, 2}, {1, 3}, {0, 1, 2, 2, 3}},
                {{0, 2, 4, 6}, {1, 3, 5}, {0, 1, 2, 3, 4, 5, 6}}
        };

        int testsNumber = 1;

        for (int[][] testsValue : testsValues) {

            int[] testResult = mergeArrays(testsValue[0],testsValue[1]);

            if (!Arrays.equals(testResult,testsValue[2])) {

                String stopText = "The test number " + testsNumber + " isn't correct.";
                System.out.println(stopText);
                System.exit(-1);

            } else {

                String stopText = "The test number " + testsNumber + " is in complete.";
                System.out.println(stopText);

            }

            testsNumber++;

        }

    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {

        int a1Length = a1.length, a2Length = a2.length, resultLength = a1Length + a2Length;
        int[] results = new int[resultLength];
        int i = 0, j = 0;
        boolean a1LessA2, a2LessA1;

        for (int x = 0; x < resultLength; x++) {

            if (i < a1Length & j < a2Length) {

                a1LessA2 = a1[i] < a2[j];
                a2LessA1 = a2[j] <= a1[i];

            } else {

                a1LessA2 = false;
                a2LessA1 = false;

            }

            if (a1LessA2 || ((i < a1Length) & (j >= a2Length))) {

                results[x] = a1[i];
                ++i;

            } else if (a2LessA1 || ((j < a2Length) & (i >= a1Length))){

                results[x] = a2[j];
                ++j;

            }

        }

        return results; // your implementation here
    }

}
