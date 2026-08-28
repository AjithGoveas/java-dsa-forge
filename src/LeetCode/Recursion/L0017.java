package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L0017: Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)
/// **Level:** Medium | **Pattern:** Backtracking (mapping + branching) | **TC / SC:** O(4^N * N) / O(N)
/// **Trigger:** "letter combinations", "phone keypad", "digit to letters", "mapping"
/// **Traps:** Empty input → empty result; digits range 2-9 only; each digit maps to 3 or 4 letters; recursion depth = digits length
///
/// Given a string containing digits from `2-9` inclusive, return all possible letter combinations
/// that the number could represent. Return the answer in any order.
///
/// A mapping of digits to letters (just like on the telephone buttons) is given below.
/// Note that `1` does not map to any letters.
///
/// **Example 1:**
/// ```txt
/// Input: digits = "23"
/// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
/// ```
/// **Example 2:**
/// ```txt
/// Input: digits = "2"
/// Output: ["a","b","c"]
/// ```
///
/// **Constraints:**
///
/// - `1 <= digits.length <= 4`
/// - `digits[i]` is a digit in the range `['2', '9']`.

public class L0017 {
    static class Solution {
        private final String[] map;

        public Solution() {
            map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        }

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();

            if (digits.length() == 0) return res;

            backtrack(digits, res, 0, "");

            return res;
        }

        private void backtrack(String digits, List<String> res, int idx, String curr) {
            if (idx == digits.length()) {
                res.add(curr);
                return;
            }

            String str = map[digits.charAt(idx) - '0'];

            for (int i = 0; i < str.length(); i++) {
                backtrack(digits, res, idx + 1, curr + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("Input: digits = \"23\"");
        System.out.println("Output: " + s.letterCombinations("23"));

        System.out.println("Input: digits = \"2\"");
        System.out.println("Output: " + s.letterCombinations("2"));
    }
}
