package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1539: Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number)
/// ## Level - Easy
/// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
///
/// Return the kth positive integer that is missing from this array.
///
/// **Example 1:**
/// ```txt
/// Input: arr = [2,3,4,7,11], k = 5
/// Output: 9
/// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
/// ```
/// **Example 2:**
/// ```txt
/// Input: arr = [1,2,3,4], k = 2
/// Output: 6
/// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
/// ```
///
/// **Constraints:**
///
/// - `1 <= arr.length <= 1000`
/// - `1 <= arr[i] <= 1000`
/// - `1 <= k <= 1000`
/// - `arr[i] < arr[j] for 1 <= i < j <= arr.length`

public class L1539 {
    static class Solution {
        // Brute Force
        // Method to find the k-th missing number
        public int approachOne(int[] vec, int k) {
            for (int j : vec) {
                if (j <= k) {
                    k++;  // Skip current number and adjust k
                } else {
                    break; // Stop if current number is greater than k
                }
            }
            return k;
        }

        // Optimal Approach
        public int findKthPositive(int[] arr, int k) {
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                int missing = arr[mid] - (mid + 1);

                if (missing < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return k + high + 1;
        }

        public static void main(String[] args) {
            int[] arr = {4, 7, 9, 10};
            int k = 4;

            Solution finder = new Solution();
            System.out.println("Input: arr = " + Arrays.toString(arr) + ", k = " + k);
            int ans = finder.findKthPositive(arr, k);

            System.out.println("Output: " + ans);
        }
    }
}
