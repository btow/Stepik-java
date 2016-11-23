package BasicJava.lesson_5_3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * The program reads data from an InputStream and converts
 * them to a string using the specified encoding.
 * Created by btow on 11.11.2016.
 */
public class InputStreamToString {

    public static void main(String[] args) {
        Charset charset = StandardCharsets.US_ASCII;
        try (InputStream inputStream = new ByteArrayInputStream(new byte[] {48, 49, 50, 51, 13, 10})) {
            String textForOut = readAsString(inputStream, charset);
            System.out.println(textForOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        int resultsRead, deltaStepOfArray = 512, beginIndex = 0, endIndex = deltaStepOfArray;
        byte[] bytes = new byte[endIndex], bytes1;
        do {
            resultsRead = inputStream.read();
            if (resultsRead > -1) {
                bytes[beginIndex] = (byte) resultsRead;
                beginIndex++;
                if (beginIndex == endIndex) {
                    endIndex += deltaStepOfArray;
                    bytes1 = Arrays.copyOf(bytes,endIndex);
                    bytes = bytes1;
                }
            }
        } while (resultsRead > -1);

        bytes1 = Arrays.copyOf(bytes, beginIndex);

        return new String(bytes1, charset);
    }
}
