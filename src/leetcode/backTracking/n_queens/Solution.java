package leetcode.backTracking.n_queens;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-11-20:08
 * @description TODO
 */

public class Solution {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backTracking(n, 0, chessboard);
        return res;
    }

    private void backTracking(int n, int row, char[][] chessBoard) {
        if (n == row) {
            res.add(new ArrayList(toArrayList(chessBoard)));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isVailed(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTracking(n, row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }

    }

    private boolean isVailed(int row, int col, int n, char[][] chessBoard) {
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i++, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> toArrayList(char[][] chessBoard) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
