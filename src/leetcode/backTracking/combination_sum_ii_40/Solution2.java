package leetcode.backTracking.combination_sum_ii_40;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution2
 * @date 2024-03-09-15:11
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

public class Solution2 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static boolean[] used;

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        new Solution2().combinationSum2(candidates, 8);
        System.out.println("res = " + res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];

        if (candidates.length == 0 || target <= 0) {
            return res;
        }
        used[0] = true;
        backTracking(candidates, target, 0, 0);
        return res;

    }

    private void backTracking(int[] candidates, int target, int startIndex, int sum) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i + 1, sum);
            used[i] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }

}



