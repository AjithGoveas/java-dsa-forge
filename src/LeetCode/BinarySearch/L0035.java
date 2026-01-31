package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0035: Search Insert Position](https://leetcode.com/problems/search-insert-position)
/// ## Level - Easy
/// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
///
/// You must write an algorithm with `O(log n)` runtime complexity.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,3,5,6], target = 5
/// Output: 2
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [1,3,5,6], target = 2
/// Output: 1
/// ```
/// **Example 3:**
/// ```txt
/// Input: nums = [1,3,5,6], target = 7
/// Output: 4
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 10^4`
/// - `-10^4 <= nums[i] <= 10^4`
/// - `nums` contains **distinct** values sorted in **ascending** order.
/// - `-10^4 <= target <= 10^4`

public class L0035 {

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) return mid;
                else if (target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            }

            return low;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + sol.searchInsert(nums, target));
    }
}
