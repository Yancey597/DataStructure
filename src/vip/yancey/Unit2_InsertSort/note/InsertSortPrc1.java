package vip.yancey.Unit2_InsertSort.note;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.ArrayUtils.SortTimeTest;

/**
 * @author Yancey
 * @version 1.0
 * @className InsertSortPrc1
 * @date 2024/2/4-15:54
 * @description TODO
 */

public class InsertSortPrc1 {
    public static void main(String[] args) {
        SortTimeTest.test(InsertSortPrc1.class, 5, false, false);
//        Integer[] a = {5,2,1,3,4};
//        sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+" ");
//
//        }
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 1; i < data.length; i++) {
            E temp = data[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (ArrayHelper.compare(data[j], temp)) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = temp;
        }
    }
}
