package Algorithmes.lession_2_2;

import java.util.Scanner;

/**
 *
 * Created by btow on 01.11.2016.
 */
public class Fibonacci {
    public static void main(String[] args) {
        // put your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() + 1;
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[n - 1]);
    }
}
