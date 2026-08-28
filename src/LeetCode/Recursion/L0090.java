package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// # [L0090: Subsets II](https://leetcode.com/problems/subsets-ii)
/// **Level:** Medium | **Pattern:** Backtracking (include / exclude, skip duplicates) | **TC / SC:** O(N * 2^N) / O(N)
/// **Trigger:** "subsets II", "may contain duplicates", "unique subsets", "power set with duplicates"
/// **Traps:** Must sort first; `i > start && nums[i] == nums[i-1]` skips duplicate branches; empty subset `[]` is valid
///
/// Given an integer array `nums` that **may contain duplicates**, return all possible subsets (the power set).
///
/// The solution set must not contain duplicate subsets. Return the solution in any order.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [1,2,2]
/// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
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

public class L0090 {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
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

        int[] nums1 = {1, 2, 2};
        System.out.println("Input: nums = [1,2,2]");
        System.out.println("Output: " + s.subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println("Input: nums = [0]");
        System.out.println("Output: " + s.subsetsWithDup(nums2));
    }
}
