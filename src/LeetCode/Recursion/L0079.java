package LeetCode.Recursion;

/// # [L0079: Word Search](https://leetcode.com/problems/word-search)
/// **Level:** Medium | **Pattern:** Backtracking on 2D grid (DFS + mark visited) | **TC / SC:** O(M * N * 4^L) / O(L)
/// **Trigger:** "word search", "grid DFS", "backtracking on 2D board", "sequential adjacent cells"
/// **Traps:** Same cell cannot be reused (mark `#` and restore); boundary checks on all 4 directions; early return on first match; `word.length() > m*n` → impossible
///
/// Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.
///
/// The word can be constructed from letters of **sequentially adjacent cells**, where adjacent cells are
/// **horizontally or vertically** neighboring. The same letter cell **may not be used more than once**.
///
/// **Example 1:**
/// ```txt
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
/// Output: true
/// ```
/// **Example 2:**
/// ```txt
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
/// Output: true
/// ```
/// **Example 3:**
/// ```txt
/// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
/// Output: false
/// ```
///
/// **Constraints:**
///
/// - `m == board.length`
/// - `n == board[i].length`
/// - `1 <= m, n <= 6`
/// - `1 <= word.length <= 15`
/// - `board` and `word` consist of only uppercase and lowercase English letters.

public class L0079 {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int idx) {
            if (idx == word.length()) return true;

            // Boundary conditions
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
                return false;
            }

            char temp = board[i][j];
            // Mark visited
            board[i][j] = '#';

            boolean found = dfs(board, word, i + 1, j, idx + 1) ||      // down
                            dfs(board, word, i - 1, j, idx + 1) ||      // up
                            dfs(board, word, i, j + 1, idx + 1) ||      // right
                            dfs(board, word, i, j - 1, idx + 1);        // left

            // Restore visited
            board[i][j] = temp;

            return found;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println("Input: word = \"ABCCED\"");
        System.out.println("Output: " + s.exist(board1, "ABCCED"));

        char[][] board2 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println("Input: word = \"SEE\"");
        System.out.println("Output: " + s.exist(board2, "SEE"));

        char[][] board3 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println("Input: word = \"ABCB\"");
        System.out.println("Output: " + s.exist(board3, "ABCB"));
    }
}
