package LeetCode.Strings;

/// # [L0242: Valid Anagram](https://leetcode.com/problems/valid-anagram)
/// ## Level - Easy
/// Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and `false` otherwise.
///
/// **Example 1:**
/// ```txt
/// Input: s = "anagram", t = "nagaram"
/// Output: true
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "rat", t = "car"
/// Output: false
/// ```

public class L0242 {

    static class Solution {
        public boolean isAnagram(String s, String t) {

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + sol.isAnagram(s, t));
    }
}
