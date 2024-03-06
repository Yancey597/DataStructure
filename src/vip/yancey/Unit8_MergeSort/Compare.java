package vip.yancey.Unit8_MergeSort;//import org.junit.Test;

import Utils.ArrayUtils.SortTimeTest;
import vip.yancey.Unit2_InsertSort.InsertSort;

/**
 * @author Yancey
 * @version 1.0
 * @className Compare
 * @date 2024/2/5-18:08
 * @description TODO
 */

public class Compare {
    public static void main(String[] args) {
//        new SortTimeTest<>().testPro(new String[]{"InsertSort", "MergeSort"},10,false,true, InsertSort.class, MergeSort.class);
        SortTimeTest.testMulti(InsertSort.class, 10, 4, false, true,false);
    }
}
