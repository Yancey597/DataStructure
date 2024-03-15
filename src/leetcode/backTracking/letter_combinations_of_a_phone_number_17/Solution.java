package leetcode.backTracking.letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-07-11:53
 * @url: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Solution {
    private StringBuilder sb = new StringBuilder();

    private ArrayList<String> res;
    private HashMap<Character, String> letterMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public static void main(String[] args) {
        String digits = "56";
        new Solution().letterCombinations(digits);
    }

    private void findCombination(String digits, int index, StringBuilder sb) {
        System.out.print(index + " : ");
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        // 获取第 index 位对应的字符串
        char c = digits.charAt(index);
        String letters = letterMap.get(digits.charAt(index));

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            System.out.println("digits[" + index + "]" + ", use " + letters.charAt(i));
            findCombination(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("digit[" + index + "] = " + c + "complete, return");
        return;
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, sb);
        System.out.println("res = " + res);
        return res;
    }
}