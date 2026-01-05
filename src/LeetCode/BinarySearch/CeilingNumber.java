package LeetCode.BinarySearch;

import java.util.Arrays;

/// # Ceiling Number of the Given Digit
///
/// ## Level: Easy
///
/// Given a sorted array `arr` of integers, return **ceiling number** of the `target`.
///
/// **Ceiling:** element in the array that is greater than or equal and nearest to the given target.
///
/// **Example 1:**
/// ```
/// Input: arr = [2, 3, 5, 9, 14, 16, 18]   target = 14
/// Output: 14
/// Explanation:
/// 14 is present in the array, which is also nearest to the target 14.
/// ```
///
/// **Example 2:**
/// ```
/// Input: arr = [2, 3, 5, 9, 14, 16, 18]   target = 15
/// Output: 16
/// Explanation:
/// 15 is not present but the nearest number to 15 is 16.
/// ```
/// **Example 3:**
/// ```
/// Input: arr = [2, 3, 5, 9, 14, 16, 18]   target = 19
/// Output: -1
/// Explanation:
/// Target 19 exceeds the limit of array and hence returns -1.
/// ```

public class CeilingNumber {

    static class Solution {
        public int ceilingNumber(int[] arr, int target) {
            if (arr.length == 0) return -1;

            int low = 0;
            int high = arr.length - 1;
            int mid;

            while (low <= high) {
                mid = low + (high - low) / 2;

                if (target == arr[mid]) return arr[mid];
                else if (target > arr[mid]) low = mid + 1;
                else high = mid - 1;
            }

            return (low > arr.length -1) ? -1 : arr[low];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = -1;

        System.out.println("Input: arr = " + Arrays.toString(arr) + ", target = " + target);
        System.out.println("Output: " + solution.ceilingNumber(arr, target));
    }
}