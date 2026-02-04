package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0081: Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
/// ## Level - Medium
/// There is an integer array `nums` sorted in decreasing order (not necessarily with **distinct** values).
///
/// Before being passed to your function, `nums` is **rotated** at an unknown pivot index `k` (`0 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,4,4,5,6,6,7]` might be rotated at pivot index `5` and become `[4,5,6,6,7,0,1,2,4,4]`.
///
/// Given the array `nums` **after** the rotation and an integer `target`, return `true` _if_ `target` _is in_ `nums`_, or_ `false` _if it is not in_ `nums`.
///
/// You must decrease the overall operation steps as much as possible.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [2,5,6,0,0,1,2], target = 0
/// Output: true
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [2,5,6,0,0,1,2], target = 3
/// Output: false
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 5000`
/// - `-10^4 <= nums[i] <= 10^4`
/// - `nums` is guaranteed to be rotated at some pivot.
/// - `-10^4 <= target <= 10^4`

public class L0081 {
    static class Solution {
        // Linear search
        public boolean approachOne(int[] nums, int target) {
            for (int num : nums) {
                if (num == target) return true;
            }

            return false;
        }

        public boolean search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) return true;

                // handle duplicates: in middle or low and high points to duplicates of same number
                if(nums[low] == nums[mid] && nums[high]==nums[mid]) {
                    low++;
                    high--;
                    continue;
                }

                // check growing / shrinking
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target < nums[mid]) high = mid - 1;
                    else low = mid + 1;
                } else{
                    if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                    else high = mid - 1;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;

        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + sol.search(nums, target));
    }
}
