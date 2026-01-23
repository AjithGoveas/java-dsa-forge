package LeetCode.Strings;

/// # [L1614: Maximum Nesting Depth of the Parentheses](https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses)
/// ## Level - Easy
/// Given a **valid parentheses string** `s`, return the **nesting depth** of `s`. The nesting depth is the **maximum number** of nested parentheses.
///
/// **Example 1:**
/// ```txt
/// Input: s = "(1+(2*3)+((8)/4))+1"
/// Output: 3
/// Explanation:
/// Digit 8 is inside of 3 nested parentheses in the string.
/// ```
/// **Example 2:**
/// ```txt
/// Input: s = "(1)+((2))+(((3)))"
/// Output: 3
/// Explanation:
/// Digit 3 is inside of 3 nested parentheses in the string.
/// ```
/// **Example 3:**
/// ```txt
/// Input: s = "()(())((()()))"
/// Output: 3
/// ```

public class L1614 {
    static class Solution {
        public int maxDepth(String s) {
            int count = 0, max = 0;
            for (char ele : s.toCharArray()) {
                if(ele == '(') count++;
                else if (ele == ')') count--;
                max = Math.max(max, count);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "()(())((()()))";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + sol.maxDepth(s));
    }
}
