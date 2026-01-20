package LeetCode.Strings;

/// # [L0796: Rotate String](https://leetcode.com/problems/rotate-string)
/// ## Level - Easy
/// Given two strings `s` and `goal`, return `true` _if and only if_ `s` _can become_ `goal` _after some number of **shifts** on_ `s`.
///
/// A **shift** on `s` consists of moving the leftmost character of `s` to the rightmost position.
///
/// For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.
///
/// **Example 1:**
/// ```txt
/// Input: s = "abcde", goal = "cdeab"
/// Output: true
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "abcde", goal = "abced"
/// Output: false
/// ```

public class L0796 {
    static class Solution {
        // not good solution as the words are not properly accounted
        public boolean approachOne(String s, String goal) {
            // Rotation is possible if strings of same length
            if(s.length() != goal.length()) return false;

            int len = s.length();
            int diff = goal.charAt(0) - s.charAt(0);

            for (int i = 0; i < len; i++) {
                int nextPos = (len - diff + i)%len;
                if(s.charAt(i) != goal.charAt(nextPos)) return false;
            }

            return true;
        }

        // better approach
        // time complexity - O(n^2)
        // space complexity - O(n)
        public boolean approachTwo(String s, String goal) {
            // Check if length is same
            if (s.length() != goal.length()) return false;

            // Try all possible rotations
            for (int i = 0; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);
                // Return true if equal
                if(rotated.equals(goal)) return true;
            }

            return false;
        }

        // optimal
        // time complexity - O(n)
        // space complexity - O(2n)
        public boolean rotateString(String s, String goal) {
            // false if lengths are not equal
            if (s.length() != goal.length()) return false;

            // Do a substring search in a string (double the size of original string)
            // i.e. double the original string
            String str = s+s;

            // return true if the goal is found in str
            return str.contains(goal);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "abcde";
        String goal = "abced";

        System.out.println("Input: s = " + s + ", goal = " + goal);
        System.out.println("Output: " + sol.rotateString(s, goal));
    }
}
