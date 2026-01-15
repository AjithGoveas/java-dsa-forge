package LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/// # [L0169: Majority Element](https://leetcode.com/problems/majority-element)
/// ## Level - Easy
/// Given an array `nums` of size `n`, return the _majority element_.
///
/// The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [3,2,3]
/// Output: 3
///```
///
/// **Example 2:**
/// ```txt
/// Input: nums = [2,2,1,1,1,2,2]
/// Output: 2
///```

public class L0169 {
    static class Solution {
        // Use frequency count
        // ❌ cannot be used for negative elements
        public int approachOne(int[] nums) {
            // find length and find ⌊n / 2⌋
            int majority = nums.length / 2;

            int max = Arrays.stream(nums).max().getAsInt();
            int[] freq = new int[max + 1];
            for (int ele : nums) {
                freq[ele]++;
            }

            int majorityElement = 0;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > majority) majorityElement = i;
            }

            return majorityElement;
        }

        // brute force approach
        // Time complexity - O(n^2)
        // Space complexity - O(1)
        public int approachTwo(int[] nums) {
            int len = nums.length;

            for (int num : nums) {
                int count = 0;
                for (int i : nums) {
                    if (num == i) count++;
                }

                if (count > len / 2) return num;
            }

            return -1;
        }

        // better approach - use hashing
        // Time Complexity - O(n) + O(n log n)
        // Space Complexity - O(n)
        public int approachThree(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > n / 2) return entry.getKey();
            }

            return -1;
        }

        // optimal solution - Moore's Voting Algorithm
        // Time Complexity - O(n) + O(n)
        // Space Complexity - O(1)
        public int majorityElement(int[] nums) {
            // size
            int len = nums.length;

            // count for algorithm
            int count = 0;

            // candidate element
            int ele = 0;

            // algorithm loop
            for (int num : nums) {
                if (count == 0) {
                    count = 1;
                    ele = num;
                }
                else if (num == ele) count++;
                else count--;
            }

            // verify majority element
            int count1 = 0;
            for (int num : nums) {
                if (ele == num) count1++;
            }

            // check condition
            if (count1 > len / 2) return ele;

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {6, 5, 5};

        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: majority = " + s.majorityElement(nums));
    }
}
