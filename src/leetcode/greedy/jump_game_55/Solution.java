package leetcode.greedy.jump_game_55;//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-14-21:31
 * @url https://leetcode.cn/problems/jump-game/description/
 * @description 给你一个非负整数数组 nums ，你最初位于数组的第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 每一步都尽可能多跳，如果超过数组下标就不跳
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cover) {
                return false;
            }
            cover = Math.max(cover, nums[i] + i);

        }
        return false;
    }

    @Test
    public void test() {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println("new Solution().canJump(nums) = " + new Solution().canJump(nums));
    }
}
