package leetcode.backTracking.non_decreasing_subsequences_491;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-10-22:38
 * @description 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素。
 * 你可以按任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 */

public class Solution {
    private Deque<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backTracking(nums, 0);
        System.out.println("res = " + res);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            return;
        }
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!used.isEmpty() && used.contains(nums[i])) {
                continue;
            }

            System.out.println("nums[i] = " + nums[i]);

            if (!path.isEmpty() && path.getLast() <= nums[i] || path.isEmpty()) {
                path.add(nums[i]);
                used.add(nums[i]);
                backTracking(nums, i + 1);
                path.removeLast();
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {4, 6, 7, 7};
        new Solution().findSubsequences(nums);
    }

}
