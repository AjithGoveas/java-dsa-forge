package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

/// # [L1781: Sum of Beauty of All Substrings](https://leetcode.com/problems/sum-of-beauty-of-all-substrings)
/// ## Level - Medium
/// The **beauty** of a string is the difference in frequencies between the most frequent and least frequent characters.
///
/// - For example, the beauty of `"abaacc"` is `3 - 1 = 2`.
/// Given a string s, return _the sum of **beauty** of all of its substrings_.
///
/// **Example 1:**
/// ```txt
/// Input: s = "aabcb"
/// Output: 5
/// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "aabcbaa"
/// Output: 17
/// ```
///
/// **Constraints:**
///
/// - `1 <= s.length <= 500`
/// - `s` consists of only lowercase English letters.

public class L1781 {
    static class Solution {
        public int beautySum(String s) {
            // length
            int len = s.length();
            // initial sum
            int sum = 0;

            for (int i = 0; i < len; i++) {
                // Create a local map
                Map<Character, Integer> freq = new HashMap<>();

                for (int j = i; j < len; j++) {
                    // increase frequency
                    freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                    int max_i = Integer.MIN_VALUE;
                    int min_i = Integer.MAX_VALUE;

                    // Calculate max and min frequency
                    for (int val : freq.values()) {
                        max_i = Math.max(max_i, val);
                        min_i = Math.min(min_i, val);
                    }

                    // Add the difference max_i - min_i to sum
                    sum += (max_i - min_i);
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "aabcb";

        System.out.println("Input: " + s);
        System.out.println("Output: " + sol.beautySum(s));
    }
}
