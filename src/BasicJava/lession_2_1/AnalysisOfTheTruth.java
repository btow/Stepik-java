package BasicJava.lession_2_1;

/**
 * the program returns the value <code>"true"</code> only if any pair of input parameters equal to <code>"true"</code>.
 * Created by btow on 21.10.2016.
 */
public class AnalysisOfTheTruth {

    public static void main(String[] args) {

        String stopTest = "It's very good!";
        int numberCurrentTest = 1;

        boolean[][] testValue = {{false, false, false, false, false},
                                 {false, true, false, false, false},
                                 {false, false, true, false, false},
                                 {false, false, false, true, false},
                                 {false, false, false, false, true},
                                 {true, true, true, false, false},
                                 {true, true, false, true, false},
                                 {true, true, false, false, true},
                                 {true, false, true, true, false},
                                 {true, false, true, false, true},
                                 {true, false, false, true, true},
                                 {false, true, true, true, false},
                                 {false, true, true, false, true},
                                 {false, true, false, true, true},
                                 {false, false, true, true, true},
                                 {false, true, true, true, true}};

        for (boolean[] currentTest : testValue) {

            if (currentTest[0]!= booleanExpression(currentTest[1],
                                                    currentTest[2],
                                                    currentTest[3],
                                                    currentTest[4])) {
                stopTest = "The test number " + numberCurrentTest + " isn't correct.";
                System.out.println(stopTest);
                System.exit(-1);
            }

            numberCurrentTest++;
        }

    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        boolean result = false;
        if (((a & b) & (!c & !d))
                | ((a & c) & (!b & !d))
                | ((a & d) & (!b & !c))
                | ((b & c) & (!a & !d))
                | ((b & d) & (!a & !c))
                | ((c & d) & (!a & !b))) {
            result = true;
        }
        return result;
    }
}
