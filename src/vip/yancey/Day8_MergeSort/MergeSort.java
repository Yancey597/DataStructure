package vip.yancey.Day8_MergeSort;//import org.junit.Test;

import vip.yancey.Day2_InsertSort.InsertSort;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className MergeSortFinal
 * @date 2024/2/5-15:24
 * @description 归并排序
 * 核心思想，分治、归并
 * 非原地排序
 * 时间复杂度：n*log_n
 */

public class MergeSort {
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, temp, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, temp, l, r);
    }
    public static <E extends Comparable<E>> void sort(E[] arr, E[] temp, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l  < 15) { // 当待排序数目 < 16 时，进行插入排序
            InsertSort.sort(arr, l, r);
            return;
        }
        int mid = (l + r) >> 1;

        sort(arr, temp, l, mid);
        sort(arr, temp, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, temp, l, mid, r);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] arr, E[] temp, int l, int mid, int r) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        int k = l;
        for (; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) < 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}