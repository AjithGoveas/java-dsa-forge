package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;

/// # [L1295: Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)
///
/// ## Level: Easy
///
/// Given an array `nums` of integers, return how many of them contain an **even number** of digits.
///
/// **Example 1:**
/// ```
/// Input: nums = [12,345,2,6,7896]
/// Output: 2
/// Explanation:
/// 12 contains 2 digits (even number of digits).
/// 345 contains 3 digits (odd number of digits).
/// 2 contains 1 digit (odd number of digits).
/// 6 contains 1 digit (odd number of digits).
/// 7896 contains 4 digits (even number of digits).
/// Therefore, only 12 and 7896 contain an even number of digits.
/// ```
///
/// **Example 2:**
/// ```
/// Input: nums = [555,901,482,1771]
/// Output: 1
/// Explanation:
/// Only 1771 contains an even number of digits.
/// ```

public class L1295 {

    static class Solution {
        boolean isEven(int num) {
            int count = 0;
            while(num != 0){
                num /= 10;
                count++;
            }

            return count%2 == 0;
        }

        public int findNumbers(int[] nums) {
            ArrayList<Integer> ans = new ArrayList<>(1);

            for (int num : nums) {
                if (isEven(num)) ans.add(num);
            }
            return ans.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {18, 124, 9, 1764, 98, 1};

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + solution.findNumbers(nums));
    }
}
