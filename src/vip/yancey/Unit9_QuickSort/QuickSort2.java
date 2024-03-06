package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.ArrayUtils.SortTimeTest;

import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSortPrc2
 * @date 2024/2/6-18:08
 * @description 引入随机数对快速排序的 partition 进行优化
 */

public class QuickSort2 {
    private QuickSort2() {
    }

    public static void main(String[] args) {
        SortTimeTest.testMulti(QuickSort2.class, 10, 10, false, false, false);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r, random);
        sort(arr, 0, p - 1, random);
        sort(arr, p + 1, r, random);

    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // [0, bound - 1] --> [l, r]
        //nextInt( r - l + 1) --> [0, r - l + 1 - 1] + l --> [l, r]
        int p = random.nextInt(r - l + 1) + l;
        ArrayHelper.swap(arr, p, l);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[l].compareTo(arr[i]) > 0) {
                j++;
                ArrayHelper.swap(arr, i, j);
            }
        }
        ArrayHelper.swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> int partition1(E[] arr, int l, int r) {
        ArrayHelper.swap(arr, (l + r) >> 1, l); // 每次和中间的数换
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[l].compareTo(arr[i]) > 0) {
                j++;
                ArrayHelper.swap(arr, i, j);
            }
        }
        ArrayHelper.swap(arr, l, j);
        return j;
    }


}
