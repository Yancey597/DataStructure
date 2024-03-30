package leetcode.dynamicplanning.backpack_01problem;//import org.junit.Test;

import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution1
 * @date 2024-03-29-20:28
 * @description 01 backpack problem one dimension  array
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 5;
        int[] weight = {2, 3, 4};
        int[] value = {3, 4, 5};

        // 为什么可以用一维数组来存储？
        // 对于0-1背包问题，我们只需要知道上一行（或上一轮）的结果
        // dp[j] 存储上一轮的计算结果，如果放新的商品，就减去当前的值

        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weight.length; i++) {
            // 先遍历物品再遍历背包，是因为每轮遍历 需要使用上轮已经存储的数据。
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                // dp[j] 当前容量可以装的物品的最大值，如果放当前物品(能放的下)，dp[i] = dp[j-weight[i]] + value[i]
                // 如果不放 weight[i]，dp[j] 的值为[0~i-1] 的最大值(上轮循环的最大值)
            }
        }
        System.out.println(dp[capacity]);

        scanner.close();
    }
}
