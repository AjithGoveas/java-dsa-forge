package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0033: Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)
/// ## Level - Medium
/// There is an integer array `nums` sorted in ascending order (with **distinct** values).
///
/// Prior to being passed to your function, `nums` is **possibly left rotated** at an unknown index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,5,6,7]` might be left rotated by `3` indices and become `[4,5,6,7,0,1,2]`.
///
/// Given the array `nums` **after** the possible rotation and an integer `target`, return _the index of_ `target` _if it is in_ `nums`_, or_ `-1` _if it is not in_ `nums`.
///
/// You must write an algorithm with `O(log n)` runtime complexity.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [4,5,6,7,0,1,2], target = 0
/// Output: 4
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [4,5,6,7,0,1,2], target = 3
/// Output: -1
/// ```
/// **Example 3:**
/// ```txt
/// Input: nums = [1], target = 0
/// Output: -1
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 5000`
/// - `-104 <= nums[i] <= 104`
/// - All values of `nums` are **unique**.
/// - `nums` is an ascending array that is possibly rotated.
/// - `-104 <= target <= 104`

public class L0033 {
    static class Solution {
        public int approachOne(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }

            return -1;
        }

        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) return mid;

                // check growing / shrinking
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) high = mid - 1;
                    else low = mid + 1;
                } else {
                    if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                    else high = mid - 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;

        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + sol.search(nums, target));
    }
}
