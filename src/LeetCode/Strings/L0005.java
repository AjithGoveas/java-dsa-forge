package LeetCode.Strings;

/// # [L0005: Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)
/// ## Level - Medium
/// Given a string `s`, return the longest _**palindromic substring**_ in `s`.
///
/// **Example 1:**
/// ```txt
/// Input: s = "babad"
/// Output: "bab"
/// Explanation: "aba" is also a valid answer.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "cbbd"
/// Output: "bb"
/// ```
///
/// **Constraints:**
///
/// - `1 <= s.length <= 1000`
/// - `s` consist of only digits and English letters.

public class L0005 {

    static class Solution {
        public String longestPalindrome(String s) {
            // Check empty
            if (s == null || s.isEmpty()) return "";

            // Two pointer
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = expandFromCenter(s, i, i);   // odd length
                int len2 = expandFromCenter(s, i, i + 1); // even length
                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expandFromCenter(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }

            // length of palindrom
            return j - i - 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "cbbd";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + sol.longestPalindrome(s));
    }
}
