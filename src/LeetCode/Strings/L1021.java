package LeetCode.Strings;

/// # [L1021: Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses)
/// ## Level - Easy
/// A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.
///
/// - For example, `""`, `"()"`, `"(())()"`, and `"(()(()))"` are all valid parentheses strings.
///
/// A valid parentheses string `s` is primitive if it is nonempty, and there does not exist a way to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.
///
/// Given a valid parentheses string `s`, consider its primitive decomposition: `s = P1 + P2 + ... + Pk`, where `Pi` are primitive valid parentheses strings.
///
/// Return `s` after _removing the outermost parentheses of every primitive string in the primitive decomposition of_ `s`.
///
/// **Example 1:**
/// ```txt
/// Input: s = "(()())(())"
/// Output: "()()()"
/// Explanation:
/// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
/// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: s = "(()())(())(()(()))"
/// Output: "()()()()(())"
/// Explanation:
/// The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
/// After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
/// ```
///
/// **Example 3:**
/// ```txt
/// Input: s = "()()"
/// Output: ""
/// Explanation:
/// The input string is "()()", with primitive decomposition "()" + "()".
/// After removing outer parentheses of each part, this is "" + "" = "".
/// ```

public class L1021 {
    static class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();

            // Based on the count of open parenthesis match closed parenthesis
            int openCount = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    if (openCount > 0) res.append(c);
                    openCount++;
                } else {
                    openCount--;
                    if (openCount > 0) res.append(c);
                }
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "(()())(())(()(()))";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.removeOuterParentheses(s));
    }
}
