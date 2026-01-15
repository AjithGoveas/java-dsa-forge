package LeetCode.Arrays;

import java.util.Arrays;


/// # [L0001: Two Sum](https://leetcode.com/problems/two-sum)
/// ## Level - Easy
/// Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to_ `target`.
///
/// You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.
///
/// You can return the answer in any order.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [2,7,11,15], target = 9
/// Output: [0,1]
/// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [3,2,4], target = 6
/// Output: [1,2]
///```
///
/// **Example 3:**
/// ```txt
/// Input: nums = [3,3], target = 6
/// Output: [0,1]
///```

public class L0001 {
    static class Solution {
        // Not Optimal as Time Complexity - O(n^2)
        // TODO: Try to optimize it with better data structures
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target && i != j) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {3, 2, 4};
        int target = 6;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        int[] res = s.twoSum(nums, target);
        System.out.println("Output: " + Arrays.toString(res));
    }
}
