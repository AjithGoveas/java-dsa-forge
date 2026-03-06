package LeetCode.Strings;


/// # [L1903: Largest Odd Number in String](https://leetcode.com/problems/largest-odd-number-in-string)
/// ## Level - Easy
/// You are given a string `num`, representing a large integer. Return _the **largest-valued odd** integer (as a string) that is a **non-empty substring** of `num`, or an empty string `""` if no odd integer exists_.
///
/// A **substring** is a contiguous sequence of characters within a string.
///
/// **Example 1:**
/// ```txt
/// Input: num = "52"
/// Output: "5"
/// Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: num = "4206"
/// Output: ""
/// Explanation: There are no odd numbers in "4206".
/// ```
///
/// **Example 3:**
/// ```txt
/// Input: num = "35427"
/// Output: "35427"
/// Explanation: "35427" is already an odd number.
/// ```


public class L1903 {
    static class Solution {
        public String largestOddNumber(String num) {
            int idx = -1;

            // Part 1: Find last odd digit
            int i = 0;
            for (i = num.length() - 1; i >= 0; i--) {
                if ((num.charAt(i) - '0') % 2 == 1) {
                    idx = i;
                    break;
                }
            }

            // Return if empty
            if (idx == -1) return "";

            // Trailing/Leading zeroes can be skipped => 000035427
            i = 0;
            while (i <= idx && num.charAt(i) == '0') i++;

            // return substring
            return num.substring(i, idx + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String num = "35427";

        System.out.println("Input: num = " + num);
        System.out.println("Output: " + sol.largestOddNumber(num));
    }
}
