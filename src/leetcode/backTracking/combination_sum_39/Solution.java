package leetcode.backTracking.combination_sum_39;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-08-10:20
 * @url https://leetcode.cn/problems/combination-sum/
 * @description 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */

/*
    可以重复使用：每次搜索都可以从当前位置开始
    无需使用 startIndex
 */
public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public Deque<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, 0, target);
        System.out.println("ans = " + res);
        return res;
    }

    private void backTracking(int[] candidates, int startIndex, int target) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backTracking(candidates, i, target - candidates[i]);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        new Solution().combinationSum(candidates, 7);
    }
}

