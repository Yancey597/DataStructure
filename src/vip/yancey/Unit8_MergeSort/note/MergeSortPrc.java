package vip.yancey.Unit8_MergeSort.note;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.ArrayUtils.SortTimeTest;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className MergeSortPrc
 * @date 2024/2/4-19:48
 * @description TODO
 */

public class MergeSortPrc {
    public static void main(String[] args) {
         SortTimeTest.test(MergeSortPrc.class, 1000, false, false);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        E[] e = Arrays.copyOf(data, data.length);
        sort(data, 0, data.length - 1, e);
    }

    public static <E extends Comparable<E>> void sort(E[] data, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) >> 1;
        sort(data, l, mid, temp);
        sort(data, mid + 1, r, temp);



        if (ArrayHelper.compare(data[mid], data[mid + 1])) {
            merge(data, l, r, mid, temp);
        }
    }
    public static <E extends Comparable<E>> void merge(E[] data, int l, int r, int mid, E[] temp){
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (ArrayHelper.compare(data[i], data[j])) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= r) {
            temp[k++] = data[j++];
        }

        for (k = l; k <= r; k++) {
            data[k] = temp[k];
        }
    }
}
