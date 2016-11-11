package BasicJava.lession_1_3;

import java.security.MessageDigest;
/**
 * A program from stepik.org
 * Created by btow on 21.10.2016.
 */
public class Quiz {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }
    }
}
