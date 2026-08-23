package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L0022: Generate Parentheses](https://leetcode.com/problems/generate-parentheses)
/// **Level:** Medium | **Pattern:** Backtracking (recursion with constraint) | **TC / SC:** O(4^N / √N) / O(N)
/// **Trigger:** "generate parentheses", "well-formed parentheses", "backtracking"
/// **Traps:** Only add `)` when `close < open`; string length must be exactly `2*n`; `n = 1` → only `"()"`
///
/// Given `n` pairs of parentheses, write a function to generate all combinations of **well-formed** parentheses.
///
/// **Example 1:**
/// ```txt
/// Input: n = 3
/// Output: ["((()))","(()())","(())()","()(())","()()()"]
/// ```
/// **Example 2:**
/// ```txt
/// Input: n = 1
/// Output: ["()"]
/// ```
///
/// **Constraints:**
///
/// - `1 <= n <= 8`

public class L0022 {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();

            generate(n, "", 0, 0, res);
            return res;
        }

        private void generate(int n, String curr, int open, int close, List<String> res) {
            if (curr.length() == 2 * n) {
                res.add(curr);
                return;
            }
            if (open < n) generate(n, curr + "(", open + 1, close, res);
            if (close < open) generate(n, curr + ")", open, close + 1, res);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] tests = {1, 3};

        for (int n : tests) {
            System.out.println("Input: n = " + n);
            System.out.println("Output: " + s.generateParenthesis(n));
        }
    }
}
