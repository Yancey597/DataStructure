package acwing.recursion.with_number_1209;//import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className with_number_1209
 * @date 2024-03-16-22:12
 * @description N = a + b/c
 * cn = ac + b
 * b = nc - ac
 * 只需要判断 计算 得出的 b 是否符合条件
 */

public class Solution {

    static boolean[] had_use = new boolean[10];
    static int ans = 0;
    static int n;


    // 核心思路：
    // 依次对a的部分进行排列，同时对C的部分进行排列，对 b 进行计算并判断是否满足条件
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs_a(0, 0);
        System.out.println(ans);
    }

    private static void dfs_a(int startIndex, int a) {
        if (a >= n) {
            return;
        }
        if (a != 0) {
            dfs_c(startIndex, a, 0);
        }
        // 对 a 进行排列
        for (int i = 1; i <= 9; i++) {
            if (!had_use[i]) {
                had_use[i] = true;
                dfs_a(startIndex + 1, a * 10 + i);
                had_use[i] = false;
            }
        }

    }

    private static void dfs_c(int startIndex, int a, int c) {
        if (startIndex >= 10) {
            return;
        }

        if (check(a, c)) {
            ans++;
        }

        for (int i = 1; i <= 9; i++) {
            if (!had_use[i]) {
                had_use[i] = true;
                dfs_c(startIndex + 1, a, c * 10 + i);
                had_use[i] = false;
            }

        }
        // 对 c 进行排列，同时检查 b 是否符合条件

    }

    private static boolean check(int a, int c) {
        // 判断 计算得出的 b 是否符合条件
        int b = n * c - c * a;
        if (b <= 0 || c <= 0 || a <= 0) {
            return false;
        }

        boolean[] backup = new boolean[had_use.length];
        for (int i = 0; i < backup.length; i++) backup[i] = had_use[i];
        //判断b是否有位数与a或c重合
        // b 的各个位数是否有重复
        while (b != 0) {
            int index = (b % 10);
            if (backup[index] || index == 0) {
                return false;
            }
            b /= 10;
            backup[index] = true;
        }

        // abc 能否覆盖 1~9 的数字
        for (int i = 1; i <= 9; i++) {
            if (!backup[i]) {
                return false;
            }

        }
        return true;
    }

}
