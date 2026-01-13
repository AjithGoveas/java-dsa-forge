package LeetCode.Arrays;

import java.util.Arrays;


/// # [L0485: Max Consecutive Ones]()
/// Easy
/// Given a binary array `nums`, return the maximum number of consecutive `1`'s in the array.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,1,0,1,1,1]
/// Output: 3
/// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [1,0,1,1,0,1]
/// Output: 2
///```

public class L0485 {
    static class Solution {
        public int approachOne(int[] nums) {
            int max = 0;
            int count = 0;

            for (int num : nums) {
                if (num == 1) {
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }
            return max;
        }

        // Optimal enough
        public int approachTwo(int[] nums) {
            int max = 0;
            int count = 0;

            for (int num : nums) {
                if (num == 1) {
                    count++;
                } else {
                    count = 0;
                }
                // Small optimization on the max
                if (count > max) {
                    max = count;
                }
            }
            return max;
        }

        // Optimized above solution by using single pointer
        // And max check at the end
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;
            int index = 0;

            while (index < nums.length) {
                if (nums[index] == 1) {
                    count++;
                } else  {
                    max = Math.max(max, count);
                    count = 0;
                }
                index++;
            }
            return Math.max(max, count);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 0, 1, 1, 0, 1};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + s.findMaxConsecutiveOnes(nums));
    }
}
