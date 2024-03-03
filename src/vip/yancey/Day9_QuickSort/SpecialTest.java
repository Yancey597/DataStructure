package vip.yancey.Day9_QuickSort;//import org.junit.Test;

import ArrayUtils.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className SpecialTest
 * @date 2024/2/6-23:28
 * @description TODO
 */

public class SpecialTest {

    public static void main(String[] args) {
        Integer[] integers = generateSpecialArray(10);
        Arrays.stream(integers).forEach((e)-> System.out.print(e+" "));
    }

//    把最小值放到中间；
//    模拟 partition 过程，把中间元素和最左边元素交换位置；
//    现在，要处理除了最左边的元素之外，剩下的 n - 1 个元素；
//    都处理好以后，还要把中间的元素和最左边的元素交换回来。

    //    这个函数完成的任务是，生成 arr[l...r]的测试数据，其中的最小值是 v``。
    //    注意，这是一个私有的接口，由公有接口调用。我们整体公有的，供用户使用
    //    的 generateSpecialArray，逻辑是这样的：
    public static Integer[] generateSpecialArray(int n) {
        // 开空间
        Integer[] arr = new Integer[n];

        // 生成 arr[0...n-1] 的测试用例，其中最小值是 0
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;
    }

    //    下面，我们关键是看这个私有的，递归的 generateSpecialArray 的逻辑。其实，
    //    它的逻辑，就是上面说的四步。不过，我们还要处理递归到底的基本情况：
    private static void generateSpecialArray(Integer[] arr, int l, int r, int value) {
        // 递归到底的情况。如果 l > r，我们要处理的区间为空，直接返回
        if (l > r) {
            return;
        }
        // 1. 把最小值放到中间
        int mid = (l + r) / 2;
        arr[mid] = value;

        // 2. 模拟 partition 过程，把中间元素和最左边元素交换位置；
        ArrayHelper.swap(arr, l, mid);

        // 3. 处理除了最左边的元素之外，剩下的 n - 1 个元素；
        // 所以，处理的区间变成了 arr[l+1...r]，同时，最小值 + 1
        generateSpecialArray(arr, l + 1, r, value + 1);

        // 4. 都处理好以后，还要把中间的元素和最左边的元素交换回来。
        ArrayHelper.swap(arr, l, mid);
    }
}
