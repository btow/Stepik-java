package Algorithmes.lession_2_3;

import java.util.Scanner;

/**
 * The class searches for the greatest common divisor
 * using the Euclidean algorithm.
 * Created by btow on 03.11.2016.
 */
public class EvclidGCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        System.out.println(evclidGCD(a,b));
    }

    private static int evclidGCD(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else if (a >= b) {
            return evclidGCD(a%b, b);
        }
        return evclidGCD(a, b%a);
    }
}
