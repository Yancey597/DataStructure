package leetcode.backTracking.permutations_46;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-07-10:43
 * @url https://leetcode.cn/problems/permutations/description/
 * @description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Solution {

    private List<List<Integer>> res;
    private Deque<Integer> path;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        used = new boolean[nums.length];
        backTracking(nums);
        System.out.println("res = " + res);
        return res;
    }

    private void backTracking(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }

}
