package leetcode.prefixsum.rangesum_query2d;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-23-22:13
 * @url https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
 * @description 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 */

public class Solution {

}

class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            prefixSum = new int[m + 1][n + 1];
            prefixSum[0][0] = 0;
            for (int row = 1; row <= m; row++) {
                for (int col = 1; col <= n; col++) {
                    prefixSum[row][col] = prefixSum[row - 1][col] + prefixSum[row][col - 1] - prefixSum[row - 1][col - 1] + matrix[row - 1][col - 1];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        return prefixSum[row2][col2] - prefixSum[row2][col1 - 1] - prefixSum[row1 - 1][col2] + prefixSum[row1 - 1][col1 - 1];
        // 题目中的 查询下标从 0 开始，对应的位置都加上 1
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1] - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }

}
