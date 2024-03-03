package leetcode.ReversePairs_LCR170;//import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2023/12/25-9:30
 * @description TODO
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
//        int res = sort(array);
        int res = ReversePairs(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("res = " + res);
    }

    public static int ReversePairs(int[] array) {
        int[] temp = Arrays.copyOf(array, array.length);
        return (int) mergesortAndCount(array, 0, array.length - 1, temp);
    }

    public static long mergeAndCount(int[] array, int l, int r, int mid, int[] temp) {
        int i = l;
        int j = mid + 1;
        int k = l;
        long count = 0;
        while (i <= mid && j <= r) {
            if (temp[i] > temp[j]) {
                array[k++] = temp[j++];
                count += (mid - i + 1);
            } else {
                array[k++] = temp[i++];
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
        }
        while (j <= r) {
            array[k++] = temp[j++];
        }
        System.arraycopy(array, l, temp, l, r - l + 1);
        return count;

    }

    public static long mergesortAndCount(int[] array, int l, int r, int[] temp) {
        long count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergesortAndCount(array, l, m, temp);
            count += mergesortAndCount(array, m + 1, r, temp);
            count += mergeAndCount(array, l, r, m, temp);
        }
        return count;
    }

}
