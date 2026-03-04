package LeetCode.BinarySearch;

import java.util.Arrays;

/// # [L0074: Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix)
/// ## Level - Medium
/// You are given an m x n integer matrix `matrix` with the following two properties:
///
/// Each row is sorted in non-decreasing order.
/// The first integer of each row is greater than the last integer of the previous row.
/// Given an integer target, return true if target is in matrix or false otherwise.
///
/// You must write a solution in O(log(m * n)) time complexity.
///
/// **Example 1:**
/// ```txt
/// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
/// Output: true
/// ```
/// **Example 2:**
/// ```txt
/// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
/// Output: false
/// ```
///
/// **Constraints:**
///
/// - `m == matrix.length`
/// - `n == matrix[i].length`
/// - `1 <= m, n <= 100`
/// - `-10^4 <= matrix[i][j], target <= 10^4`

public class L0074 {
    static class Solution {
        // Brute force
        // Function to search for a target value in the matrix
        public boolean approachOne(int[][] matrix, int target) {
            // Get number of columns in the matrix
            int m = matrix[0].length;

            // Traverse each row
            for (int[] ints : matrix) {
                // Traverse each column in the current row
                for (int j = 0; j < m; j++) {
                    // Check if the current element matches the target
                    if (ints[j] == target)
                        return true;
                }
            }

            // Return false if the target is not found
            return false;
        }

        // Better Approach
        // Function to search for target in a 2D matrix
        public boolean approachTwo(int[][] matrix, int target) {
            // Get the number of columns
            int m = matrix[0].length;

            // Traverse each row
            for (int[] ints : matrix) {
                // Check if target could be in this row
                if (ints[0] <= target && target <= ints[m - 1]) {
                    // Perform binary search on this row
                    return binarySearch(ints, target);
                }
            }

            // Return false if target is not found
            return false;
        }

        // Function to perform binary search on a 1D array
        public boolean binarySearch(int[] nums, int target) {
            // Get the length of the array
            int n = nums.length;

            // Initialize low and high pointers
            int low = 0, high = n - 1;

            // Perform binary search
            while (low <= high) {
                // Calculate the middle index
                int mid = low + (high - low) / 2;

                // If the middle element is the target, return true
                if (nums[mid] == target)
                    return true;

                    // If target is greater, search in the right half
                else if (target > nums[mid])
                    low = mid + 1;

                    // Otherwise, search in the left half
                else
                    high = mid - 1;
            }

            // Return false if target is not found
            return false;
        }

        // Optimal Approach
        // Function to search target in 2D matrix using binary search
        public boolean searchMatrix(int[][] matrix, int target) {
            // Get the number of rows
            int n = matrix.length;

            // Get the number of columns
            int m = matrix[0].length;

            // Set initial binary search range
            int low = 0, high = n * m - 1;

            // Perform binary search
            while (low <= high) {
                // Calculate middle index
                int mid = low + (high - low) / 2;

                // Map 1D index to 2D coordinates
                int row = mid / m;
                int col = mid % m;

                // Check if target is found
                if (matrix[row][col] == target)
                    return true;

                    // Discard left half
                else if (matrix[row][col] < target)
                    low = mid + 1;

                    // Discard right half
                else
                    high = mid - 1;
            }

            // Target not found
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int target = 9;

        Solution obj = new Solution();
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix) + ", target = " + target);

        boolean res = obj.searchMatrix(matrix, target);
        System.out.println("Output: " + res);
    }
}
