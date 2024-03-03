package vip.yancey.Day8_MergeSort.note;//import org.junit.Test;

import ArrayUtils.ArrayGenerator;
import ArrayUtils.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className MergeSortBU
 * @date 2024/2/4-22:50
 * @description TODO
 */

public class MergeSortBU {
    public static void main(String[] args) {
//        new SortTimeTest<>().testPro("Mergesort", 5,false, MergeSortBU.class);
        Integer[] a = ArrayGenerator.arrayGeneratorRandom(5, false);
        sort(a);
        ArrayHelper.printArray(a);
    }


    public static <E extends Comparable<E>> void sort(E[] data) {
        int n = data.length;
        E[] temp = Arrays.copyOf(data, data.length);
        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);

                merge(data, temp, leftStart, mid, rightEnd);
            }
        }
    }

    private static<E extends Comparable<E>> void merge(E[] array, E[] tempArray, int leftStart, int mid, int rightEnd) {
        int leftEnd = mid;
        int rightStart = mid + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left].compareTo(array[right])<=0) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[right++];
            }
        }

        System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
        System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);
        System.arraycopy(tempArray, leftStart, array, leftStart, size);
    }

}
