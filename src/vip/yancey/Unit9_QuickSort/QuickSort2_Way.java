package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.ArrayGenerator;
import Utils.ArrayUtils.ArrayHelper;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSortPrc3
 * @date 2024/2/6-23:50
 * @description 实现双路快速排序
 */

public class QuickSort2_Way {
    private QuickSort2_Way() {
    }

    public static void main(String[] args) {
        Integer[] e = ArrayGenerator.arrayGeneratorRandom(8, true);
        ArrayHelper.printArray(e);
        sort(e);
        ArrayHelper.printArray(e);

//        SortTimeTest.test(QuickSort2_Way.class, 6, false, true);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[l].compareTo(arr[i]) >= 0) {
                i++;
            }
            while (l + 1 <= j && arr[l].compareTo(arr[j]) <= 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            ArrayHelper.swap(arr, i, j);
            i++;
            j--;
        }
        ArrayHelper.swap(arr, l, j);
        return j;
    }

}
