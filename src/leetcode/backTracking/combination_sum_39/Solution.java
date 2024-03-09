package leetcode.backTracking.combination_sum_39;//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-08-10:20
 * @description TODO
 */

public class Solution {
    public static List<List<Integer>> ans = new ArrayList<>();
    public static List path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}

