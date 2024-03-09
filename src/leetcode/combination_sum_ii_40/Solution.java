package leetcode.combination_sum_ii_40;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-08-9:23
 * @description 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 示例 1: 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 注意：解集不能包含重复的组合。
 * @url https://leetcode.cn/problems/combination-sum-ii/
 */

public class Solution {

    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        new Solution().combinationSum2(candidates, 8);
        System.out.println("res = " + res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target <= 0 || candidates.length == 0) {
            return res;
        }
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }

    public void backTracking(int[] candidates, int target, int startIndex, int sum) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);

            sum += candidates[i];
            backTracking(candidates, target, i + 1, sum);
            int last = path.removeLast();
            sum -= last;
        }


    }
}
