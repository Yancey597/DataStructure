package leetcode.backTracking.permutation_ii;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-11-18:52
 * @url https://leetcode.cn/problems/permutations-ii/description/
 * @description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 */

public class Solution {
    //    boolean[] used;
    private List<List<Integer>> res;
    private Deque<Integer> path;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new LinkedList<>();
//        used = new boolean[nums.length];
        backTracking(nums);
        System.out.println("res = " + res);

        return res;
    }

    private void backTracking(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == false) {
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums);
                path.removeLast();
//                used[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        new Solution().permuteUnique(nums);
    }
}
