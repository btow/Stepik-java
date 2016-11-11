package Algorithmes.lession_2_2;

import java.util.Scanner;

/**
 *
 * Created by btow on 01.11.2016.
 */
public class BigFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() + 1;
        int[] lastDigitsNumFib = new int[n];
        lastDigitsNumFib[0] = 0;
        lastDigitsNumFib[1] = 1;
        for (int i = 2; i < n; i++) {
            lastDigitsNumFib[i] = (lastDigitsNumFib[i - 1] + lastDigitsNumFib[i - 2])%10;
        }
        System.out.println(lastDigitsNumFib[n - 1]);
    }
}
