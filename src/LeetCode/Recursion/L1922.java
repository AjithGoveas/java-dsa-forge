package LeetCode.Recursion;

/// # [L1922: Count Good Numbers](https://leetcode.com/problems/count-good-numbers)
/// **Level:** Medium | **Pattern:** Binary exponentiation (modular) | **TC / SC:** O(log N) / O(log N)
/// **Trigger:** "count good digit strings", "even indices are even, odd indices are prime"
/// **Traps:** Large `n` (up to 10^15) requires `long`; modulo `10^9 + 7`; 5 choices per even index (0,2,4,6,8), 4 per odd index (2,3,5,7)
///
/// A digit string is **good** if the digits (**0-indexed**) at **even** indices are **even** and the digits at **odd** indices are **prime** (`2, 3, 5, or 7`).
///
/// For example, `"2582"` is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, `"3245"` is **not** good because `3` is at an even index but is not even.
///
/// Given an integer `n`, return the _total number of good digit strings_ of length `n`. Since the answer may be large, return it **modulo** `10^9 + 7`.
///
/// A digit string is a string consisting of digits `0` through `9` that may contain leading zeros.
///
/// **Example 1:**
/// ```txt
/// Input: n = 1
/// Output: 5
/// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
/// ```
/// **Example 2:**
/// ```txt
/// Input: n = 4
/// Output: 400
/// ```
/// **Example 3:**
/// ```txt
/// Input: n = 50
/// Output: 564908303
/// ```
///
/// **Constraints:**
///
/// - `1 <= n <= 10^15`

public class L1922 {
    static class Solution {
        static final long MOD = 1_000_000_007;

        private long modPow(long base, long exp) {
            if (exp == 0) return 1;
            long half = modPow(base, exp / 2);
            long result = (half * half) % MOD;
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            return result;
        }

        public int countGoodNumbers(long n) {
            long evenCount = (n + 1) / 2; // number of even positions
            long oddCount = n / 2;        // number of odd positions

            long ways = (modPow(5, evenCount) * modPow(4, oddCount)) % MOD;
            return (int) ways;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        long[] ns = {1, 4, 50};

        for (long n : ns) {
            System.out.println("Input: n = " + n);
            System.out.println("Output: " + s.countGoodNumbers(n));
        }
    }
}
