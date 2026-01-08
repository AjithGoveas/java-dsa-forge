package LeetCode.BinarySearch;

import java.util.Arrays;

///  # [Find position of an element in a sorted array of infinite numbers](https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/)

public class PositionInInfiniteArray {
    static class Solution {
        public int searchPosition(int[] arr, int target) {
            int start = 0;
            int end = 1;

            // find the search space
            while (target > arr[end]) {
                int tempStart = end + 1; // next position to the current end

                // the window size
                int windowSize = end - start + 1;
                end = end + windowSize * 2;     // new end lies double window size from the current end
                start = tempStart;
            }

            return binarySearch(arr, target, start, end);
        }

        // do binary search with custom start and end i.e. custom-sized window
        public int binarySearch(int[] arr, int target, int start, int end) {
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (target == arr[mid]) return mid;
                else if (target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Assume infinite array => don't use '.length'
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        // target 160 causes ArrayIndexOutOfBoundsException because the end lies out of the array we created.
        // There exists an edge case of the above type i.e. the element lies near to the end of the array.
        // Try to solve this edge case.

        int ans = solution.searchPosition(arr, target);

        System.out.println("Input: arr = " + Arrays.toString(arr) + ", target = " + target);
        System.out.println("Output = " + ans);
    }
}
