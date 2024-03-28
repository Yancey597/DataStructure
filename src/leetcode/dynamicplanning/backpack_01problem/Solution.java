package leetcode.dynamicplanning.backpack_01problem;//import org.junit.Test;


import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-28-20:34
 * @description 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int m = scan.nextInt();
        int m = 3;
        int n = 4;
//        int n =scan.nextInt();
        int[] weight = {2, 3, 4};
//        int[] weight = new int[m];
//        int[] value = new int[m];
        int[] value = {3, 4, 5};

//        for (int i = 0; i < m; i++) {
//            weight[i] = scan.nextInt();
//        }
//
//        for (int i = 0; i < m; i++) {
//            value[i] = scan.nextInt();
//        }
        int values = maxValue(value, weight, n);
        System.out.println("values = " + values);
        scan.close();
    }

    private static int maxValue(int[] values, int[] weights, int size) {
        // 装入[0,j] 的物品到 容量为 j的背包里的最大价值
        int m = values.length;
        int[][] dp = new int[m + 1][size + 1];

        // 装或者不装 weight[i]
//        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + values[i])
        // 需要知道其左侧的值和上方的值
        for (int i = weights[0]; i <= size; i++) {
            dp[0][i] = values[0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= size; j++) {
                if (weights[i] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m - 1][size];
    }
}
