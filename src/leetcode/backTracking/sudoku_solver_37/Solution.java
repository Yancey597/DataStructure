package leetcode.backTracking.sudoku_solver_37;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-13-20:34
 * @url https://leetcode.cn/problems/sudoku-solver/description/
 * @description 编写一个程序，通过填充空格来解决数独问题。
 */

public class Solution {
    public static void main(String[] args) {
        char[][] chessBoard = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution().solveSudoku(chessBoard);
    }

    public void solveSudoku(char[][] board) {
        backTracking(board);
    }

    private boolean backTracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') { // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isVailed(i, j, k, board)) {
                        board[i][j] = k;
                        if (backTracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                return false;
            }
        }
        return true;
    }

    public boolean isVailed(int row, int col, char num, char[][] board) {
        // 判断当前行是否有重复的
        for (int i = 0; i < 9; i++) {
            if (num == board[row][i]) {
                return false;
            }
        }

        // 判断当前列是否有重复的
        for (int i = 0; i < 9; i++) {
            if (num == board[i][col]) {
                return false;
            }
        }

        //判断当前九宫格内是否有重复的
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;


        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
