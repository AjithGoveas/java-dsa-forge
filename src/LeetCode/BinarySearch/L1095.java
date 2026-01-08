package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1095: Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array/)
/// ## Level - Hard
/// ### (This problem is an interactive problem.)
///
/// You may recall that an array arr is a mountain array if and only if:
///
/// - `arr.length >= 3`
/// - There exists some `i` with `0 < i < arr.length - 1` such that:
///     - `arr[0] < arr[1] < ... < arr[i-1] < arr[i]`
///     - `arr[i] > arr[i+1] > ... > arr[arr.length-1]`
/// Given a mountain array `mountainArr`, return the **minimum** `index` such that `mountainArr.get(index) == target`. If such an `index` does not exist, return `-1`.
///
/// **You cannot access the mountain array directly.** You may only access the array using a `MountainArray` interface:
///
/// - `MountainArray.get(k)` returns the element of the array at index `k` (0-indexed).
/// - `MountainArray.length()` returns the length of the array.
///
/// Submissions making more than `100` calls to `MountainArray.get` will be judged _Wrong Answer_. Also, any solutions that attempt to circumvent the judge will result in disqualification.
///
/// **Example 1:**
/// ```txt
/// Input: mountainArr = [1,2,3,4,5,3,1], target = 3
/// Output: 2
/// Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: mountainArr = [0,1,2,4,2,1], target = 3
/// Output: -1
/// Explanation: 3 does not exist in the array, so we return -1.
/// ```

public class L1095 {
    /// ## This is MountainArray's API interface.
    /// ### You should not implement it, or speculate about its implementation
    /// ```
    /// interface MountainArray {
    ///     public int get(int index) {}
    ///     public int length() {}
    /// }
    /// ```
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    // Concrete implementation for testing
    static class MountainArrayImpl implements MountainArray {
        private int[] arr;

        public MountainArrayImpl(int[] arr) {
            this.arr = arr;
        }

        @Override
        public int get(int index) {
            return arr[index];
        }

        @Override
        public int length() {
            return arr.length;
        }
    }

    static class Solution {

        public int findInMountainArray(int target, MountainArray mountainArr) {
            int peakIndex = peakElement(mountainArr);
            if (mountainArr.get(peakIndex) == target) return peakIndex;
            int leftSide = binarySearch(target, mountainArr, 0, peakIndex - 1);
            return leftSide != -1 ? leftSide : binarySearch(target, mountainArr, peakIndex + 1, mountainArr.length() - 1);
        }

        // Optimal approach - O(log n) complexity
        public int peakElement(MountainArray mountainArr) {
            int low = 0, high = mountainArr.length() - 1;

            while (low < high) {     // try to run until low = high => low or high determines max element
                int mid = low + (high - low) / 2;

                if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
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

        public int binarySearch(int target, MountainArray mountainArr, int low, int high) {
            boolean isAsc = mountainArr.get(low) < mountainArr.get(high);
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mountainArr.get(mid) == target) return mid;
                if (isAsc) {
                    if (mountainArr.get(mid) > target) high = mid - 1;
                    else low = mid + 1;
                } else {
                    if (mountainArr.get(mid) > target) low = mid + 1;
                    else high = mid - 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 5, 3, 1};
        int target = 1;

        MountainArrayImpl mountainArray = new MountainArrayImpl(arr);
        Solution solution = new Solution();

        int res = solution.findInMountainArray(target, mountainArray);

        System.out.println("Input: arr = " + Arrays.toString(arr));
        System.out.println("Output: res = " + res);
    }
}
