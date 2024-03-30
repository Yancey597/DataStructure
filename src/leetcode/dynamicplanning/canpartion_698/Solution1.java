package leetcode.dynamicplanning.canpartion_698;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution1
 * @date 2024-03-29-23:23
 * @url https://leetcode.cn/problems/partition-equal-subset-sum/description/
 * @description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int n = nums.length;
        int target = sum >> 1;
        int[] dp = new int[target + 1];

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

            }
            if (target == dp[target]) {
                return true;
            }
        }

        return dp[target] == target;
    }
}
