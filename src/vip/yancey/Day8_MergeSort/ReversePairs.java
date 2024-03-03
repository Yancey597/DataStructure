package vip.yancey.Day8_MergeSort;//import org.junit.Test;

import ArrayUtils.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className ReversePairs
 * @date 2024/2/5-17:35
 * @description TODO
 */

public class ReversePairs {
    public static void main(String[] args) {
        Integer a[] = {7, 5, 6, 4};
        int sort = sort(a);
        System.out.println(sort);
        ArrayHelper.printArray(a);

    }

    public static <E extends Comparable<E>> int sort(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);
        return sort(arr, temp, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> int sort(E[] arr, E[] temp, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int num = 0;
        int mid = (l + r) >> 1;
        num += sort(arr, temp, l, mid);
        num += sort(arr, temp, mid + 1, r);
        num += merge(arr, temp, l, mid, r);
        return num;
    }

    public static <E extends Comparable<E>> int merge(E[] arr, E[] temp, int l, int mid, int r) {
        int num = 0;
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1, k = l;

        for (; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i++];
            } else if (temp[i].compareTo(temp[j]) > 0) {
                num += (mid - i + 1);
                arr[k] = temp[j++];
            } else {
                arr[k] = temp[i++];
            }
        }


        return num;
    }
}
