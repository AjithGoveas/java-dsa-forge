package Recursion;

import java.util.Scanner;

public class PrintNTo1Backtracking {
    // Print numbers from N to 1 using BACKTRACKING
    // We go UP from 1 to N, but print while coming UP (unwinding)
    // -> printing is "backtracked" to happen in reverse order
    static void print(int i, int n) {
        if (i > n) return;          // base case
        print(i + 1, n);            // go deeper FIRST (no printing yet)
        System.out.println(i);      // print on the way back up → N, ..., 2, 1
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        print(1, n);                // start from 1, go up to N
        in.close();
    }
}