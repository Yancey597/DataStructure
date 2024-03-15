package leetcode.backTracking.restore_ip_addresses_93;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-09-21:30
 * @url https://leetcode-cn.com/problems/restore-ip-addresses/
 * @description 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
class Solution {
    private List<String> res;
    private StringBuilder path;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return res; // 剪枝
        }
        res = new ArrayList<>();
        path = new StringBuilder();
        backTracking(s, 0, 0);
        return res;
    }

    private void backTracking(String s, int startIndex, int depth) {
        if (depth == 4) {
            if (startIndex == s.length()) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (i - startIndex > 2) { // 处理的字符长度不能超过三个字符
                break;
            }

            String segment = s.substring(startIndex, i + 1);
            if (isValidSegment(segment)) {
                int len = path.length();
                if (depth > 0) {
                    path.append('.');
                }
                path.append(segment);

                backTracking(s, i + 1, depth + 1);
                path.setLength(len);
            } else {
                break;
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    @Test
    public void test() {
        List<String> result = restoreIpAddresses("25525511135");
        System.out.println("res = " + result);
    }
}