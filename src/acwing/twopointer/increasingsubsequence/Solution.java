package acwing.twopointer.increasingsubsequence;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-24-22:59
 * @description 求连续递增子序列的长度
 * 如 1 2 2 3 5 长度为 3 (2 3 5)
 */

public class Solution {
    private static final int N = 100010;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] subsequence = new int[n];
        int[] times = new int[N];

        for (int i = 0; i < n; i++) {
            subsequence[i] = scan.nextInt();
        }
        int res = 0;


        for (int i = 0, j = 0; i < n; i++) {
            times[subsequence[i]]++;
            while (times[subsequence[i]] > 1) {
                times[subsequence[j]]--;
                j++;
            }

            res = Math.max(i - j + 1, res);
        }


        System.out.println("res = " + res);


        scan.close();


    }

    @Test
    public void test() {
        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
        int n = 5;
        int[] subsequence = {1, 2, 2, 3, 4};

//        int[] subsequence = new int[n];
        int[] times = new int[N];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                times[subsequence[j]]++;
                while (times[subsequence[j]] > 1) {
                    i++;
                    times[subsequence[j]]--;
                }

                res = Math.max(res, j - i + 1);
            }
        }
        System.out.println(res);

        scan.close();


    }

}
