package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0162: Find Peak Element](https://leetcode.com/problems/find-peak-element/)
/// ## Level - Medium
///
/// A peak element is an element that is strictly greater than its neighbors.
///
/// Given a **0-indexed** integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to **any of the peaks**.
///
/// You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
///
/// You must write an algorithm that runs in `O(log n)` time.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,2,3,1]
/// Output: 2
/// Explanation: 3 is a peak element and your function should return the index number 2.
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [1,2,1,3,5,6,4]
/// Output: 5
/// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
///```

public class L0162 {

    static class Solution {

        // this is brute force approach - O(n) complexity
        public int bruteForce(int[] arr) {
            int arrLen = arr.length;
            int maxIndex = 0;

            for (int i = 0; i <= arrLen / 2; i++) {
                if (arr[i] > arr[maxIndex]) maxIndex = i;
            }
            return maxIndex;
        }

        // Optimal approach - O(log n) complexity
        public int findPeakElement(int[] nums) {
            int low = 0, high = nums.length - 1;

            while(low < high) {     // try to run until low = high => low or high determines max element
                int mid = low + (high - low) / 2;

                if (nums[mid] > nums[mid + 1] ) {
                    // we are in decreasing part of the array
                    // search at the left
                    high = mid;
                } else {
                    // we are in the increasing part of the array
                    // search at the right
                    low = mid + 1;
                }
            }

            return low; // or return high i.e. max element
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1,2,1,3,5,6,4};
        int res = solution.findPeakElement(arr);

        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Output: res = " + res);
    }
}
