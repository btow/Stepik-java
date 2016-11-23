package BasicJava.lesson_2_1;

/**
 * A program returns the answer to the question: is it true that a + b = c?
 * Created by btow on 23.10.2016.
 */
public class ExerciseGradeMath {

    public static void main(String[] args) {



    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 1E-4;
    }

}
