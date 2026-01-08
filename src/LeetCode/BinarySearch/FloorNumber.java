package LeetCode.BinarySearch;

import java.util.Arrays;

/// # Floor Number of the Given Digit
///
/// ## Level: Easy
///
/// Given a sorted array `arr` of integers, return **floor number** of the `target`.
///
/// **Floor:** element in the array that is smaller than or equal and nearest to the given target.
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
/// Output: 14
/// Explanation:
/// 15 is not present but the nearest number to 15 is 14.
/// ```
/// **Example 3:**
/// ```
/// Input: arr = [2, 3, 5, 9, 14, 16, 18]   target = 19
/// Output: 18
/// Explanation:
/// Floor Number of target 19 lies within the limit of array and hence returns 18.
/// ```

public class FloorNumber {

    static class Solution {
        public int floorNumber(int[] arr, int target) {
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

            return (high < 0) ? -1 : arr[high];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;

        System.out.println("Input: arr = " + Arrays.toString(arr) + ", target = " + target);
        System.out.println("Output: " + solution.floorNumber(arr, target));
    }
}