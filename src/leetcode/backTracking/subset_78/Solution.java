package leetcode.backTracking.subset_78;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-10-10:56
 * @url https://leetcode.cn/problems/subsets/description/
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

public class Solution {
    private Deque<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backTracking(nums, 0);

        System.out.println("res = " + res);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 0) {
            res.add(new ArrayList<>(path));
        }
        if (path.size() > nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            System.out.println("path = " + path);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        new Solution().subsets(nums);
    }
}
