package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0852: Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)
/// ## Level - Medium
///
/// You are given an integer **mountain** array `arr` of length `n` where the values increase to a **peak element** and then decrease.
///
/// Return the index of the peak element.
///
/// Your task is to solve it in `O(log(n))` time complexity.
///
/// **Example 1:**
/// ```
/// Input: arr = [0,1,0]
/// Output: 1
///```
///
/// **Example 2:**
/// ```
/// Input: arr = [0,2,1,0]
/// Output: 1
///```
///
/// **Example 3:**
/// ```
/// Input: arr = [0,10,5,2]
/// Output: 1
///```

public class L0852 {

    static class Solution {

        // this is brute force approach - O(n) complexity
        public int bruteForce(int[] arr) {
            int arrLen = arr.length;
            int maxIndex = 0;

            for (int i = 0; i <= arrLen / 2; i++) {
                if (arr[i] > arr[maxIndex]) maxIndex = i;
            }
            return maxIndex;
        }

        // Optimal approach - O(log n) complexity
        public int peakIndexInMountainArray(int[] arr) {
            int low = 0, high = arr.length - 1;

            while(low < high) {     // try to run until low = high => low or high determines max element
                int mid = low + (high - low) / 2;

                if (arr[mid] > arr[mid + 1] ) {
                    // we are in decreasing part of the array
                    // search at the left
                    high = mid;
                } else {
                    // we are in the increasing part of the array
                    // search at the right
                    low = mid + 1;
                }
            }

            return low; // or return high i.e. max element
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0, 1, 2, 5, 6, 7, 15, 10, 5, 3, 2, 1, 0, -1};
        int res = solution.peakIndexInMountainArray(arr);

        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Output: res = " + res);
    }
}
