package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

/// # [L0216: Combination Sum III](https://leetcode.com/problems/combination-sum-iii)
/// **Level:** Medium | **Pattern:** Backtracking (pick / not-pick, bounded range 1-9) | **TC / SC:** O(C(9, K)) / O(K)
/// **Trigger:** "combination sum III", "k numbers sum to n", "numbers 1 through 9", "each number used once"
/// **Traps:** Numbers restricted to 1-9; each used at most once; break early when `i > sum`; exactly `k` elements required
///
/// Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:
///
/// - Only numbers **1 through 9** are used.
/// - Each number is used **at most once**.
///
/// Return a list of all possible valid combinations. The list must not contain the same combination twice,
/// and the combinations may be returned in any order.
///
/// **Example 1:**
/// ```txt
/// Input: k = 3, n = 7
/// Output: [[1,2,4]]
/// Explanation: 1 + 2 + 4 = 7. There are no other valid combinations.
/// ```
/// **Example 2:**
/// ```txt
/// Input: k = 3, n = 9
/// Output: [[1,2,6],[1,3,5],[2,3,4]]
/// Explanation: 1 + 2 + 6 = 9, 1 + 3 + 5 = 9, 2 + 3 + 4 = 9.
/// ```
/// **Example 3:**
/// ```txt
/// Input: k = 4, n = 1
/// Output: []
/// Explanation: Using 4 different numbers in [1,9], the smallest sum is 1+2+3+4 = 10 > 1.
/// ```
///
/// **Constraints:**
///
/// - `2 <= k <= 9`
/// - `1 <= n <= 60`

public class L0216 {
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            backtrack(k, n, list, res, n, 1);
            return res;
        }

        private void backtrack(int k, int n, List<Integer> list, List<List<Integer>> res, int sum, int last) {
            // Base Case: If the sum is zero and the number of elements is k
            if (sum == 0 && list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }

            // If the sum is less than or equal to zero or the number of elements exceeds k
            if (sum <= 0 || list.size() > k) return;

            // Iterate from the last number to 9
            for (int i = last; i <= 9; i++) {
                if (i <= sum) {
                    list.add(i);
                    backtrack(k, n, list, res, sum - i, i + 1);
                    list.removeLast();
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("Input: k = 3, n = 7");
        System.out.println("Output: " + s.combinationSum3(3, 7));

        System.out.println("Input: k = 3, n = 9");
        System.out.println("Output: " + s.combinationSum3(3, 9));

        System.out.println("Input: k = 4, n = 1");
        System.out.println("Output: " + s.combinationSum3(4, 1));
    }
}
