package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L1901: Find a Peak Element II](https://leetcode.com/problems/find-a-peak-element-ii)
/// ## Level - Medium
/// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
///
/// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element `mat[i][j]` and return the length 2 array `[i,j]`.
///
/// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
///
/// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
///
/// **Example 1:**
/// ```txt
/// Input: mat = [[1,4],[3,2]]
/// Output: [0,1]
/// Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
/// ```
/// **Example 2:**
/// ```txt
/// Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
/// Output: [1,1]
/// Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
/// ```
///
/// **Constraints:**
///
/// - `m == mat.length`
/// - `n == mat[i].length`
/// - `1 <= m, n <= 500`
/// - `1 <= mat[i][j] <= 10^5`
/// - No two adjacent cells are equal.

public class L1901 {
    static class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int n = mat.length; // rows
            int m = mat[0].length; // columns

            int low = 0;
            int high = m - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                // find index of max element
                int row = maxElementIndex(mat, mid);

                // Determine left and right ends
                int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
                int right = mid + 1 < m ? mat[row][mid + 1] : Integer.MIN_VALUE;

                // Check peak element
                if (mat[row][mid] > left && mat[row][mid] > right) {
                    return new int[]{row, mid};
                } else if (left > mat[row][mid]) {
                    high = mid - 1;
                } else low = mid + 1;
            }

            return new int[]{-1, -1};
        }

        private int maxElementIndex(int[][] mat, int mid) {
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    index = i;
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] mat = {{1, 4}, {3, 2}};
        System.out.println("Input: mat = " + Arrays.deepToString(mat));
        int[] res = s.findPeakGrid(mat);
        System.out.println("Output: " + Arrays.toString(res));
    }
}
