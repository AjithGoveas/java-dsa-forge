package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L0039: Combination Sum](https://leetcode.com/problems/combination-sum)
/// **Level:** Medium | **Pattern:** Backtracking (pick / not-pick, unlimited reuse) | **TC / SC:** O(N^(T/M)) / O(T/M)
/// **Trigger:** "combination sum", "unlimited reuse", "candidates sum to target", "unique combinations"
/// **Traps:** Same number can be reused (recurse at same index); skip duplicates by moving index forward; sort candidates to prune early
///
/// Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all
/// **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the
/// combinations in any order.
///
/// The same number may be chosen from `candidates` an **unlimited number of times**. Two combinations are
/// unique if the frequency of at least one of the chosen numbers is different.
///
/// **Example 1:**
/// ```txt
/// Input: candidates = [2,3,6,7], target = 7
/// Output: [[2,2,3],[7]]
/// Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
///              7 is a candidate, and 7 = 7.
///              These are the only two combinations.
/// ```
/// **Example 2:**
/// ```txt
/// Input: candidates = [2,3,5], target = 8
/// Output: [[2,2,2,2],[2,3,3],[3,5]]
/// ```
/// **Example 3:**
/// ```txt
/// Input: candidates = [2], target = 1
/// Output: []
/// ```
///
/// **Constraints:**
///
/// - `1 <= candidates.length <= 30`
/// - `2 <= candidates[i] <= 40`
/// - All elements of `candidates` are **distinct**.
/// - `1 <= target <= 40`

public class L0039 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> list = new ArrayList<Integer>();
            List<List<Integer>> res = new ArrayList<>();

            recursive(candidates, target, 0, list, res);
            return res;
        }

        private void recursive(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> res) {
            if (idx == candidates.length) {
                if (target == 0) {
                    res.add(new ArrayList<>(list));
                }
                return;
            }

            if (candidates[idx] <= target) {
                list.add(candidates[idx]);
                recursive(candidates, target - candidates[idx], idx, list, res);
                list.removeLast();
            }

            recursive(candidates, target, idx + 1, list, res);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] c1 = {2, 3, 6, 7};
        System.out.println("Input: candidates = [2,3,6,7], target = 7");
        System.out.println("Output: " + s.combinationSum(c1, 7));

        int[] c2 = {2, 3, 5};
        System.out.println("Input: candidates = [2,3,5], target = 8");
        System.out.println("Output: " + s.combinationSum(c2, 8));

        int[] c3 = {2};
        System.out.println("Input: candidates = [2], target = 1");
        System.out.println("Output: " + s.combinationSum(c3, 1));
    }
}
