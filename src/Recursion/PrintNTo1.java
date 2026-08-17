package Recursion;

import java.util.Scanner;

public class PrintNTo1 {
    // Print numbers from N to 1
    // Uses TAIL recursion — print happens BEFORE the recursive call (on the way down)
    static void print(int n) {
        if (n == 0) return;         // base case
        System.out.println(n);      // print going down → N, N-1, ..., 1
        print(n - 1);               // then recurse
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        print(n);
        in.close();
    }
}