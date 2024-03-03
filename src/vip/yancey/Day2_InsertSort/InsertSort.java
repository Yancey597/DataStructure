package vip.yancey.Day2_InsertSort;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className InsertSortFinal
 * @date 2024/2/4-21:49
 * @description 实现插入排序，
 * 核心思想：比较基准值和其之前的每一个数，如果比基准值大，则依次往后移动，最后在目标位置插入。
 */

public class InsertSort {
    public static <E extends Comparable<E>> void sort(E[] a) {
        for (int i = 1; i < a.length; i++) {
            E e = a[i];//确立基准值
            int j;
            for (j = i - 1; j >= 0 && e.compareTo(a[j]) < 0; j--) {//e.compareTo(a[j]) < 0 只有满足才移动
                a[j + 1] = a[j];
            }
            a[j + 1] = e;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            E e = a[i];
            int j = i - 1;
            while (j >= l && e.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = e;
        }
    }
}
