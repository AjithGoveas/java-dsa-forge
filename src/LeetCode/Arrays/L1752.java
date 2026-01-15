package LeetCode.Arrays;


import java.util.Arrays;

/// # [L1752: Check If Array Is Sorted and Rotated](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)
/// ## Level - Easy
///
/// Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order, then rotated **some** number of positions (including zero). Otherwise, return `false`.
///
/// There may be **duplicates** in the original array.
///
/// **Note:** An array `A` rotated by `x` positions results in an array `B` of the same length such that `B[i] == A[(i+x) % A.length]` for every valid index `i`.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [3,4,5,1,2]
/// Output: true
/// Explanation: [1,2,3,4,5] is the original sorted array.
/// You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [2,1,3,4]
/// Output: false
/// Explanation: There is no sorted array once rotated that can make nums.
///```
///
/// **Example 3:**
/// ```txt
/// Input: nums = [1,2,3]
/// Output: true
/// Explanation: [1,2,3] is the original sorted array.
/// You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
///```

public class L1752 {

    static class Solution {
        public boolean betterSolution(int[] nums) {
            int size = nums.length;
            // Two arrays
            int[] A = Arrays.copyOf(nums, size);
            int[] B = Arrays.copyOf(nums, size);

            // Sort the second array
            Arrays.sort(B);
            int i;
            for (i = 1; i < size; i++) {
                if (A[i] < A[i - 1]) break;
            }

            // calculate shift
            int shift = i;

            return isRotated(A, B, shift);
        }

        public boolean isRotated(int[] originalArr, int[] sortedArr, int shift) {
            for (int i = 0; i < sortedArr.length; i++)
                if (sortedArr[i] != originalArr[(i + shift) % originalArr.length]) return false;
            return true;
        }

        // optimal solution
        // count the number of elements satisfies rotation logic and are greater than the shifted place by 1
        public boolean check(int[] nums) {
            int count = 0;
            int size = nums.length;

            for (int i = 0; i < size; i++) {
                // if nums is not sorted and is not rotated by 1 place then increase count
                if (nums[i] > nums[(i + 1) % size]) count++;
            }

            return count <= 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {2, 1, 3, 4};
        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Output: " + solution.check(arr));
    }
}
