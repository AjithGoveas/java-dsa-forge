package Recursion;

import java.util.Scanner;

public class Factorial {
    // Factorial of N (N!) using FUNCTIONAL recursion
    // The answer is built on the way UP — each call returns a bigger result
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;     // base case → smallest answer (1)
        return n * factorial(n - 1);        // combine on the way up → n * (n-1)!
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        System.out.println(n + "! = " + factorial(n));
        in.close();
    }
}