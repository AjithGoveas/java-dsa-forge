package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0189: Rotate Array](https://leetcode.com/problems/rotate-array/)
/// ## Level - Medium
/// Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,2,3,4,5,6,7], k = 3
/// Output: [5,6,7,1,2,3,4]
/// Explanation:
/// rotate 1 steps to the right: [7,1,2,3,4,5,6]
/// rotate 2 steps to the right: [6,7,1,2,3,4,5]
/// rotate 3 steps to the right: [5,6,7,1,2,3,4]
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [-1,-100,3,99], k = 2
/// Output: [3,99,-1,-100]
/// Explanation:
/// rotate 1 steps to the right: [99,-1,-100,3]
/// rotate 2 steps to the right: [3,99,-1,-100]
///```

public class L0189 {
    static class Solution {
        // Time Complexity - O(n)
        // Space complexity - O(1)
        // Left direction
        public void rotateByOne(int[] nums) {
            int len = nums.length;
            int temp = nums[0];
            int i;
            for (i = 1; i < len; i++) {
                nums[i - 1] = nums[i];
            }
            nums[len - 1] = temp;
        }

        // Right direction
        public void approachOne(int[] nums, int k) {
            int len = nums.length;
            while (k+1 > 0) {
                int temp = nums[0];
                for (int i = 1; i < len; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[len - 1] = temp;
                k--;
            }
        }

        public void approachTwo(int[] nums, int k) {
            int size = nums.length;
            // for right shift we do `size-k`
            int rotations = (size-k) % size;
            // take array to store initial elements
            int[] temp = new int[rotations];
            System.arraycopy(nums, 0, temp, 0, rotations);

            for (int i = rotations; i < size; i += 1) {
                nums[i - rotations] = nums[i];
            }
            System.arraycopy(temp, 0, nums, size - rotations, rotations);
        }

        // Solution accepted but not very optimal
        public void approachThree(int[] nums, int k) {
            int[] ans = new int[nums.length];
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                ans[(i + k) % len] = nums[i];
            }

            System.arraycopy(ans, 0, nums, 0, len);
        }

        // Optimal approach using split and reverse
        // Time Complexity - O(n)
        // Space Complexity - O(1)
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            int rotations = k % len;

            // Let's use reverse with split
            // First reverse the array
            reverse(nums, 0, len-1);
            // Reverse the elements from start to rotation - 1 => left part
            reverse(nums, 0, rotations-1);
            // Reverse the elements from rotation to len-1 => right part
            reverse(nums, rotations, len-1);
        }
        private void reverse(int[] nums,int start,int end){
            int temp =0;
            while(start<end){
                temp = nums[start] ;
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        s.rotate(nums, k);
        System.out.println("Output: " + Arrays.toString(nums));
    }
}
