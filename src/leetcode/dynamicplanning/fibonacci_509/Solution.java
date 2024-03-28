package leetcode.dynamicplanning.fibonacci_509;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-26-20:25
 * @description 斐波那契数列的动态规划写法
 */

public class Solution {
    public static void main(String[] args) {
        int fibonacci = fibonacci(6);
        System.out.println("fibonacci = " + fibonacci);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 确定 dp 数组下标与 其值的关系
        // dp[i] 等于 第 i 个斐波那契数的值
        int[] dp = new int[2];

        // 确定递推公式
        // 1 1 2 3 5 8 13
        // f(i) = f(i-1) + f(i-2);

        // 初始化 dp 数组
//        dp[0] = 0;
        dp[0] = 0;
        dp[1] = 1;

        // 确定遍历顺序
        for (int i = 2; i <= n; i++) {
            int sum = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        // 打印 dp 数组 检查是否做对
//        for (int i = 1; i <=n; i++) {
//            System.out.print(dp[i]+" ");
//
//        }
        return dp[1];

    }
}
