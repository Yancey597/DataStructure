package leetcode.dynamicplanning.climbingstairs;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-26-20:22
 * @url https://leetcode.cn/problems/climbing-stairs/description/
 * @description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Solution {
    public static void main(String[] args) {
        int res = climbStairs(10);
        System.out.println("res = " + res);
    }

    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        // 确定 数组下标 dp[i] 及 i 的含义
        // dp[i] 到达 第 i 层楼梯可用的方法数
        int[] dp = new int[3];

        // 确定递推公式
        //i 0
        //i 1 1
        //i 2 2
        //i 3 3
        //i 4 5

        // 每次只能走 1、2 步，如 第 4 层
        // 只能通过到达 第 2 层(走2步)，第 3 层（走1步）的可能情况如下
        // 第 2 层 走 2 步 到第 4 层
        // 第 3 层 走 1 步 到第 4 层。
        // 到达第 2 层有几种方法，走 2 步 到第 4 层就有几种方法
        // 到达第 3 层有几种方法，走 1 步 到第 4 层就有几种方法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }

        // 打印数组
        return dp[2];
    }
}
