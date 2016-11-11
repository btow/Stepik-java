package BasicJava.lession_3_5;

import java.util.function.DoubleUnaryOperator;

/**
 * Numerical integration of a given function on a given interval.
 * Created by btow on 27.10.2016.
 */
public class NumericalIntegration {

    /**
     * A method that performs numerical integration of a given function on
     * a given interval by the formula of left rectangles.
     * @param f - expanded function set to the object implementing
     *          the interface java.util.function.DoubleUnaryOperator;
     * @param a - the beginning of the range set up numerical value of the type "double";
     * @param b - the end of the range set up numerical value of the type "double";
     * @return - the numerical value of the integral of the type "double".
     */
    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double result = 0, grid = 0, currentA  = a, currentB = b, currentDelta = 0, delta = 1E-100;
        int stepsNumber;

        if (a >= b) {
            System.exit(-1);
        }

        do {
            currentB = currentA + (currentB - currentA) * 0.5;
            grid = currentB - currentA;
            currentDelta = f.applyAsDouble(currentA) - f.applyAsDouble(currentB);
        } while (currentDelta > delta);

        System.out.println("delta = " + ((Double)delta).toString());
        System.out.println("grid = " + ((Double)grid).toString());

        stepsNumber = (int)((b - a) / grid); //without a right border

        for (int i = 0; i < stepsNumber; i++) {
            result += f.applyAsDouble(a + grid * i);
        }

        return result *= grid;
    }

    public static void main(String[] args) {

        System.out.println(((Double) integrate(x -> 1, 0, 10)).toString());

    }

}
