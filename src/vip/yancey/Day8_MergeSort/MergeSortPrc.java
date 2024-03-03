package vip.yancey.Day8_MergeSort;//import org.junit.Test;

import ArrayUtils.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className MegeSoert
 * @date 2024/2/21-22:48
 * @description TODO
 */

public class MergeSortPrc {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 3};
        sort(arr);

        ArrayHelper.printArray(arr);
    }

    public static void sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        merge(arr, l, r, mid, temp);

    }

    public static void merge(int[] arr, int l, int r, int mid, int[] temp) {
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
            } else if (temp[i] > temp[j]) {
                arr[k] = temp[j];
                j++;
            } else {
                arr[k] = temp[i];
                i++;
            }
        }
    }
}
