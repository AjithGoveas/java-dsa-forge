package Recursion;

import java.util.Scanner;

public class Print1ToN {
    // Print numbers from 1 to N
    // Uses HEAD recursion — print happens AFTER the recursive call (on the way up)
    static void print(int n) {
        if (n == 0) return;         // base case
        print(n - 1);               // go deeper FIRST
        System.out.println(n);      // print while unwinding → 1, 2, 3, ..., N
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        print(n);
        in.close();
    }
}