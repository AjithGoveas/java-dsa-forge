package Recursion;

import java.util.Scanner;

public class SumOfN {
    // Sum of first N natural numbers using FUNCTIONAL recursion
    // The answer is built on the way UP — each call returns a bigger result
    static int sum(int n) {
        if (n == 0) return 0;       // base case → smallest answer (0)
        return n + sum(n - 1);      // combine on the way up → n + (n-1 + ... + 1)
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        System.out.println("Sum of 1 to " + n + " = " + sum(n));
        in.close();
    }
}