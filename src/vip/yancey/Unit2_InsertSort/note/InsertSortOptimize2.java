package vip.yancey.Unit2_InsertSort.note;

/**
 * ClassName: InsertSortOptimize2
 * Package: vip.yancey.Day2_InsertSort
 * Description: 插入排序：循环不变量为: [0, i-1/j] 是有序的。
 * 每次只需比较 target/data[i] 和 data[j] 的大小
 * 在从大到小排序中，如果 target < data[j]， 则将 data[j+1] = data[j], 否则结束循环
 *
 * @Author Yancey
 * @Create 2023/11/23 22:12
 * @Version 1.0
 */
//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;


public class InsertSortOptimize2 {
    private InsertSortOptimize2() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        //循环不变量 data[0,j) 是有序的
        for (int i = 1; i < data.length; i++) {
            int j;
            E target = data[i];
            for (j = i - 1; j >= 0 && ArrayHelper.compare(data[j], target); j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = target;
        }

    }
    public static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
        //循环不变量 data[0,j) 是有序的
        for (int i = l; i <= r; i++) {
            int j;
            E target = data[i];
            for (j = i - 1; j >= 0 && ArrayHelper.compare(data[j], target); j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = target;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Integer[] data = ArrayGenerator.arrayGeneratorRandom(10,false);
//        ArrayHelper.printArray(data);

//        new SortTimeTest().test(Thread.currentThread().getStackTrace()[1].getClassName(), 10, () -> InsertSortOptimize2.sort(data));
//        ArrayHelper.printArray(data);
//    }

    }
}
