package lanqiao.distributechocolate1;//import org.junit.Test;

import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Main
 * @date 2024-03-22-11:05
 * @description 蓝桥杯 1 题，分巧克力
 */

public class Main {
    private static int N = 10010;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 读入两个整数 巧克力块数（N）、小孩哥个数(K)
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] chocolate = new int[n][2];
        for (int i = 0; i < n; i++) {
            chocolate[i][0] = scan.nextInt();
            chocolate[i][1] = scan.nextInt();
        }

        int l = 1;
        int r = (int) 1e5;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(mid, n, k, chocolate)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
        scan.close();
    }

    private static boolean check(int mid, int n, int k, int[][] chocolate) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (chocolate[i][0] / mid) * (chocolate[i][1] / mid);
        }

        return res >= k;
    }

}
