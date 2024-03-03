package vip.yancey.Day1_LinerSearch_SelectionSort;/**
 * ClassName: SelectionReverse
 * Package: vip.yancey.Day1
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/22 22:40
 * @Version 1.0
 */
//import org.junit.Test;

import ArrayUtils.ArrayHelper;

/**
 * @author Yancey
 * @version 1.0
 * @className SelectionReverse
 * @date 2023/11/22-22:40
 * @description TODO
 */

public class SelectionReverse {
    private SelectionReverse() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
//        循环不变量 data(i,length]是有序的 data[0,i] 是无序的
        for (int i = data.length - 1; i >= 0; i--) {
            int maxIndex = i;
            // 循环确定 最大值的坐标 维持循环不变量
            for (int j = i; j >= 0; j--) {
                if (data[maxIndex].compareTo(data[j]) < 0) {
                    maxIndex = j;
                }
            }
            ArrayHelper.swap(data, maxIndex, i);
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{3,2,1,6,5};
        sort(data);
        ArrayHelper.printArray(data);

    }

}
