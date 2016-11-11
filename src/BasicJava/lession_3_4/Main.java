package BasicJava.lession_3_4;

/**
 * The program uses operations with complex numbers.
 * Created by btow on 27.10.2016.
 */
public class Main {

    public static void main(String[] args) {

        ComplexNumber a = new ComplexNumber(3, 3);
        ComplexNumber b = new ComplexNumber(3, 3);

        System.out.println("Variable a is " + a.toString());
        System.out.println("Variable b is " + b.toString());

        System.out.println("The result of compare of variables <i>a</i> and <i>b</i>: " + a.equals(b) + ".");
        System.out.println("The result of compare of hash codes of variables <i>a</i> and <i>b</i>: " + (a.hashCode() == b.hashCode()) + ".");

    }

}
