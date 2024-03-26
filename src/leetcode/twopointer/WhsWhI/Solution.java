package leetcode.twopointer.WhsWhI;//import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-25-18:37
 * @url https://leetcode.cn/problems/WhsWhI/description/
 * @description 给定一个未排序的整数数组 nums
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */

public class Solution {
    // 对数组进行排序
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int length = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            // 对数组重复元素进行去重
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] - nums[i - 1] == 1) {
                length++;
                // 记录最长的连续序列长度
                res = Math.max(res, length);
            } else {
                // 重置连续序列的长度
                length = 1;
            }

        }


        return res;
    }
}
