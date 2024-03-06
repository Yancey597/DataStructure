package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.SortTimeTest;

import java.util.Random;

import static Utils.ArrayUtils.ArrayHelper.swap;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSort3_Way
 * @date 2024/2/16-16:07
 * @description 实现三路快速排序算法
 */

public class QuickSort3_Way {
    private QuickSort3_Way() {
    }

    public static void main(String[] args) {
        SortTimeTest.test(QuickSort3_Way.class, 10, true, false);

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> int[] partition(E[] arr, int l, int r, Random rd) {
        int lt = l, gt = r + 1, i = l + 1;

        int p = rd.nextInt(r - l + 1) + l;
        swap(arr, p, l);
        E e = arr[l];

        while (i < gt) {
            if (e.compareTo(arr[i]) > 0) { // < v: arr[l+1...lt] < v
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (e.compareTo(arr[i]) < 0) {// >v: arr[gt, r] > v
                gt--;
                swap(arr, i, gt);
            } else { // = v : arr[lt+1, i-1] == v
                i++;
            }
        }
        swap(arr, lt, l); //<v : arr[l+1, lt-1]   =v : arr[lt, gt-1]  >v : arr[gt, r]
        return new int[]{lt - 1, gt};
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rd) {
        if (l >= r) {
            return;
        }
        int[] pos = partition(arr, l, r, rd);
        sort(arr, l, pos[0], rd);
        sort(arr, pos[1], r, rd);
    }
}
