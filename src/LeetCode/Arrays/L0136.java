package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0136: Single Number](https://leetcode.com/problems/single-number)
/// ## Level - Easy
/// Given a **non-empty** array of integers `nums`, every element appears _twice_ except for one. Find that single one.
///
/// You must implement a solution with a linear runtime complexity and use only constant extra space.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [2,2,1]
/// Output: 1
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [4,1,2,1,2]
/// Output: 4
///```
///
/// **Example 3:**
/// ```txt
/// Input: nums = [1]
/// Output: 1
///```

public class L0136 {
    static class Solution {
        // Optimal - using bit manipulation
        // Logic - If we use XOR(^)
        // In bits, 1 ^ 1 = 0 and 0 ^ 0 = 0
        // And, 1 ^ 0 = 1 and vice versa is also same
        // With same logic, the same numbers cancel out and give us the only unique number
        public int singleNumber(int[] nums) {
            if (nums.length == 1) return nums[0];

            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans = ans^nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2, 2, 1};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + s.singleNumber(nums));
    }
}
