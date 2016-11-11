package BasicJava.lession_5_3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * The program reads data from an InputStream and converts
 * them to a string using the specified encoding.
 * Created by btow on 11.11.2016.
 */
public class InputStreamToString {

    public static void main(String[] args) {
        Charset charset = StandardCharsets.US_ASCII;
        try (InputStream inputStream = System.in) {
            String textForOut = readAsString(inputStream, charset);
            System.out.println(textForOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        int resultsRead = -1, beginIndex = 0;
        byte[] bytes = new byte[1024], bytes1 = null;
        do {
            resultsRead = inputStream.read(bytes);
            if (resultsRead > -1) {
                bytes1 = new byte[resultsRead + beginIndex];
                for (int i = beginIndex; i < (beginIndex + resultsRead); i++) {
                    bytes1[i] = bytes[i - beginIndex];
                }
                beginIndex += resultsRead;
            }
        } while (resultsRead > -1);

//        byte[] bytes1 = {48, 49, 50, 51};

        char[] chars = new char[bytes1.length];
        String textForOut = "";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes1);
        try (Reader reader = new InputStreamReader(byteArrayInputStream, charset)) {
            resultsRead = reader.read(chars);
            if (resultsRead != -1) {
                for (char character : chars) {
                    textForOut += ((Character) character).toString();
                }
            }
        } catch (IOException e) {
            throw e;
        }

        return textForOut;
    }
}
