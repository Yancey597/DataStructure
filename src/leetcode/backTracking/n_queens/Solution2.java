package leetcode.backTracking.n_queens;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution2
 * @date 2024-03-12-18:31
 * @description 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */

public class Solution2 {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        backTracking(0, n, chessBoard);

        return res;
    }

    private void backTracking(int row, int n, char[][] chessBoard) {
        if (row == n) {
            res.add(charToList(chessBoard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isVailed(row, col, n, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTracking(row + 1, n, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    private boolean isVailed(int row, int col, int n, char[][] chessBoard) {
        // 判断当前列是否合法
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
        }

        // 判断当前 45° 对角线是否有 Q
        for (int i = row - 1, j = col - 1; j >= 0 && i >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 判断当前 135° 对角线是否有 Q
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    private List<String> charToList(char[][] chessBoard) {
        List list = new ArrayList();
        for (char[] chars : chessBoard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }
}
