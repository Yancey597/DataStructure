package leetcode.dynamicplanning.uniquepaths_62;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-26-23:20
 * @description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 走到 (i, j) 有多少种走法
        int[][] dp = new int[m + 10][n + 10];

        // dp[i][j] 只能通过上下走到
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]

        // dp[i][j-1] 需要有意义
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // dp[i-1][j] 需要有意义
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // dp[i-1][j] dp[i][j-1] 都是从上往下，从左往右的
        return dp[m - 1][n - 1];
    }
}
