package leetcode.Koko_eating_bananas_LC875;//import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-03-10:30
 * @description 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */

public class Solution {
    private static int eatTime(int[] piles, int k) {
        int times = 0;
        for (int pile : piles) {
            times += pile / k + (pile % k != 0 ? 1 : 0);
        }
        return times;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;

        while (l < r) {
            int mid = (r - l) / 2+l;
            if (eatTime(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
