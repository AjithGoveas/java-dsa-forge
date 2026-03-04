package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0410: Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum)
/// ## Level - Hard
/// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
///
/// Return the minimized largest sum of the split.
///
/// A subarray is a contiguous part of the array.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [7,2,5,10,8], k = 2
/// Output: 18
/// Explanation: There are four ways to split nums into two subarrays.
/// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [1,2,3,4,5], k = 2
/// Output: 9
/// Explanation: There are four ways to split nums into two subarrays.
/// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 1000`
/// - `0 <= nums[i] <= 10^6`
/// - `1 <= k <= min(50, nums.length)`

public class L0410 {
    static class Solution {
        // Helper - Counts how many partitions are needed for a given maxSum limit
        public int countPartitions(int[] a, int maxSum) {
            int partitions = 1; // at least one partition
            long subarraySum = 0; // sum of current subarray

            for (int j : a) {
                // Add to current subarray if possible
                if (subarraySum + j <= maxSum) {
                    subarraySum += j;
                } else {
                    // Start new subarray
                    partitions++;
                    subarraySum = j;
                }
            }
            return partitions;
        }

        // Brute Force
        // Finds the smallest possible largest subarray sum to get exactly k partitions
        public int approachOne(int[] a, int k) {
            int low = Arrays.stream(a).max().getAsInt(); // max element
            int high = Arrays.stream(a).sum(); // sum of all elements

            // Brute-force from low to high
            for (int maxSum = low; maxSum <= high; maxSum++) {
                if (countPartitions(a, maxSum) == k) {
                    return maxSum;
                }
            }
            return low; // fallback
        }

        // Optimal Approach
        // Finds the minimum largest subarray sum possible for at most k partitions
        public int largestSubarraySumMinimized(int[] a, int k) {
            int low = Arrays.stream(a).max().getAsInt(); // largest element
            int high = Arrays.stream(a).sum(); // sum of all elements

            // Binary search for the smallest maxSum
            while (low <= high) {
                int mid = (low + high) / 2;
                int partitions = countPartitions(a, mid);

                if (partitions > k) {
                    low = mid + 1; // too many partitions → increase maxSum
                } else {
                    high = mid - 1; // valid but try smaller maxSum
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 20, 30, 40};
        int k = 2;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        int ans = solution.largestSubarraySumMinimized(nums, k);
        System.out.println("Output: " + ans);
    }
}
