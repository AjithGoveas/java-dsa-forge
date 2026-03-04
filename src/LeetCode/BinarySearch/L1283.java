package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1283: Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold)
/// ## Level - Medium
/// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
///
/// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
///
/// The test cases are generated so that there will be an answer.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,2,5,9], threshold = 6
/// Output: 5
/// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
/// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [44,22,33,11,1], threshold = 5
/// Output: 44
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 5 * 10^4`
/// - `1 <= nums[i] <= 10^6`
/// - `nums.length <= threshold <= 10^6`

public class L1283 {
    static class Solution {
        // Brute Force
        // Method to find the smallest divisor such that the sum of ceiling divisions <= limit
        public int approachOne(int[] arr, int limit) {
            // Find the maximum element in the array
            int max = Integer.MIN_VALUE;
            for (int num : arr) {
                max = Math.max(max, num);
            }

            // Try all possible divisors from 1 to max
            for (int d = 1; d <= max; d++) {
                int sum = 0;
                for (int j : arr) {
                    // Divide each number by d and take the ceiling
                    sum += (int) Math.ceil((double) j / d);
                }

                // If the total sum is within the limit, return this divisor
                if (sum <= limit) {
                    return d;
                }
            }

            return -1; // No valid divisor found
        }

        // Optimal Approach
        // Method to find the smallest divisor using binary search
        public int smallestDivisor(int[] arr, int limit) {
            if (arr.length > limit) return -1;

            int low = 1;
            int high = Arrays.stream(arr).max().getAsInt();

            while (low <= high) {
                int mid = (low + high) / 2;
                if (sumByD(arr, mid) <= limit) {
                    high = mid - 1; // Try smaller divisor
                } else {
                    low = mid + 1;  // Try larger divisor
                }
            }

            return low;
        }

        // Helper method to calculate sum by divisor
        private int sumByD(int[] arr, int div) {
            int sum = 0;
            for (int num : arr) {
                sum += Math.ceilDiv(num, div);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int threshold = 8;

        Solution obj = new Solution();
        System.out.println("Input: arr = " + Arrays.toString(nums) + ", limit = " + threshold);
        int ans = obj.smallestDivisor(nums, threshold);
        System.out.println("Output: " + ans);
    }

}
