package leetcode.greedy.jumpgame_II_49;//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-15-21:38
 * @url https://leetcode.cn/problems/jump-game-ii/description/
 * @description 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 */

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        //在目标终点范围内选择起跳点最大的
        int curDistance = 0;
        int nextDistance = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, nums[i] + i);
            if (i == curDistance) {
                curDistance = nextDistance;
                times++;
                if (i == nums.length - 1) {
                    break;
                }
            }
        }

        return times;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("new Solution().jump(nums) = " + new Solution().jump(nums));
    }
}
