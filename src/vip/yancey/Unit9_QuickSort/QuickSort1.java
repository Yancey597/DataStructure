package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.ArrayUtils.SortTimeTest;
import Utils.recursionUtils.Recursion;

/**
 * @author Yancey
 * @version 1.0
 * @className QuickSortPrc1
 * @date 2024/2/5-20:13
 * @description 最基础的快速排序，对数组的处理如下：
 * 1. 指针 i 从左到右依次扫描数组
 * 2. 小于标定值的划分至 arr[l+1, j]
 * 大于标定值的划分至 arr[j+1, i-1]
 * 3. 将标定点与 j 互换
 */

public class QuickSort1 {
    private QuickSort1() {
    }

    public static void main(String[] args) {
        SortTimeTest.test(QuickSort1.class, 10,false,true);
    }
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1, 0);

    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth) {
        if (l >= r) {
            Recursion.GenerateDepthString(depth, "start Return", true);
            return;
        }
        int p = partition(arr, l, r, depth);
        Recursion.GenerateDepthString(depth, "start QuickSort " + "(" + l + "," + (p - 1) + "): ", true);
        ArrayHelper.printArray(arr, p);

        // 处理 p 的左侧
        sort(arr, l, p - 1, depth++);
        Recursion.GenerateDepthString(depth, "start QuickSort " + "(" + (p + 1) + "," + r + "): ", true);

        // 处理 p 的右侧
        sort(arr, p + 1, r, depth++);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, int depth) {
        int j = l;
        E t;
        E e = arr[l];
        Recursion.GenerateDepthString(depth, "start Partition " + "(" + l + "," + r + "): ", true);

        // 以 l 为标定点，从 l+1 开始依次扫描所有元素
        for (int i = l + 1; i <= r; i++) {
            // arr[l+1, j] < arr[l]
            if (arr[i].compareTo(e) < 0) {
                j++;
                // 将小于标定值的 arr[i] 归入 arr[l+1, j]
                // 为什么要交换？ j++ 后，现在的 arr[j] (j = j+1) 实际上是之前 arr[j+1, i] 的端点值
                ArrayHelper.swap(arr, i, j);

            }
            // arr[j+1, i] >= arr[l]
            // i++ 归入 for 循环
        }
        ArrayHelper.swap(arr, l, j);
        Recursion.GenerateDepthString(depth, "end QuickSort, p = " + j + " ", true);
        ArrayHelper.printArray(arr, l, r, true);

        return j;
    }
}
