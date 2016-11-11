package Algorithmes.lession_2_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by btow on 01.11.2016.
 */
public class SuperBigFibonacci {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int m = in.nextInt(), period = 0;
        int[] fib = new int[m * 6];
        fib[1] = 1;

        for (int step = 2; step < (m * 6); step++) {
            fib[step] = (fib[step - 2] + fib[step - 1])%m;
            if (fib[step] == 1 & fib[step - 1] == 0) {
                period = step - 1;
                break;
            }
        }

        System.out.println(fib[(int) (n%(long) period)]);
    }



}
