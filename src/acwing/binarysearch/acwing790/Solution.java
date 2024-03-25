package acwing.binarysearch.acwing790;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className solution
 * @date 2024-03-18-19:05
 * @description TODO
 */

public class Solution {
    public static void main(String[] args) {
        double n = 3;
        double l = -500;
        double r = 500;
        while (r > l + 1e-8) {
            double mid = l + (r - l) / 2;
            double res = mid * mid * mid;
            System.out.println("res = " + res);
            if (res >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.printf("%.6f\n", l);
        System.out.println(Math.pow(l, 3));

    }
}
