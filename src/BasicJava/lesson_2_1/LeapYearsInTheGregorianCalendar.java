package BasicJava.lesson_2_1;

/**
 * The program Leap years in the Gregorian calendar.
 * Created by btow on 21.10.2016.
 */
public class LeapYearsInTheGregorianCalendar {

    public static void main(String[] args) {

        String stopText = "It's very good!";
        int testNumber = 1;

        int[][] testsValue = {{1, 0},
                              {4, 1},
                              {100, 24},
                              {200, 48},
                              {400, 97},
                              {450, 109},
                              {1600, 388}};

        for (int[] test : testsValue) {

            int result = leapYearCount(test[0]);
            if (test[1] != result) {

                stopText = "The test number " + testNumber + " isn't correct.";
                System.out.println(stopText);
                System.exit(-1);

            }

            testNumber++;

        }

    }

    /**
     * The method returns the number of leap years that are available in the range from 1 to specified in the ad.
     * @param year - the upper value of the range of years;
     * @return the numberOfYears - the number of years.
     */
    public static int leapYearCount(int year) {

        int numberOf400Yars = 0, numberOf100Yars = 0, numberOfLeapYears = 0;

        if (year >= 400) {
            numberOf400Yars = year / 400;
            year %= 400;
        }

        if (year >= 100) {
            numberOf100Yars = year / 100;
            year %= 100;
        }

        if (year < 100) {
            numberOfLeapYears = year / 4;
        }

        return numberOfLeapYears = numberOfLeapYears + (numberOf100Yars + numberOf400Yars * 4) * 24 + numberOf400Yars;
    }
}
