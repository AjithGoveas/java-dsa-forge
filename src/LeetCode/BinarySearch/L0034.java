package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0034: Find First and Last Position of Elements in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)
///
/// ## Level - Medium
///
/// Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.
///
/// If `target` is not found in the array, return `[-1, -1]`.
///
/// You must write an algorithm with `O(log n)` runtime complexity.
///
/// Example 1:
/// ```
/// Input: nums = [5,7,7,8,8,10], target = 8
/// Output: [3,4]
///```
///
/// Example 2:
/// ```
/// Input: nums = [5,7,7,8,8,10], target = 6
/// Output: [-1,-1]
///```
///
/// Example 3:
/// ```
/// Input: nums = [], target = 0
/// Output: [-1,-1]
///```

public class L0034 {

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};

            if (nums.length == 0) return ans;

            // find first index or occurrence
            int start = search(nums, target, true);
            // find last occurrence
            int end = search(nums, target, false);

            ans[0] = start;
            ans[1] = end;

            return ans;
        }

        public int search(int[] nums, int target, boolean findStartIndex) {
            if (nums.length == 0) return -1;

            int low = 0, high = nums.length - 1;
            int ans = -1;

            // binary search
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (target < nums[mid]) high = mid - 1;
                else if (target > nums[mid]) low = mid + 1;
                else {
                    ans = mid;

                    // apply binarySearch to left i.e. find first position
                    if (findStartIndex) high = mid - 1;
                    // apply binarySearch to right i.e. find last position
                    else low = mid + 1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;

        System.out.println("Input: letters = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.searchRange(nums, target)));
    }
}
