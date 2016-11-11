package BasicJava.lession_4_1;

/**
 *
 * Created by btow on 31.10.2016.
 */
public class A {

    public static void main(String[] args) {

        /**
         * Calling the collapse of the performance in true compilation.
         */
//        Object b = new Object();
//        A a = (A)b;

        /**
         * Test of method sqrt()
         */
//        double x = -8.0;
//
//        try {
//            System.out.println("Calling the method \"sqrt()\" for negative number " + x + ": " + sqrt(x));
//        } catch (IllegalArgumentException e) {
//            System.out.println(e);
//        }
    }

    public static double sqrt(double x) throws IllegalArgumentException {

        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }

        return Math.sqrt(x); // your implementation here
    }

}
