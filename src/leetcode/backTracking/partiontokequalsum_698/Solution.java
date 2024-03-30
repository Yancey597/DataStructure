package leetcode.backTracking.partiontokequalsum_698;//import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-29-22:24
 * @description 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("can = " + canPartitionKSubsets(nums));
    }

    public static boolean canPartitionKSubsets(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if ((1 & sum) == 1) {
            return false;
        }

        return backTracking(nums, sum / 2, 0, 0);
    }

    private static boolean backTracking(int[] nums, int target, int sum, int startIndex) {
        if (sum == target) {
            return true;
        }

        if (sum > target || startIndex == nums.length) {
            return false;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (backTracking(nums, target, sum + nums[i], i + 1)) {
                return true;
            }
        }

        return false;
    }
}
