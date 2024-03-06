package vip.yancey.Unit8_MergeSort.note;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.ArrayUtils.SortTimeTest;
import vip.yancey.Unit2_InsertSort.note.InsertSortOptimize2;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className MergeSortOptimse
 * @date 2023/12/22-20:44
 * @description TODO
 */

public class MergeSortOptimize {
    private MergeSortOptimize() {
    }

    public static void main(String[] args) {
//        new SortTimeTest<Integer>().testPro("MergeSort", 100000, false, MergeSort.class);
         SortTimeTest.test(MergeSortOptimize.class, 10000, false, false);
//        new SortTimeTest<Integer>().testPro("InsertSort", 10000, false, false, InsertSortPrc.class);
//        new SortTimeTest<Integer>().testPro("SelectSort", 10000, false, false, SelectionSort.class);
//        new SortTimeTest<Integer>().testPro("SelectSort", 100000, false, SelectionSort.class);
//        new SortTimeTest<Integer>().testPro(new String[]{"MergeSort","SelectSort"},100000,false,false,MergeSortOptimize.class, SelectionSort.class);
//        Map<String, Class> mergeSort = Map.of( "MergeSort", MergeSortOptimize.class,"InsertSort", InsertSortOptimize2.class,"SelectSort", SelectionSort.class);
//        new SortTimeTest<Integer>().testPro(mergeSort,100000,false,false);
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        E[] temp = Arrays.copyOfRange(data, 0, data.length);
        System.out.println(temp.length == data.length);
         sort(data, 0, data.length - 1, temp);
    }

    public static <E extends Comparable<E>> void sort(E[] array, int l, int r, E[] temp) {

        if (l >= r) {
            return;
        }
        if (r - l < 16) {
            InsertSortOptimize2.sort(array, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(array, l, mid, temp);
        sort(array, mid + 1, r, temp);
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merge(array, l, r, mid, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] array, int l, int r, int mid, E[] temp) {
        System.arraycopy(array, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                array[k] = temp[j];
                j++;
            } else if (j > r) {
                array[k] = temp[i];
                i++;
            } else if (ArrayHelper.compare(temp[i], temp[j])) {
                array[k] = temp[j];
                j++;
            } else {
                array[k] = temp[i];
                i++;
            }
        }
    }
}
