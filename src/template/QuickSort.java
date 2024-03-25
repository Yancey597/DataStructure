package template;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSort
 * @date 2024-03-23-21:20
 * @description TODO
 */

public class QuickSort {
    private void quick_sort(int q[], int l, int r) {
        if (l >= r) return;

        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) ArrayHelper.swap(q, q[i], q[j]);
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }


}
