package LeetCode.Strings;

/// # [L0008: String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)
/// ## Level - Medium
/// Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.
///
/// The algorithm for `myAtoi(string s)` is as follows:
///
/// 1. **Whitespace**: Ignore any leading whitespace (`" "`).
/// 2. **Signedness**: Determine the sign by checking if the next character is `'-'` or `'+'`, assuming positivity if neither present.
/// 3. **Conversion**: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
/// 4. **Rounding**: If the integer is out of the 32-bit signed integer range `[-2^31, 2^31 -1]`, then round the integer to remain in the range. Specifically, integers less than `-2^31` should be rounded to `-2^31`, and integers greater than `2^31 - 1` should be rounded to `2^31 - 1`.
///
/// Return the integer as the final result.
///
/// **Example 1:**
/// ```txt
/// Input: s = "42"
/// Output: 42
/// Explanation:
/// The underlined characters are what is read in and the caret is the current reader position.
/// Step 1: "42" (no characters read because there is no leading whitespace)
///          ^
/// Step 2: "42" (no characters read because there is neither a '-' nor '+')
///          ^
/// Step 3: "42" ("42" is read in)
///            ^
/// ```
/// **Example 2:**
/// ```txt
/// Input: s = " -042"
/// Output: -42
/// Explanation:
/// Step 1: "   -042" (leading whitespace is read and ignored)
///             ^
/// Step 2: "   -042" ('-' is read, so the result should be negative)
///              ^
/// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
///                ^
/// ```
/// **Example 3:**
/// ```txt
/// Input: s = "1337c0d3"
/// Output: 1337
/// Explanation:
/// Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
///          ^
/// Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
///          ^
/// Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
///              ^
/// ```
/// **Example 4:**
/// ```txt
/// Input: s = "0-1"
/// Output: 0
/// Explanation:
/// Step 1: "0-1" (no characters read because there is no leading whitespace)
///          ^
/// Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
///          ^
/// Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
///           ^
/// ```
/// **Example 5:**
/// ```txt
/// Input: s = "words and 987"
/// Output: 0
/// Explanation:
/// Reading stops at the first non-digit character 'w'.
/// ```
/// **Constraints:**
///
/// - `0 <= s.length <= 200`
/// - `s` consists of English letters (lower-case and upper-case), digits `(0-9)`, `' '`, `'+'`, `'-'`, and `'.'`.

public class L0008 {
    static class Solution {
        // doesn't work with leading spaces
        public int approachOne(String s) {
            int res = 0, sign = 1;
            for (char c : s.toCharArray()) {
                if (c == '-') sign = -1;
                else if (isDigit(c)) res = res * 10 + (c - '0');
                else break;
            }

            return sign * res;
        }

        private boolean isDigit(char c) {
            return switch (c) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
                default -> false;
            };

        }

        public int myAtoi(String s) {
            int sign = 1;

            long res = 0;   // Long to prevent overflow

            // Pointer in the charArray
            int i = 0;

            // Skip leading spaces
            while (i < s.length() && s.charAt(i) == ' ')
                i++;

            if (i == s.length())
                return 0;

            // Check sign
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+')
                i++;

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                res = res * 10 + (s.charAt(i) - '0');

                // Manage bounds/range of integer as told
                if ((sign * res) > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if ((sign * res) < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;

                i++;
            }

            return (int)(sign * res);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "-1337cod3";
        System.out.println("Input: s = " + s);
        System.out.println("Output: " + sol.myAtoi(s));
    }
}
