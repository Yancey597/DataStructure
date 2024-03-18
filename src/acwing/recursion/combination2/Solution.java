package acwing.recursion.combination2;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-16-20:58
 * @description
 */

public class Solution {
    private List<List<Integer>> res;
    private Deque<Integer> path;

    public static void main(String[] args) {
        List<List<Integer>> combination = new Solution().findCombination(5, 3);
        System.out.println("combination = " + combination);
    }

    public List<List<Integer>> findCombination(int n, int m) {
        res = new ArrayList<>();
        path = new LinkedList<>();

        backTracking(n, m, 1);

        return res;
    }

    private void backTracking(int n, int m, int startIndex) {
        if (path.size() == m) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (m - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, m, i + 1);
            path.removeLast();
        }
    }

}
