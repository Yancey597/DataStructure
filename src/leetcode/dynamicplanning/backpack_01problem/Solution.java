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
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];

        for (int i = 0; i < m; i++) {
            weight[i] = scan.nextInt();
        }

        for (int i = 0; i < m; i++) {
            value[i] = scan.nextInt();
        }
        int values = maxValue(value, weight, n);
        System.out.println(values);
        scan.close();
    }

    private static int maxValue(int[] values, int[] weights, int size) {
        //      j 背包重量
        //    i  0 0 0 0 需要多一列存储 容量为 0 时的，dp 数组的情况
        //   物  0 0 0 0
        //   品  0 0 0 0
        // 装入[0,j] 的物品到 容量为 j的背包里的最大价值
        int m = values.length;
        int[][] dp = new int[m + 1][size + 1];

        // 装或者不装 weight[i]
//        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + values[i])
        // 需要知道其左侧的值和上方的值
        // 初始化 dp 数组， 计算 i[0] 在容量 0~size 的最大价值
        for (int i = weights[0]; i <= size; i++) {   // 如果 i < weight 的话当前 情况下物品的价值为 0 不用对齐进行初始化。
            dp[0][i] = values[0];
        }
        // 当 容量为 0 时，因为 java 二维数组默认初始化是 0 无需再额外进行初始化。
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 0;
//        }

        for (int i = 1; i < m; i++) {
            for (int j = size; j >= 0; j--) {
                if (weights[i] <= j) // 只有当背包容量 >= 当前货物的重量才能装
                    // 每一个 dp[i][j] 的状态有两种可能构成，装 weight[i] 的物品，或者不装当前物品。
                    // 装当前物品 背包当前的价值就是 value[i] + 当前重量 减去 weight[i] 的重量 能装物品的最大值
                    // 不装当前物品，背包的价值就是当前重量下不选当前物品 [i-1] 的最大价值 dp[i-1][j]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                else
                    // 装不下的话，最大价值就是当前重量下不选当前物品的最大价值
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // 打印 dp 数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // size 是 从 1开始的，返回的下标就是 size
        return dp[m - 1][size];
    }
}
