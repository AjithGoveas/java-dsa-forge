package LeetCode.BinarySearch;

import java.util.Arrays;
import java.util.HashMap;

/// # [L0540: Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array)
/// ## Level - Medium
/// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
///
/// Return _the single element that appears only once_.
///
/// Your solution must run in `O(log n)` time and `O(1)` space.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,1,2,3,3,4,4,8,8]
/// Output: 2
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [3,3,7,7,10,11,11]
/// Output: 10
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 10^5`
/// - `0 <= nums[i] <= 10^5`

public class L0540 {

    static class Solution {
        public int approachOne(int[] nums) {
            // Get the size of the array
            int n = nums.length;

            // If array has only one element, return it
            if (n == 1) return nums[0];

            // Loop through the array
            for (int i = 0; i < n; i++) {

                // Check if it's the first element and not equal to the next
                if (i == 0) {
                    if (nums[i] != nums[i + 1])
                        return nums[i];
                }

                // Check if it's the last element and not equal to the previous
                else if (i == n - 1) {
                    if (nums[i] != nums[i - 1])
                        return nums[i];
                }

                // Check if the current element is not equal to both neighbors
                else {
                    if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                        return nums[i];
                }
            }

            // Dummy return if no element found
            return -1;
        }

        public int approachTwo(int[] nums) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int ele : nums) {
                freq.put(ele, freq.getOrDefault(ele, 0) + 1);
            }

            for (int x : freq.keySet()) {
                if (freq.get(x) == 1) {
                    return x;
                }
            }

            return 0;
        }

        public int approachThree(int[] nums) {
            int len = nums.length;

            // edge case: one element
            if (len == 1) return nums[0];

            int ans = 0;
            for (int ele : nums) {
                ans ^= ele;
            }

            return ans;
        }

        // optimized above
        public int singleNonDuplicate(int[] nums) {
            // Get the size of the array
            int n = nums.length;

            // Edge case: only one element in the array
            if (n == 1) return nums[0];

            // Edge case: first element is the unique one
            if (nums[0] != nums[1]) return nums[0];

            // Edge case: last element is the unique one
            if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

            // Initialize binary search bounds (exclude first and last index)
            int low = 1, high = n - 2;

            // Perform binary search
            while (low <= high) {
                // Calculate middle index
                int mid = (low + high) / 2;

                // Check if middle element is the unique one
                if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                    return nums[mid];
                }

                // If mid is in the left half (pairing is valid)
                if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                        (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                    // Move to the right half
                    low = mid + 1;
                }
                // If mid is in the right half (pairing broken earlier)
                else {
                    // Move to the left half
                    high = mid - 1;
                }
            }

            // Dummy return (not reachable if input is valid)
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + sol.singleNonDuplicate(nums));
    }
}
