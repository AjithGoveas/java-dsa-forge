package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L3211: Generate Binary Strings Without Adjacent Zeros](https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros)
/// **Level:** Medium | **Pattern:** Backtracking (recursion with constraint) | **TC / SC:** O(2^N) / O(N)
/// **Trigger:** "generate binary strings", "no adjacent zeros", "backtracking"
/// **Traps:** `n = 1` → both "0" and "1" valid; only block "0" when previous char is also "0"; recursion depth up to 18
///
/// You are given a positive integer `n`.
///
/// A binary string `x` is **valid** if all substrings of `x` of length 2 contain at least one `"1"`.
///
/// Return all **valid** strings with length `n`, in any order.
///
/// **Example 1:**
/// ```txt
/// Input: n = 3
/// Output: ["010","011","101","110","111"]
/// Explanation: The valid strings of length 3 are: "010", "011", "101", "110", and "111".
/// ```
/// **Example 2:**
/// ```txt
/// Input: n = 1
/// Output: ["0","1"]
/// Explanation: The valid strings of length 1 are: "0" and "1".
/// ```
///
/// **Constraints:**
///
/// - `1 <= n <= 18`

public class L3211 {
    static class Solution {
        public List<String> validStrings(int n) {
            List<String> res = new ArrayList<String>();

            generate(n, "", res);
            return res;
        }

        private void generate(int n, String curr, List<String> res) {
            // Base Case
            if (curr.length() == n) {
                res.add(curr);
                return;
            }

            // Always place '1'
            generate(n, curr + "1", res);

            // Add '0' only if previous character is not '0'
            if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '0') {
                generate(n, curr + "0", res);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] tests = {1, 3};

        for (int n : tests) {
            System.out.println("Input: n = " + n);
            System.out.println("Output: " + s.validStrings(n));
        }
    }
}