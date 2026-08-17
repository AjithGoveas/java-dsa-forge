package Recursion;

import java.util.Scanner;

public class Print1ToNBacktracking {
    // Print numbers from 1 to N using BACKTRACKING
    // We go DOWN from N to 1, but print while coming UP (unwinding)
    // -> printing is "backtracked" to happen in reverse order
    static void print(int i, int n) {
        if (i < 1) return;          // base case
        print(i - 1, n);            // go deeper FIRST (no printing yet)
        System.out.println(i);      // print on the way back up → 1, 2, ..., N
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        print(n, n);                // start from N, go down to 1
        in.close();
    }
}