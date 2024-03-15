package leetcode.backTracking.subsetsWithDup_90;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-10-11:12
 * @description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

public class Solution {
    private List<List<Integer>> res;
    private Deque<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backTracking(nums, 0);
        System.out.println("res = " + res);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 2};
        new Solution().subsetsWithDup(nums);
    }
}
