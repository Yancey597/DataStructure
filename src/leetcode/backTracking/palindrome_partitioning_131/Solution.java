package leetcode.backTracking.palindrome_partitioning_131;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-09-16:04
 * @url https://leetcode.cn/problems/palindrome-partitioning/description/
 * @description 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串，返回 s 所有可能的分割方案。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */

public class Solution {
    private static Deque<String> path;
    private static List<List<String>> res;
    private static String subString;

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println("s is not: " + s);
                return false;
            }
        }
        return true;
    }

    // Answer
    public List<List<String>> partition(String s) {
        path = new LinkedList<>();
        res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        backTracking(s, 0);
        return res;
    }

    private void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            subString = s.substring(startIndex, i + 1);
            if (isPalindrome(subString)) {
                path.add(subString);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        new Solution().partition("");
        System.out.println("res = " + res);
    }

    @Test
    public void test1() {
        boolean a = isPalindrome("aabb");
        System.out.println("a = " + a);
    }
}
