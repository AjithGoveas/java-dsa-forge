package LeetCode.Recursion;

/// # [L0050: Pow(x, n)](https://leetcode.com/problems/powx-n)
/// **Level:** Medium | **Pattern:** Binary exponentiation (divide & conquer) | **TC / SC:** O(log N) / O(log N)
/// **Trigger:** "calculate x raised to the power n", "exponentiation", "pow(x, n)"
/// **Traps:** Negative exponent; recursion depth; overflow from large n
///
/// Implement `pow(x, n)`, which calculates `x` raised to the power `n` (i.e., `x^n`).
///
/// **Example 1:**
/// ```txt
/// Input: x = 2.00000, n = 10
/// Output: 1024.00000
/// ```
/// **Example 2:**
/// ```txt
/// Input: x = 2.10000, n = 3
/// Output: 9.26100
/// ```
/// **Example 3:**
/// ```txt
/// Input: x = 2.00000, n = -2
/// Output: 0.25000
/// Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
/// ```
///
/// **Constraints:**
///
/// - `-100.0 < x < 100.0`
/// - `-2^31 <= n <= 2^31 - 1`
/// - `n` is an integer.
/// - Either `x` is not zero or `n > 0`.
/// - `-10^4 <= x^n <= 10^4`

public class L0050 {
    static class Solution {
        public double myPow(double x, long n) {
            if(n < 0)
                return 1.0 / myPow(x, -n);

            if(n == 0) return 1;
            if(n == 1) return x;

            if(n%2 == 0) return myPow(x*x, n/2);
            else return x * myPow(x, n-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        double[] xs = {2.0, 2.1, 2.0};
        long[] ns = {10, 3, -2};

        for (int i = 0; i < xs.length; i++) {
            System.out.println("Input: x = " + xs[i] + ", n = " + ns[i]);
            System.out.println("Output: " + s.myPow(xs[i], ns[i]));
        }
    }
}
