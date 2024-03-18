package leetcode.greedy.maximize_sumofarray_after_k_negations_1005;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-15-23:17
 * @url https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 * @description 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */

public class Solution {


    public int largestSumAfterKNegations(int[] nums, int k) {

        nums = Arrays.stream(nums)
                .boxed()// 把 nums 进行拆箱
                .sorted((o1, o2) -> { // 按绝对值进行排序
                    return Math.abs(o2) - Math.abs(o1);
                }).mapToInt(Integer::intValue) // 将 Integer convert to int.
                .toArray();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1) {
            nums[nums.length - 1] *= -1;
        }

        return Arrays.stream(nums).sum();
    }

    @Test
    public void test() {
        int[] nums = {2, -3, -1, 5, -4};
        int i = new Solution().largestSumAfterKNegations(nums, 2);
        System.out.println("i = " + i);
    }

}
