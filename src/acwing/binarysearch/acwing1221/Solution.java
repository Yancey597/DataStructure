package acwing.binarysearch.acwing1221;//import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-18-21:07
 * @description 每个正整数都可以表示为至多 4
 * 个正整数的平方和。
 * <p>
 * 如果把 0
 * 包括进去，就正好可以表示为 4
 * 个数的平方和。
 * <p>
 * 比如：
 * <p>
 * 5=02+02+12+22
 * <p>
 * 7=12+12+12+22
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 */

public class Solution {
    private static Deque<Integer> res = new LinkedList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        while (!res.isEmpty()) {
            System.out.print(res.removeLast() + " ");
        }
    }

    private int check(int n, int[] nums) {
        int l = 0;
        int r = (int) Math.sqrt(n);
        int mid = 0;
        for (int i = 0; i < 4; i++) {
            while (l < r) {
                mid = l + (r - l + 1) / 2;
                if (mid * mid > n) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (l >= 0)
                res.add(l);

//            System.out.println("mid = " + mid);
            n = n - l * l;
//            System.out.println("n = " + n);
            r = n;
            l = 0;
        }
        return 0;
    }
}
