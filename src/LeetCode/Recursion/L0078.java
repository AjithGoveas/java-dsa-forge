package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L0078: Subsets](https://leetcode.com/problems/subsets)
/// **Level:** Medium | **Pattern:** Backtracking (include / exclude, power set) | **TC / SC:** O(N * 2^N) / O(N)
/// **Trigger:** "subsets", "power set", "all possible subsets", "include or exclude"
/// **Traps:** Empty subset `[]` is valid; sort to skip duplicates (if any); `i > start && nums[i] == nums[i-1]` avoids duplicate subsets
///
/// Given an integer array `nums` of **unique** elements, return all possible subsets (the power set).
///
/// The solution set must not contain duplicate subsets. Return the solution in any order.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,2,3]
/// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [0]
/// Output: [[],[0]]
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 10`
/// - `-10 <= nums[i] <= 10`
/// - All the numbers of `nums` are **unique**.

public class L0078 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, 0, res, new ArrayList<>());
            return res;
        }

        private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
            res.add(new ArrayList<>(list));

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;

                list.add(nums[i]);
                backtrack(nums, i + 1, res, list);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.println("Input: nums = [1,2,3]");
        System.out.println("Output: " + s.subsets(nums1));

        int[] nums2 = {0};
        System.out.println("Input: nums = [0]");
        System.out.println("Output: " + s.subsets(nums2));
    }
}
