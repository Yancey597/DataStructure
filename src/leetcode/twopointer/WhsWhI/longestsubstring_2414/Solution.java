package leetcode.twopointer.WhsWhI.longestsubstring_2414;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-25-18:48
 * @url https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/description/
 * @description 字母序连续字符串 是由字母表中连续字母组成的字符串。
 * 换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
 */

public class Solution {
    public int longestContinuousSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        // 转为字符数组提高运行效率
        char[] chars = s.toCharArray();
        int res = 1;
        int length = 1;
        int n = chars.length;
        for (int i = 1; i < n; i++) {
            // check 当前位数及其下一位是否合法
            if (chars[i] - chars[i - 1] == 1) {
                length++;
                res = Math.max(res, length);
            } else {
                length = 1;
            }
        }

        return res;


    }
}
