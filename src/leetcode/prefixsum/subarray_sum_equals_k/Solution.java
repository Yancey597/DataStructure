package leetcode.prefixsum.subarray_sum_equals_k;//import org.junit.Test;

import java.util.HashMap;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-19-19:16
 * @url https://leetcode.cn/problems/subarray-sum-equals-k/description/
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1); // 处理边界情况，子数组长度为 1 时，且此时子数组的和为 k
        int preSum = 0;
        int count = 0;
        for (int e : nums) {
            preSum += e;
            if (hashMap.containsKey(preSum - k)) {
                count += hashMap.get(preSum - k);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
