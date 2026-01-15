package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0283: Move Zeroes](https://leetcode.com/problems/move-zeroes/)
/// ## Level - Easy
/// Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
///
/// **Note** that you must do this in-place without making a copy of the array.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [0,1,0,3,12]
/// Output: [1,3,12,0,0]
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [0]
/// Output: [0]
///```

public class L0283 {
    static class Solution {
        public void approachOne(int[] nums) {
            int len = nums.length;
            int first = 0, second = 0;

            while (second < len) {
                if (nums[second] != 0 && nums[first] != 0) {
                    nums[first++] = nums[second];
                } else if (nums[first] == 0 && nums[second] != 0) {
                    nums[first++] = nums[second];
                    nums[second] = 0;
                } else if (nums[second] == 0 && nums[first] != 0) {
                    first++;
                }
                second++;
            }
        }

        public void moveZeroes(int[] nums) {
            int zeroIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroIndex = i;
                    break;
                }
            }

            if (zeroIndex == -1) return;

            for (int i = zeroIndex + 1; i < nums.length; i++) {
                if(nums[i] != 0) {
                    swap(nums, i, zeroIndex);
                    zeroIndex++;
                }
            }
        }
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
