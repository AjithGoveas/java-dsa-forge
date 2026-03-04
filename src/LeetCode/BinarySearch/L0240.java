package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0240: Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii)
/// Medium
/// Write an efficient algorithm that searches for a value target in an m x n integer matrix `matrix`. This matrix has the following properties:
///
/// Integers in each row are sorted in ascending from left to right.
/// Integers in each column are sorted in ascending from top to bottom.
///
/// **Example 1:**
/// ```txt
/// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
/// Output: true
/// ```
/// **Example 2:**
/// ```txt
/// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
/// Output: false
/// ```
///
/// **Constraints:**
///
/// - `m == matrix.length`
/// - `n == matrix[i].length`
/// - `1 <= n, m <= 300`
/// - `-10^9 <= matrix[i][j] <= 10^9`
/// - `All the integers in each row are sorted in ascending order.`
/// - `All the integers in each column are sorted in ascending order.`
/// - `-10^9 <= target <= 10^9`

public class L0240 {
    static class Solution {
        // Brute Force
        // Function to search a target element in the matrix
        public boolean approachOne(int[][] matrix, int target) {
            int n = matrix.length;       // Number of rows
            int m = matrix[0].length;    // Number of columns

            // Loop through all rows
            for (int i = 0; i < n; i++) {
                // Loop through all columns in the current row
                for (int j = 0; j < m; j++) {
                    // If we find the target, return true immediately
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
            // Target not found after checking all elements
            return false;
        }

        // Better Approach
        // Search target in matrix using binary search on each row
        public boolean approachTwo(int[][] matrix, int target) {
            for (int[] ints : matrix) {
                if (binarySearch(ints, target)) {
                    return true; // Found in current row
                }
            }
            return false; // Not found in any row
        }

        // Binary search helper function for 1D array
        private boolean binarySearch(int[] nums, int target) {
            int low = 0, high = nums.length - 1;

            // Binary search loop
            while (low <= high) {
                int mid = (low + high) / 2;

                if (nums[mid] == target) {
                    return true; // Found target
                } else if (target > nums[mid]) {
                    low = mid + 1; // Move to the right half
                } else {
                    high = mid - 1; // Move to the left half
                }
            }
            return false; // Target not found
        }

        // Optimal Approach
        // Function to search target using staircase search
        public boolean searchElement(int[][] matrix, int target) {
            int n = matrix.length;        // Number of rows
            int m = matrix[0].length;     // Number of columns

            int row = 0;           // Start at first row
            int col = m - 1;       // Start at last column (top-right)

            // Traverse while within matrix bounds
            while (row < n && col >= 0) {
                if (matrix[row][col] == target) {
                    return true; // Found target
                } else if (matrix[row][col] < target) {
                    row++; // Move down
                } else {
                    col--; // Move left
                }
            }

            return false; // Target not found
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;

        Solution solution = new Solution();
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix) + ", target = " + target);

        boolean found = solution.searchElement(matrix, target);
        System.out.println("Output: " + found);
    }
}
