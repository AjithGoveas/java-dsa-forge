package LeetCode.Strings;

import java.util.Arrays;

/// # [L0014: Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)
/// ## Level - Easy
/// Write a function to find the longest common prefix string amongst an array of strings.
///
/// If there is no common prefix, return an empty string `""`.
///
/// **Example 1:**
/// ```txt
/// Input: strs = ["flower","flow","flight"]
/// Output: "fl"
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: strs = ["dog","racecar","car"]
/// Output: ""
/// Explanation: There is no common prefix among the input strings.
/// ```

public class L0014 {
    static class Solution {
        // not a complete run solution
        public String approachOne(String[] strs) {
            StringBuilder res = new StringBuilder(strs[0]);

            for (int i = 1; i < strs.length; i++) {
                int a = 0, b = 0;
                String word = strs[i];
                while (a < res.length() && b < word.length()) {
                    if (res.charAt(a) == word.charAt(b)) {
                        a++;
                        b++;
                    } else {
                        res.setLength(0);
                        res.append(word, 0, b);
                    }
                }
            }

            return res.toString();
        }

        // better
        public String approachTwo(String[] strs) {
            // Array length
            int len = strs.length;

            // sort the array
            Arrays.sort(strs);

            // First and last element of Sorted array
            String first = strs[0];
            String last = strs[len - 1];

            // Find string with minimum length
            int minSize = Math.min(first.length(), last.length());

            // Find the index in strings where it is common
            int i = 0;
            while (i < minSize && first.charAt(i) == last.charAt(i)) {
                i++;
            }

            // return the substring that is the common prefix
            return first.substring(0, i);
        }

        // optimal - optimized on approachTwo
        public String longestCommonPrefix(String[] strs) {
            // Initial check for empty
            if (strs == null || strs.length == 0) return "";

            // Consider first element
            String prefix = strs[0];

            // find common substring => prefix
            for (int i = 1; i < strs.length; i++) {
                while(strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length()-1);
                    if (prefix.isEmpty()) return "";
                }
            }

            return prefix;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"flower", "flow", "flight"};

        System.out.println("Input: strs = " + Arrays.toString(strs));
        System.out.println("Output: " + solution.longestCommonPrefix(strs));
    }
}
