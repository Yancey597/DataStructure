package vip.yancey.Unit2_InsertSort.note;/**
 * ClassName: InsertSortOptimize
 * Package: vip.yancey.Day2_InsertSort
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/23 17:44
 * @Version 1.0
 */
//import org.junit.Test;

import Utils.ArrayUtils.ArrayGenerator;
import Utils.ArrayUtils.ArrayHelper;

/**
 * @author Yancey
 * @version 1.0
 * @className InsertSortOptimize
 * @date 2023/11/23-17:44
 * @description TODO
 */

public class InsertSortOptimize {
    private InsertSortOptimize() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
//        循环不变量： d[0,i) 为已排序内容。
        for (int i = 0; i < data.length; i++) {
            E target = data[i];
            int j;
            for (j = i; j - 1 >= 0 && ArrayHelper.compare(data[j - 1], target); j--) {
                data[j] = data[j - 1];
            }
//            for (j = i; j - 1 >= 0 ; j--) {
//            if (SortHelper.compare(data[j - 1], target)) {
//                    data[j] = data[j-1];
//            }else{
//                break;     循环不变量：data[0,i) 是有序的，当待排序的元素比其前一位小的时候不用进行循环
//            }
            data[j] = target;
        }
        ArrayHelper.printArray(data);
    }

    public static void main(String[] args) throws InterruptedException {
        Integer[] data = ArrayGenerator.arrayGeneratorRandom(10,false);
//        new SortTimeTest().test(Thread.currentThread().getStackTrace()[1].getClassName(), 10, () -> InsertSortOptimize.sort(data));
    }

}
