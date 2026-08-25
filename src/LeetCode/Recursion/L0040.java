package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// # [L0040: Combination Sum II](https://leetcode.com/problems/combination-sum-ii)
/// **Level:** Medium | **Pattern:** Backtracking (pick / not-pick, no reuse, skip duplicates) | **TC / SC:** O(2^N) / O(N)
/// **Trigger:** "combination sum II", "each number used once", "unique combinations", "skip duplicates"
/// **Traps:** Candidates may contain duplicates (sort + skip `i > idx && candidates[i] == candidates[i-1]`); each number used only once (`i + 1`); early break when `candidates[i] > target`
///
/// Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all
/// **unique combinations** in `candidates` where the candidate numbers sum to `target`.
///
/// Each number in `candidates` may **only be used once** in the combination.
///
/// **Note:** The solution set must not contain duplicate combinations.
///
/// **Example 1:**
/// ```txt
/// Input: candidates = [10,1,2,7,6,1,5], target = 8
/// Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
/// ```
/// **Example 2:**
/// ```txt
/// Input: candidates = [2,5,2,1,2], target = 5
/// Output: [[1,2,2],[5]]
/// ```
///
/// **Constraints:**
///
/// - `1 <= candidates.length <= 100`
/// - `1 <= candidates[i] <= 50`
/// - `1 <= target <= 30`

public class L0040 {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> list = new ArrayList<Integer>();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            recursive(candidates, target, 0, list, res);
            return res;
        }

        private void recursive(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1])
                    continue;

                if (candidates[i] > target)
                    break;

                list.add(candidates[i]);
                recursive(candidates, target - candidates[i], i + 1, list, res);
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] c1 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println("Input: candidates = [10,1,2,7,6,1,5], target = 8");
        System.out.println("Output: " + s.combinationSum2(c1, 8));

        int[] c2 = {2, 5, 2, 1, 2};
        System.out.println("Input: candidates = [2,5,2,1,2], target = 5");
        System.out.println("Output: " + s.combinationSum2(c2, 5));
    }
}
