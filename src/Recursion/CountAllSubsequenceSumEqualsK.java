package Recursion;

import java.util.ArrayList;
import java.util.List;

/// # Count All Subsequences with Sum K
/// **Level:** Medium | **Pattern:** Recursion (pick / not-pick) | **TC / SC:** O(2^N) / O(N)
/// **Trigger:** "count subsequences with sum k", "subset sum count", "pick or not pick"
/// **Traps:** Empty subsequence should not be counted; duplicate elements may produce duplicate subsequences; negative numbers complicate counting
///
/// Given an array `nums` and an integer `k`, return the **number of non-empty subsequences** of `nums`
/// such that the sum of all elements in the subsequence is equal to `k`.
///
/// **Example 1:**
/// ```txt
/// Input: nums = [4, 9, 2, 5, 1], k = 10
/// Output: 2
/// Explanation: The possible subsets with sum k are [9, 1] , [4, 5, 1].
/// ```
/// **Example 2:**
/// ```txt
/// Input: nums = [4, 2, 10, 5, 1, 3], k = 5
/// Output: 3
/// Explanation: The possible subsets with sum k are [4, 1] , [2, 3] , [5].
/// ```
///
/// **Constraints:**
///
/// - `1 <= nums.length <= 20`
/// - `1 <= nums[i] <= 1000`
/// - `1 <= k <= 1000`

public class CountAllSubsequenceSumEqualsK {
    static class Solution {
        // pick / not-pick recursion counting subsequences with sum == k
        public int approachOne(int[] nums, int k) {
            // YOUR CODE
            int n = nums.length;
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            recursive(nums, k, 0, n, sum, list, res);
            System.out.println("Subsequences: " + res);
            return res.size();
        }
        private void recursive(int[] nums, int k, int idx, int n, int sum, List<Integer> list, List<List<Integer>> res) {
            if (idx == n) {
                if(k == sum) {
                    res.add(new ArrayList<>(list));
                }
                return;
            }

            // Pick
            list.add(nums[idx]);
            sum += nums[idx];
            recursive(nums, k, idx + 1, n, sum, list, res);

            // Not pick
            sum -= nums[idx];
            list.removeLast();
            recursive(nums, k, idx + 1, n, sum, list, res);
        }

        public int countSubsequenceSum(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            return func(nums, k, 0, n, sum);
        }
        private int func(int[] nums, int k, int idx, int n, int sum) {
            if(idx == n) {
                if(k == sum) return 1;
                return 0;
            }

            sum += nums[idx];
            int l =  func(nums, k, idx + 1, n, sum);

            sum -= nums[idx];
            int r = func(nums, k, idx + 1, n, sum);

            return l + r;
        }

        // TODO: Implement — alternative approach (e.g. memoization / tabulation)
        public int approachTwo(int[] nums, int k) {
            // YOUR CODE HERE
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {4, 9, 2, 5, 1};
        int k1 = 10;
        System.out.println("Input: nums = [4, 9, 2, 5, 1], k = " + k1);
        System.out.println("Output: " + s.countSubsequenceSum(nums1, k1));

        int[] nums2 = {4, 2, 10, 5, 1, 3};
        int k2 = 5;
        System.out.println("Input: nums = [4, 2, 10, 5, 1, 3], k = " + k2);
        System.out.println("Output: " + s.countSubsequenceSum(nums2, k2));
    }
}
