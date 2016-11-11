package BasicJava.lession_2_1;

/**
 * The program changes the value of one bit of the specified integer on the opposite
 * Created by btow on 24.10.2016.
 */
public class FlipSettingsBit {

    public static void main(String[] args) {

        String stopText = "It's very good!";
        int testNumber = 1;

        int[][] testsValue = {{-1, 1, -2},
                            {0, 1, 1},
                            {47, 2, 45},
                            {100, 3, 96},
                            {200, 4, 192},
                            {400, 5, 384},
                            {450, 6, 482},
                            {1600, 9, 1856}
                            };

        for (int[] test : testsValue) {

            int result = flipBit(test[0],test[1]);
            if (test[2] != result) {

                stopText = "The test number " + testNumber + " isn't correct.";
                System.out.println(stopText);
                System.exit(-1);

            }

            testNumber++;

        }

    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {

        String bitRepresentationOfValue = Integer.toBinaryString((Integer)value);
        char[] bitsArrayOfValue = bitRepresentationOfValue.toCharArray();
        char[] fullBitsArrayOfValue = new char[32];


        for (byte i = 31; i > -1; i--) {

            int indexBitsArrayOfValue = bitsArrayOfValue.length - (32 - i);

            if ( indexBitsArrayOfValue > -1) {

                fullBitsArrayOfValue[i] = bitsArrayOfValue[indexBitsArrayOfValue];

            } else {

                fullBitsArrayOfValue[i] = '0';

            }

        }

        fullBitsArrayOfValue[fullBitsArrayOfValue.length - bitIndex]
                = (fullBitsArrayOfValue[fullBitsArrayOfValue.length - bitIndex] == '0') ? '1' : '0';

        int newVolume = 0;

        if (fullBitsArrayOfValue[0] == '1') {

            String result = String.copyValueOf(fullBitsArrayOfValue);
            result = result.replace("0", " "); //temp replace 0s
            result = result.replace("1", "0"); //replace 1s with 0s
            result = result.replace(" ", "1"); //put the 1s back in
            newVolume = (Integer.parseInt(result, 2) + 1) * -1;

        } else {

            newVolume = (int)Integer.valueOf(String.copyValueOf(fullBitsArrayOfValue), 2);

        }

            return newVolume; // put your implementation here
    }

}
