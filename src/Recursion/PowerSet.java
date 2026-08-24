package Recursion;

import java.util.ArrayList;
import java.util.List;

/// # Power Set: Print All Subsequences of a String
/// **Level:** Medium | **Pattern:** Recursion (backtracking / bit manipulation) | **TC / SC:** O(N * 2^N) / O(N)
/// **Trigger:** "print all subsequences", "power set", "bit masking", "include/exclude"
/// **Traps:** Duplicate characters produce duplicate subsequences; empty subsequence is valid; `n` up to ~20 practical
///
/// Given a string, find all the possible subsequences of the string.
///
/// **Example 1:**
/// ```txt
/// Input: str = "abc"
/// Output: [a, ab, abc, ac, b, bc, c]
/// Explanation: Given string has 7 subsequences.
/// ```
/// **Example 2:**
/// ```txt
/// Input: str = "aa"
/// Output: [a, a, aa]
/// Explanation: Given string has 3 subsequences.
/// ```
///
/// **Approach 1 — Iterative (Bit Masking):**
/// Each subsequence corresponds to a binary number where bits represent whether to include (1) or exclude (0)
/// a character at that position. There are `2^n` subsequences for a string of length `n`.
///
/// **Approach 2 — Recursive (Include/Exclude):**
/// Use recursion to decide for each character whether to include it or not. This forms a binary decision tree
/// exploring all combinations. When you reach the end of the string, add the current subsequence to the result.

public class PowerSet {
    static class Solution {
        // Approach 1: Iterative — each number from 0 to 2^n-1 represents a subsequence
        // Bit i set → include char at index i
        public List<String> approachOne(String str) {
            int n = str.length();
            List<String> res = new ArrayList<>();

            for (int i = 0; i < (1 << n); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        sb.append(str.charAt(j));
                    }
                }
                res.add(sb.toString());
            }
            return res;
        }

        // Approach 2: Recursive — include or exclude each character
        private void generate(String str, int idx, String curr, List<String> res) {
            if (idx == str.length()) {
                res.add(curr);
                return;
            }
            // Include the current character
            generate(str, idx + 1, curr + str.charAt(idx), res);
            // Exclude the current character
            generate(str, idx + 1, curr, res);
        }

        public List<String> approachTwo(String str) {
            List<String> res = new ArrayList<>();
            generate(str, 0, "", res);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] tests = {"abc", "aa"};

        for (String str : tests) {
            System.out.println("Input: str = \"" + str + "\"");
            System.out.println("Output: " + s.approachOne(str));
        }
    }
}
