package Recursion;

import java.util.Scanner;

/// # Fibonacci Number
/// **Level:** Easy | **Pattern:** Recursion (functional, branching) | **TC / SC:** O(2^N) / O(N)
/// **Trigger:** "fibonacci", "branching recursion", "repeated subproblems", "overlapping calls"
/// **Traps:** O(2^N) naive time — same subproblems recomputed many times; stack overflow for large n; `fib(0)=0, fib(1)=1`
///
/// Return the Nth Fibonacci number where `fib(0) = 0`, `fib(1) = 1`,
/// and `fib(n) = fib(n-1) + fib(n-2)` for `n > 1`.
///
/// **Recursion Tree (n=4):**
/// ```
/// fib(4)
/// ├─ fib(3)
/// │  ├─ fib(2)
/// │  │  ├─ fib(1) → 1
/// │  │  └─ fib(0) → 0
/// │  └─ fib(1) → 1
/// └─ fib(2)      ← duplicate!
///    ├─ fib(1) → 1
///    └─ fib(0) → 0
/// ```
/// Notice `fib(2)` is computed twice — this is why naive recursion is O(2^N).
/// A memoized or iterative approach reduces this to O(N).
public class Fibonacci {
    // Fibonacci number using FUNCTIONAL recursion
    // fib(n) = fib(n-1) + fib(n-2) — builds the answer on the way UP
    // Naive: O(2^n) time, O(n) stack — same subproblems solved repeatedly
    static int fib(int n) {
        if (n <= 1) return n;               // base case → fib(0)=0, fib(1)=1
        return fib(n - 1) + fib(n - 2);    // combine on the way up
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = in.nextInt();

        System.out.println("fib(" + n + ") = " + fib(n));
        in.close();
    }
}