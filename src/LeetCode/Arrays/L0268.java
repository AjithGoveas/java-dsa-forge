package LeetCode.Arrays;

import java.util.Arrays;

/// # [L0268: Missing Number](https://leetcode.com/problems/missing-number/)
/// ## Level - Easy
/// Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [3,0,1]
/// Output: 2
/// Explanation:
/// n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [0,1]
/// Output: 2
/// Explanation:
/// n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
///```
///
/// **Example 3:**
/// ```txt
/// Input: nums = [9,6,4,2,3,5,7,0,1]
/// Output: 8
/// Explanation:
/// n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
///```

public class L0268 {
    static class Solution {

        public int approachOne(int[] nums) {
            // We will sort the elements in ascending elements
            // Then we will match elements with the index
            // If the index doesn't match then we return that index

            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] != i) return i;
            }
            return len;
        }

        // Optimal but cost complexity due to inbuilt functions
        public int approachTwo(int[] nums) {
            // Array length
            int len = nums.length;

            // Calculate the sum of elements till len element
            int calculatedSum = len * (len + 1) / 2;

            // Calculate sum of the given array
            int iterativeSum = Arrays.stream(nums).sum();

            // Difference of the above two elements give missing elements
            return calculatedSum - iterativeSum;
        }

        public int missingNumber(int[] nums) {
            // Array length
            int len = nums.length;

            // Calculate sum of the given array
            int sum = 0;
            for (int i : nums) sum += i;

            // Difference give missing elements
            return (len * (len + 1) / 2 - sum);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + (solution.missingNumber(nums)));
    }
}
