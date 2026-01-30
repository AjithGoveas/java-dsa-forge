package LeetCode.Strings;

import java.util.HashMap;

/// # [L0013: Roman to Integer](https://leetcode.com/problems/roman-to-integer)
/// ## Level - Easy
/// Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
///
/// ```txt
/// Symbol      Value
/// I             1
/// V             5
/// X             10
/// L             50
/// C             100
/// D             500
/// M             1000
/// ```
/// For example, `2` is written as `II` in Roman numeral, just two ones added together. `12` is written as `XII`, which is simply `X + II`. The number `27` is written as `XXVII`, which is `XX + V + II`.
///
/// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not `IIII`. Instead, the number four is written as `IV`. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:
///
/// - `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
/// - `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
/// - `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.
/// Given a roman numeral, convert it to an integer.
///
/// **Example 1:**
/// ```txt
/// Input: s = "III"
/// Output: 3
/// Explanation: III = 3.
/// ```
/// **Example 2:**
/// ```txt
/// Input: s = "LVIII"
/// Output: 58
/// Explanation: L = 50, V= 5, III = 3.
/// ```
/// **Example 3:**
/// ```txt
/// Input: s = "MCMXCIV"
/// Output: 1994
/// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
/// ```
///
/// **Constraints:**
/// - `1 <= s.length <= 15`
/// - `s` contains only the characters `('I', 'V', 'X', 'L', 'C', 'D', 'M')`.
/// - It is **guaranteed** that `s` is a valid roman numeral in the range `[1, 3999]`.

public class L0013 {
    static class Solution {
        // bad on space
        public int approachOne(String s) {
            int res = 0;

            // Create roman numeral map
            HashMap<Character, Integer> roman = new HashMap<>();
            roman.put('I', 1);
            roman.put('V', 5);
            roman.put('X', 10);
            roman.put('L', 50);
            roman.put('C', 100);
            roman.put('D', 500);
            roman.put('M', 1000);

            // Iterate through string
            for (int i = 0; i < s.length() - 1; i++) {
                if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                    res -= roman.get(s.charAt(i));
                } else {
                    res += roman.get(s.charAt(i));
                }
            }

            // Last element remains
            // Therefore add
            return res + roman.get(s.charAt(s.length() - 1));
        }

        // optimized approach of the above
        // saves space
        public int approachTwo(String s) {
            // Initialize result to 0
            int result = 0;

            // Loop through the string from left to right
            for (int i = 0; i < s.length(); i++) {
                // Get the integer value of the current character using the helper method
                int current = getValue(s.charAt(i));

                // Check if we're not at the last character
                if (i < s.length() - 1) {
                    // Get the value of the next character
                    int next = getValue(s.charAt(i + 1));

                    // If current is less than next, subtract it (subtraction rule)
                    // Examples: IV (4), IX (9), XL (40), XC (90), CD (400), CM (900)
                    if (current < next) {
                        result -= current;
                    } else {
                        // Otherwise add it (normal case)
                        result += current;
                    }
                } else {
                    // Last character: always add it
                    result += current;
                }
            }

            return result;
        }

        private int getValue(char c) {
            // Modern way switch
            return switch (c) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
        }

        // Extreme method solving
        public int romanToInt(String s) {
            int ans = 0, num = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                num = getValue(s.charAt(i));
                if (4 * num < ans)
                    ans = ans - num;
                else
                    ans = ans + num;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "MCMXCIV";

        System.out.println("Input: s = " + s);
        System.out.println("Output: " + solution.approachTwo(s));
    }
}
