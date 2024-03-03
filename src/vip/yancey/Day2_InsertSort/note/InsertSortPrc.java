package vip.yancey.Day2_InsertSort.note;
/**
 * ClassName: InsertSortPrc
 * Package: vip.yancey.Day2_InsertSort
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/25 19:58
 * @Version 1.0
 */
//import org.junit.Test;

import ArrayUtils.ArrayHelper;
import ArrayUtils.SortTimeTest;


public class InsertSortPrc {
    private InsertSortPrc() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
//        (0, j]是有序的
        for (int i = 1; i < data.length; i++) {
            E target = data[i];
            int j;
            for (j = i - 1; j >= 0 && ArrayHelper.compare(data[j], target); j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = target;
        }
// \\6 \2 4 3 5
// \\2 4 6 \6 3 5

    }


    public static void main(String[] args) {
         SortTimeTest.test(InsertSortPrc.class, 10, false,false);
    }

}
