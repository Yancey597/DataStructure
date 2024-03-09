package leetcode.backTracking.permutations_46;//import org.junit.Test;

import Utils.recursionUtils.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-07-10:43
 * @description 全排列
 */

public class Solution {
    private static int depth;
    private static List<List<Integer>> end;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().permute(nums);
        System.out.println(end);
    }

    public List<List<Integer>> permute(int[] nums) {
        end = new ArrayList<>();
        mute(nums, 0, new ArrayList<>(), 0);
        return end;

    }

    private void mute(int[] nums, int index, List<Integer> res, int depth) {

//        System.out.print(Recursion.GenerateDepthString(depth) + index + " : ");
        if (res.size() == nums.length) {
            end.add(new ArrayList<>(res)); // 将当前排列的副本添加到结果列表中
            System.out.println(Recursion.GenerateDepthString(depth) + "get " + res + ", return");
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            System.out.println(Recursion.GenerateDepthString(depth) + "try use num[" + i + "]: " + nums[i]);
            if (!res.contains(nums[i])) { // 检查当前数字是否已经在排列中

                System.out.println(Recursion.GenerateDepthString(depth) + "use num[" + i + "]: " + nums[i]);
                res.add(nums[i]);
                mute(nums, index + 1, res, depth + 1);
                res.remove(res.size() - 1); // 回溯，移除刚刚添加的数字
            }
        }
    }
}
