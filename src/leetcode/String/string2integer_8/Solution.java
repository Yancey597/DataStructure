package leetcode.String.string2integer_8;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-25-18:58
 * @url https://leetcode.cn/problems/string-to-integer-atoi/description/
 * @description 请你来实现一个 myAtoi(string s) 函数，
 * 使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 */

public class Solution {
    // 待解决 重新优化
    public static void main(String[] args) {
        int i = new Solution().myAtoi("  1234  sadas 56");
        System.out.println("i = " + i);
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] > '9' || chars[0] < '0') {
            return 0;
        }
        char[] ints = new char[s.length()];
        int j = 0;
        int negative = 0;

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '-') {
                negative++;
                continue;
            }
            if (chars[i] == ' ' || chars[i] < '0' || chars[i] > '9') {
                continue;
            }
            ints[j++] = chars[i];
        }
        if (j > 32) {
            return negative % 2 == 0 ? (int) (Math.pow(2, 32) - 1) : (int) (Math.pow(2, 32) - 1) * -1;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            x = x * 10 + (ints[i] - '0');
        }
        return negative % 2 == 0 ? x : x * -1;
    }
}
