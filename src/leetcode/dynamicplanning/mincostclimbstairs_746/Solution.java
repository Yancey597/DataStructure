package leetcode.dynamicplanning.mincostclimbstairs_746;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-26-22:35
 * @description 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 2) {
            return 0;
        }
        // 确定 dp i 的下标和 dp[i] 的值的具体含义
        // dp[i] 表示到达 第 i 层 的最小代价
        int n = cost.length;
        // 确定递推公式
//        10,15,20，20
        // 0 0
        // 1 0
        // 2 10
        // 3 15
        // 根据递推公式初始化 dp 数组
        int dp0 = 0;
        int dp1 = 0;


        // 确定遍历顺序 递推更新 dp 数组
        for (int i = 2; i <= n; i++) {
            int sum = Math.min(dp1 + cost[i - 1], dp0 + cost[i - 2]);
            dp0 = dp1;
            dp1 = sum;
        }
        // 打印 dp 数组的值进行检查

        return dp1;
    }
}
