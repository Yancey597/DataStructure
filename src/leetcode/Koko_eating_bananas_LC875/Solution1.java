package leetcode.Koko_eating_bananas_LC875;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution1
 * @date 2024-03-03-10:59
 * @description TODO
 */

public class Solution1 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        int l = (int) ((sum + h - 1) / h);//
        int r = (int) ((sum) / (h - n + 1)); //
        int v = 0;
        while (l < r) {
            int time = 0;
            v = l + ((r - l) >> 1);
            for (int pile : piles) {
                time += (pile + v - 1) / v;
            }
            if (time > h) {
                l = v + 1;
            } else {
                r = v;
            }
        }
        return r;
    }
}
