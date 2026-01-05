package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L744: Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/)
///
/// ## Level - Easy
///
/// You are given an array of characters `letters` that is sorted in **non-decreasing order**, and a character `target`. There are **at least two different** characters in `letters`.
///
/// Return the smallest character in `letters` that is lexicographically greater than `target`. If such a character does not exist, return the first character in `letters`.
///
/// Example 1:
/// ```
/// Input: letters = ["c","f","j"], target = "a"
/// Output: "c"
/// Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
///```
///
/// Example 2:
/// ```
/// Input: letters = ["c","f","j"], target = "c"
/// Output: "f"
/// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
///```
/// Example 3:
/// ```
/// Input: letters = ["x","x","y","y"], target = "z"
/// Output: "x"
/// Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
///```


public class L0744 {
    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {

            int low = 0, high = letters.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                // handles greater than or equal to
                if (target >= letters[mid]) low = mid + 1;
                else high = mid - 1;
            }

            // this performs wrap-back logic (circular queue types)
            return letters[low % letters.length];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';

        System.out.println("Input: letters = " + Arrays.toString(letters) + ", target = " + target);
        System.out.println("Output: " + solution.nextGreatestLetter(letters, target));
    }
}
