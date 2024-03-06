package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.SortTimeTest;

import static Utils.ArrayUtils.ArrayHelper.swap;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSortPrc
 * @date 2024/2/19-22:28
 * @description TODO
 */

public class QuickSortPrc {

    private QuickSortPrc() {
    }

    public static void main(String[] args) {
        SortTimeTest.test(QuickSortPrc.class, 10, false, false);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] p = partition3(arr, l, r);
        sort(arr, l, p[0]);
        sort(arr, p[1], r);
    }

    public static <E extends Comparable<E>> int partition1(E[] arr, int l, int r) {
//        arr[l+1...j] < v, arr[j+1, i-1] > v
//        int i = l + 1;
        int j = l;
        E e = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (e.compareTo(arr[i]) > 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {
        int i = l + 1;
        int j = r;
        E e = arr[l];
        while (true) {

            //arr[l+1... i-1] <= v
            // arr[j+1...r] >= v
            while (i <= j && arr[i].compareTo(e) <= 0) {
                i++;
            }

            while (l + 1 <= j && arr[j].compareTo(e) >= 0) {
                j--;
            }

            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, j, l);
        return j;
    }

    public static <E extends Comparable<E>> int[] partition3(E[] arr, int l, int r) {
//        arr[l+1, lt] < v arr[lt+1, i-1] == v arr[gt, r] > v
        int i = l + 1;
        int lt = l;
        int gt = r + 1;
        E e = arr[l];

        while (i < gt) {
            if (e.compareTo(arr[i]) > 0) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (e.compareTo(arr[i]) < 0) {
                gt--;
                swap(arr, gt, i);
            } else {
                i++;
            }
        }

        swap(arr, l, lt);
        // arr[l+1, lt-1] < v; arr[lt, gt-1] = v; arr[gt, r] > v
        return new int[]{lt - 1, gt};

    }

}
