package Recursion;

import java.util.Scanner;

/// # Factorial of N
/// **Level:** Easy | **Pattern:** Recursion (functional, linear) | **TC / SC:** O(N) / O(N)
/// **Trigger:** "factorial", "n!", "multiply descending", "permutations"
/// **Traps:** `0! = 1` (not 0); overflow for large n (int overflows ~13!, long overflows ~21!); negative input undefined
///
/// Return `n!` (n factorial) where `0! = 1` and `n! = n * (n-1)!` for `n >= 1`.
///
/// **Execution trace (n=4):**
/// ```
/// factorial(4)
/// └─ 4 * factorial(3)
///    └─ 3 * factorial(2)
///       └─ 2 * factorial(1)
///          └─ 1            ← base case
///       → 2 * 1 = 2
///    → 3 * 2 = 6
/// → 4 * 6 = 24
/// ```
/// The answer is built on the way UP — each call multiplies its `n` with the result from below.
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