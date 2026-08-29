package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// # [L0051: N-Queens](https://leetcode.com/problems/n-queens)
/// **Level:** Hard | **Pattern:** Backtracking on chessboard (row-by-row + safety check) | **TC / SC:** O(N!) / O(N²)
/// **Trigger:** "n-queens", "place queens so none attack", "backtracking on board", "column-by-column placement"
/// **Traps:** Check 3 directions only (left, upper-left, lower-left) since we fill left-to-right; `N=1` → `[["Q"]]`; `N=2,3` → no solution
///
/// The n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.
///
/// Given an integer `n`, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
///
/// Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'`
/// both indicate a queen and an empty space, respectively.
///
/// **Example 1:**
/// ```txt
/// Input: n = 4
/// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
/// Explanation: There exist two distinct solutions to the 4-queens puzzle.
/// ```
/// **Example 2:**
/// ```txt
/// Input: n = 1
/// Output: [["Q"]]
/// ```
///
/// **Constraints:**
///
/// - `1 <= n <= 9`
///
/// **Note:** This is the brute-force backtracking solution. Can be optimised further using
/// bitmasking or DP on rows/diagonals for faster pruning.

public class L0051 {
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] board = new char[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }

            // Solve using backtracking — place queens column by column
            solve(0, board, res, n);
            return res;
        }

        private void solve(int col, char[][] board, List<List<String>> res, int n) {
            // All columns are filled — found a valid arrangement
            if (col == n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(new String(board[i]));
                }
                res.add(list);
                return;
            }

            // Try placing a queen in each row of this column
            for (int row = 0; row < n; row++) {
                if (isSafe(row, col, board, n)) {
                    board[row][col] = 'Q';       // place queen
                    solve(col + 1, board, res, n); // recurse to next column
                    board[row][col] = '.';       // backtrack
                }
            }
        }

        private boolean isSafe(int row, int col, char[][] board, int n) {
            // Check left in the same row
            for (int j = 0; j < col; j++) {
                if (board[row][j] == 'Q') return false;
            }

            // Check upper-left diagonal
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') return false;
            }

            // Check lower-left diagonal
            for (int i = row, j = col; i < n && j >= 0; i++, j--) {
                if (board[i][j] == 'Q') return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("Input: n = 4");
        System.out.println("Output: " + s.solveNQueens(4));

        System.out.println("Input: n = 1");
        System.out.println("Output: " + s.solveNQueens(1));
    }
}
