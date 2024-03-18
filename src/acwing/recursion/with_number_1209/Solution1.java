package acwing.recursion.with_number_1209;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution1
 * @date 2024-03-16-23:22
 * @description TODO
 */

import java.util.Scanner;

public class Solution1 {
    static int n, ans;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs_a(0, 0);
        System.out.println(ans);
    }

    //进行第一次深搜,x表示用了多少数字，a表示当前的值
    static void dfs_a(int x, int a) {
        //a值大于n,不符合题意，返回
        if (a >= n) return;
        if (a != 0) dfs_c(x, a, 0);

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs_a(x + 1, a * 10 + i);
                used[i] = false;
            }
        }
    }

    //x表示当前用过的数字数量，a是dfs_a所得到的数，c是dfs_c所得到的的数
    static void dfs_c(int x, int a, int c) {
        if (x >= 10) return;

        //满足题目要求带分数的条件,ans加1
        if (check(a, c)) ans++;
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs_c(x + 1, a, c * 10 + i);
                used[i] = false;
            }
        }

    }

    //a是dfs_a所得的，c是dfs_c所得的
    static boolean check(int a, int c) {
        int b = c * n - c * a;
        if (a <= 0 || b <= 0 || c <= 0) return false;
        boolean[] flag = new boolean[used.length];
        for (int i = 0; i < flag.length; i++) flag[i] = used[i];
        //判断b是否有位数与a或c重合
        while (b != 0) {
            int t = b % 10;
            b /= 10;
            if (t == 0 || flag[t]) return false;
            flag[t] = true;
        }

        //判断得到的a,b,c三数是否能覆盖1~9的全部数字
        for (int i = 1; i <= 9; i++) {
            if (!flag[i]) return false;
        }
        return true;
    }

}
