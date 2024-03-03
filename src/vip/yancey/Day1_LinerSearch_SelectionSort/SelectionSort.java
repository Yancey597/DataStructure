package vip.yancey.Day1_LinerSearch_SelectionSort;

//import org.junit.Test;

import ArrayUtils.ArrayHelper;

/**
 * @author Yancey
 * @version 1.0
 * @date 2023/11/22-20:09
 * @description 实现选择排序
 */

public class SelectionSort {
    private SelectionSort() {
    }

    public static void swap(int data[], int n1, int n2) {
        int temp = data[n1];
        data[n1] = data[n2];
        data[n2] = temp;
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

//        循环不变量： data[0, i) 是有序的  data[i, n) 是无序的
        for (int i = 0; i < data.length; i++) {
//            记录最小值的索引
            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (ArrayHelper.compare(data[j], data[minIndex])) {
                    minIndex = j;
                }
            }
            ArrayHelper.swap(data, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 6, 4, 2};
        for (int i : array) {
            System.out.print(i);
        }
//        sort(array);
        System.out.println();

        for (int e : array) {
            System.out.print(e + " ");
        }


    }
}
