package vip.yancey.Unit10_BinarySearch;//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yancey
 * @version 1.0
 * @className TestSearch
 * @date 2024-02-29-22:02
 * @description TODO
 */

public class TestSearch {
    /**
     * @param :
     * @return void
     * @author Yancey
     * @description 测试 upperceil 是否能够正确执行。
     * @date 2024-02-29 22:02
     */
    @Test
    public void testUpperCeil() throws Exception {
        Integer[] arr = {1, 3, 3, 4, 4};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("upper_ceil1", Comparable[].class, Comparable.class);
        method.setAccessible(true);

        //功能测试
        assertEquals(4, method.invoke(null, arr, 4));

        // 找一个小于数组中所有元素的数，返回0
        assertEquals(0, method.invoke(null, arr, 0));

        // 找一个数组中不存在但是有最大值的数，返回比他大的最小值
        assertEquals(1, method.invoke(null, arr, 2));

        // 找一个大于数组中所有元素的数，返回数组长度
        assertEquals(arr.length, method.invoke(null, arr, 5));
    }

    @Test
    public void testLowerCeil() throws Exception {
        Integer[] arr = {1, 1, 3, 3, 4, 4};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("lower_ceil", Comparable[].class, Comparable.class);
        method.setAccessible(true);


        // 找一个小于数组中所有元素的数，返回0
        assertEquals(0, method.invoke(null, arr, 0));
        // 找一个数组中不存在但是有最大值的数，返回比他大的最小值
        assertEquals(2, method.invoke(null, arr, 2));
        // 找一个大于数组中所有元素的数，返回数组长度
        assertEquals(arr.length, method.invoke(null, arr, 5));

        //功能测试
        assertEquals(2, method.invoke(null, arr, 3));
    }

    @Test
    public void testLower() throws Exception {
        Integer[] arr = {1, 1, 3, 3, 4, 4};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("lower", Comparable[].class, Comparable.class);
        method.setAccessible(true);

        // 找一个小于数组中所有元素的数，返回-1
        assertEquals(-1, method.invoke(null, arr, 0));
        // 找一个数组中不存在但是有小于其值的数，返回比他小的最大值
        assertEquals(1, method.invoke(null, arr, 2));
        // 找一个大于数组中所有元素的数，返回数组最后一个数
        assertEquals(5, method.invoke(null, arr, 5));

        //功能测试
        assertEquals(1, method.invoke(null, arr, 3));
    }

    @Test
    public void testLowerFloor() throws Exception {
        Integer[] arr = {1, 3, 3, 4, 4};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("lower_Floor", Comparable[].class, Comparable.class);
        method.setAccessible(true);


        // 找一个小于数组中所有元素的数，返回-1
        assertEquals(-1, method.invoke(null, arr, 0));
        // 找一个数组中不存在但是有比其值小的数，返回比他小的最大值
        assertEquals(0, method.invoke(null, arr, 2));
        // 找一个大于数组中所有元素的数，返回数组最后一个数
        assertEquals(arr[arr.length - 1], method.invoke(null, arr, 5));

        //功能测试
        assertEquals(1, method.invoke(null, arr, 3));
    }

    @Test
    public void testUpperFloor() throws Exception {
        Integer[] arr = {1, 1, 3, 3, 4, 4};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("upper_floor", Comparable[].class, Comparable.class);
        method.setAccessible(true);


        // 找一个小于数组中所有元素的数，返回0
        assertEquals(-1, method.invoke(null, arr, 0));
        // 找一个数组中不存在但是有比其值小的数，返回比他小的最大值
        assertEquals(1, method.invoke(null, arr, 2));
        // 找一个大于数组中所有元素的数，返回数组的最后一个数
        assertEquals(arr.length - 1, method.invoke(null, arr, 5));

        //功能测试
        assertEquals(3, method.invoke(null, arr, 3));
    }

    @Test
    public void testBinarySearch() throws Exception {
        Integer[] arr = {1,2,3,4,5,6,9};
        Class c = BinarySearch.class;
        Method method = c.getDeclaredMethod("search2", Comparable[].class, Comparable.class);
        method.setAccessible(true);

        assertEquals(0, method.invoke(null, arr, 1));
        assertEquals(1, method.invoke(null, arr, 2));
        assertEquals(-1, method.invoke(null, arr, 0));
        assertEquals(-1, method.invoke(null, arr, 8));

    }
}
