package leetcode.backTracking.combinations_77;//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-07-11:53
 * @url: https://leetcode.cn/problems/combinations/description
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */

public class Solution {
    private static List<List<Integer>> end;


    public static void main(String[] args) {
        new Solution().combine(4, 2);

        System.out.println(end);
    }

    public List<List<Integer>> combine(int n, int k) {
        end = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backTracking(n, k, 1, temp);
        return end;
    }

    public void backTracking(int n, int k, int start, List<Integer> path) {
        if (path.size() == k) {
            System.out.println("Add path = " + path);
            end.add(path);
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            System.out.println("path = " + path);
            backTracking(n, k, i + 1, path);
            path.remove(path.size() - 1);
            System.out.println("After remove path = " + path);
        }
    }
}
