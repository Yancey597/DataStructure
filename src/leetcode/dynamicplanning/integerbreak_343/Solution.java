package leetcode.dynamicplanning.integerbreak_343;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-27-22:24
 * @url https://leetcode.cn/problems/integer-break/description/
 * @description 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ）
 * 并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
