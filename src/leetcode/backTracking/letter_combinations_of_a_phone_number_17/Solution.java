package leetcode.backTracking.letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private ArrayList<String> res;
    private String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static void main(String[] args) {
        String digits = "56";
        new Solution().letterCombinations(digits);
    }

    private void findCombination(String digits, int index, String s) {
        System.out.print(index + " : ");
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + ", return");
            return;
        }

        // 获取第 index 位对应的字符串
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];

        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "]" + ", use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digit[" + index + "] = " + c + "complete, return");
        return;
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }
}