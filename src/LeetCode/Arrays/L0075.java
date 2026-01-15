package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0075: Sort Colors](https://leetcode.com/problems/sort-colors)
/// ## Level - Medium
/// Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
///
/// We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.
///
/// You must solve this problem without using the library's sort function.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [2,0,2,1,1,0]
/// Output: [0,0,1,1,2,2]
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [2,0,1]
/// Output: [0,1,2]
///```

public class L0075 {
    static class Solution {
        // Let's use count sort
        public void approachOne(int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();

            int[] freq = new int[max + 1];
            for (int i : nums) {
                freq[i]++;
            }

            // Cumulative sum
            for (int i = 1; i < freq.length; i++)
                freq[i] += freq[i - 1];

            // Output array
            int[] output = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                int val = nums[i];
                int pos = freq[val] - 1;
                output[pos] = val;
                freq[val]--;
            }

            System.arraycopy(output, 0, nums, 0, nums.length);
        }

        // Use insertion sort
        public void approachTwo(int[] nums) {
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                int j = i;
                while (j > 0 && nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    j--;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void sortColors(int[] nums) {
            int len = nums.length;

            int low = 0, high = len-1;
            int mid = 0;

            for (int i = 0; i < len; i++) {
                if (nums[mid] == 0) {
                    swap(nums, low, mid);
                    mid++;
                    low++;
                } else if (nums[mid] == 1) mid++;
                else {
                    swap(nums, high, mid);
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        s.sortColors(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
