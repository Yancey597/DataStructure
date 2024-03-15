package leetcode.greedy.maximum_subarray;//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-12-22:32
 * @url https://leetcode.cn/problems/maximum-subarray/
 * @description 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素）
 * 返回其最大和。
 */

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(count, sum);
            if (count <= 0) {
                count = 0;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println("new Solution().maxSubArray(nums) = " + new Solution().maxSubArray(nums));

    }
}
