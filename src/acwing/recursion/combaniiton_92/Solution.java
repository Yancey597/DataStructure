package acwing.recursion.combaniiton_92;//import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-16-20:43
 * @description TODO
 */

public class Solution {
    boolean[] used;
    private List<List<Integer>> res;
    private Deque<Integer> path;

    public static void main(String[] args) {
        List<List<Integer>> combination = new Solution().findCombination(3);
        System.out.println("combination = " + combination);
    }

    public List<List<Integer>> findCombination(int n) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        used = new boolean[n + 1];

        backtracking(n, 1);

        return res;
    }

    private void backtracking(int n, int startIndex) {
        res.add(new ArrayList<>(path));

        for (int i = startIndex; i <= n; i++) {
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                backtracking(n, i + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
