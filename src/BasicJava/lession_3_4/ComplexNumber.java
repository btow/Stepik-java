package BasicJava.lession_3_4;

/**
 * The program defines operations with complex numbers.
 * Created by btow on 27.10.2016.
 */
public class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber there = (ComplexNumber) o;

        if (Double.compare(there.re, re) != 0) return false;
        return Double.compare(there.im, im) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        Double doubleRe = re;
        Double doubleIm = im;

        String result = "The Complex number included:\n" +
                "a real part:      " + doubleRe.toString() + "\n" +
                "a imaginary part: " + doubleIm.toString() + "\n";

        return result;
    }
}
