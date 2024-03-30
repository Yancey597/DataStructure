package leetcode.dynamicplanning.canpartion_698;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-29-22:20
 * @url https://leetcode.cn/problems/partition-equal-subset-sum/description/
 * @description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum >> 1;
        // dp[i][j] [0~i] 的数任取，的最大值
        int[][] dp = new int[nums.length][target + 1];
        int n = nums.length;
        // dp[i][j] = max(dp[i-1][j-nums[i]] + nums[i], dp[i-1][j]
        for (int i = nums[0]; i <= target; i++) {
            dp[0][i] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][target] == target) {
                    return true;
                }
            }

        }

        return dp[n - 1][target] == target;
    }
}
