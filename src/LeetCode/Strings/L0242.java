package LeetCode.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // simple logic
        // time complexity - O(n log n)
        // space complexity - O(1)
        public boolean approachOne(String s, String t) {
            if (s.length() != t.length()) return false;

            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();

            // Sort arrays
            Arrays.sort(ss);
            Arrays.sort(tt);

            return Arrays.equals(ss, tt);
        }

        // better
        // time complexity - O(n)
        // space complexity - O(n)
        public boolean approachTwo(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> map_s = new HashMap<>();
            HashMap<Character, Integer> map_t = new HashMap<>();

            for (int i = 0; i < s.length(); i++)
                map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
            for (int i = 0; i < t.length(); i++)
                map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);

            return map_s.equals(map_t);
        }

        // optimized approachTwo
        // time complexity
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> freq = new HashMap<>();

            for (int i = 0; i < s.length(); i++) freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

            for (int i = 0; i < t.length(); i++) freq.replace(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) - 1);

            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                if (entry.getValue() != 0) return false;
            }

            return true;
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
