package leetcode.backTracking.combination_sum_iii_216;//import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-08-22:46
 * @url https://leetcode.cn/problems/combination-sum-iii/description/
 * @description 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */

public class Solution {
    private static List<List<Integer>> res;
    private static List<Integer> path;

    public static void main(String[] args) {
        new Solution().combinationSum3(3, 7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0) {
            res.add(new ArrayList<>(path));
            return res;
        }
        path = new LinkedList<>();
        res = new ArrayList<>();
        backTracking(k, n, 1, 0);
        return res;
    }

    public void backTracking(int k, int n, int startIndex, int sum) {
        if (sum > n || path.size() > k) { // 如果和大于 n 或者路径长度大于 k 返回
            return;
        }

        if (sum == n && path.size() == k) { //如果和为 n,且路径长度为 k 则找到了解
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            if (i > n) {
                break;
            }
            path.add(i);// 添加路径
            sum += i; //计算当前和
            backTracking(k, n, i + 1, sum);
            sum -= i; // 回溯和状态
            path.remove(path.size() - 1);//回溯路径
        }
    }
}
