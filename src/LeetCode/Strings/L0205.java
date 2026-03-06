package LeetCode.Strings;

import java.util.HashMap;

/// # [L0205: Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings)
/// ## Level - Easy
/// Given two strings `s` and `t`, _determine if they are isomorphic_.
///
/// Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.
///
/// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
///
/// **Example 1:**
/// ```txt
/// Input: s = "egg", t = "add"
/// Output: true
/// Explanation:
/// The strings s and t can be made identical by:
/// Mapping 'e' to 'a'.
/// Mapping 'g' to 'd'.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "foo", t = "bar"
/// Output: false
/// Explanation:
/// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
/// ```
///
/// **Example 3:**
/// ```txt
/// Input: s = "paper", t = "title"
/// Output: true
/// ```

public class L0205 {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length()) return false;

            // take two arrays to track letters of two strings given
            // size is to be taken 256, as the number of ASCII characters is 256
            int[] arr1 = new int[256];
            int[] arr2 = new int[256];

            // length of the given strings
            int len = s.length();

            // iterate through and map the characters
            for (int i = 0; i < len; i++) {
                if(arr1[s.charAt(i)] != arr2[t.charAt(i)]) return false;
                arr1[s.charAt(i)] = arr2[t.charAt(i)] = i+1;
            }

            // return true if isomorphic
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "foo";
        String t = "baa";

        System.out.println("Input: s = " + s + ", t = " + t);
        System.out.println("Output: " + solution.isIsomorphic(s, t));
    }
}
