package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0053: Maximum Subarray](https://leetcode.com/problems/maximum-subarray)
/// ## Level - Medium
/// Given an integer array `nums`, find the **subarray** with the largest sum, and return _its sum_.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
/// Output: 6
/// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [1]
/// Output: 1
/// Explanation: The subarray [1] has the largest sum 1.
///```
///
/// **Example 3:**
/// ```txt
/// Input: nums = [5,4,-1,7,8]
/// Output: 23
/// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
///```


public class L0053 {
    static class Solution {
        // Brute force - Try every possible subarray
        // Time Complexity - O(n^3)
        // Space Complexity - O(1)
        public int approachOne(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += nums[k];
                    }
                    max = Math.max(sum, max);
                }
            }

            return max;
        }

        // Better - By adding the next element instead of finding subarrays
        // Time Complexity - O(n^2)
        // Space Complexity - O(1)
        public int approachTwo(int[] nums) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum > max) max = sum;
                }
            }

            return max;
        }

        // Optimal - Kadane's Algorithm
        // Time Complexity - O(n)
        // Space Complexity - O(1)
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;

            for (int num : nums) {
                sum += num;

                if (sum > max) max = sum;

                if (sum < 0) sum = 0;
            }
            return max;
        }

        // Follow-up: Return the maxSubArray
        public int[] maxSubArray2(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            int ansStart = -1, ansEnd = -1;

            for (int i = 0; i < nums.length; i++) {
                if (sum == 0) ansStart = i;
                sum += nums[i];

                if (sum > maxSum) {
                    maxSum = sum;
                    ansEnd = i;
                }

                if (sum < 0) sum = 0;
            }
            return new int[]{ansStart, ansEnd};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + s.maxSubArray(nums));
        System.out.println("Output: maxSubArray = " + Arrays.toString(s.maxSubArray2(nums)));
    }
}
