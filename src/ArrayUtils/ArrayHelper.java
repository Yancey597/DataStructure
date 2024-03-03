package ArrayUtils;

import vip.yancey.Day2_InsertSort.InsertSort;
import vip.yancey.Day8_MergeSort.MergeSort;

/**
 * @author Yancey
 * @version 1.0
 * @className SortHelper
 * @date 2023/11/22-21:01
 * @description 提供 数组排序相关的常用的操作，
 */

public class ArrayHelper {
    // 私有化构造函数，不允许从外部调用
    private ArrayHelper() {
    }


    // <E extends Comparable<E>> 该泛型类必须实现 Comparable 接口，并且重写compareTo 方法

    /**
     * @param data: 待检测的数组
     * @return boolean
     * @author Yancey
     * @description 检测数组是否有序
     * @date 2024/2/5 21:14
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        boolean ascending = true;
        boolean decending = true;

        // 检测数组是否递增
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                ascending = false;
            }
        }
        if (ascending) {
            return true;
        }
        // 检测数组是否递减
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) > 0) {
                decending = false;
            }
        }
        return decending;
    }


    /**
     * @param data:     待打印的数组
     * @param isSorted: 数组是否有序
     * @return void
     * @author Yancey
     * @description 输出数组：可检测数组是否有序
     * @date 2024/2/6 17:27
     */
    public static <E extends Comparable<E>> void printArray(E[] data, boolean isSorted) {
        if (isSorted) {
            System.out.print("Array [Sorted] : ");
        } else {
            System.out.print("Array [Unsorted]: ");
        }
        printArray(data);
    }

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print(']');
    }

    public static <E extends Comparable<E>> void printArray(E[] data) {
        for (E e : data) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    /**
     * @param arr: 待数组的数组
     * @param l:   左边界
     * @param r:   右边界
     * @return void
     * @author Yancey
     * @description 输出数组的某个区间
     * @date 2024/2/6 17:35
     */
    public static <E extends Comparable<E>> void printArray(E[] arr, int l, int r) {

        if (l > r || l < 0 || r < 0) {
            throw new IllegalArgumentException("l, r arguments error ");
        }

        for (int i = l; i <= r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param arr:   数组
     * @param l:     左边界
     * @param r:     右边界
     * @param chars: 是否需要框选
     * @return void
     * @author Yancey
     * @description 输出指定数组，并可以框选指定的区间
     * @date 2024/2/6 17:42
     */
    public static <E extends Comparable<E>> void printArray(E[] arr, int l, int r, boolean... chars) {
        if (l > r || l < 0 || r < 0) {
            throw new IllegalArgumentException("l, r arguments error ");
        }


        boolean needToPrint = chars.length != 0 ? true : false;
        boolean hasPrint = r == arr.length - 1 ? false : true;

        for (int i = 0; i < arr.length; i++) {
            if (i == l && needToPrint) {
                System.out.print(" { ");
            }
            System.out.print(arr[i] + " ");
            if (hasPrint && needToPrint && i == r) {
                System.out.print(" } ");
            }
        }
        if (!hasPrint && needToPrint) {
            System.out.print(" } ");
        }
        System.out.println();
    }

    public static <E extends Comparable<E>> void printArray(E[] arr, int point) {
        if (point < 0) {
            throw new IllegalArgumentException("point arguments error ");
        }

        boolean hasPrint = point == arr.length - 1 ? false : true;
        System.out.print(" { ");
        for (int i = 0; i < arr.length; i++) {
            if (i == point) {
                System.out.print("} ");
            }

            System.out.print(arr[i] + " ");// 输出数组当前元素

            if (i == point && hasPrint) {
                System.out.print("{ ");
            }

        }
        if (!hasPrint) {
            System.out.print("{ ");
        }
        System.out.println("} ");
    }

    public static <E extends Comparable<E>> void printArray(E[] data, String str) {
        System.out.print(str);
        for (E e : data) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


    public static <E> void swap(E[] arr, int n1, int n2) {
        E temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static <E extends Comparable<E>> boolean compare(E a, E b) {
        return a.compareTo(b) > 0 ? true : false;
    }

    /**
     * @param n:    几条横线 支持  1||2
     * @param args: 可选参数：横线长短，默认 30
     * @return void
     * @author Yancey
     * @description 生成横线并输出
     * @date 2024/2/5 20:58
     */
    public static void printLine(int n, int... args) {
        int q = args.length == 0 ? 30 : args[0];
        String c = "-";
        switch (n) {
            case 1 -> c = "-";
            case 2 -> c = "=";
        }
        for (int i = 0; i < q; i++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * @param data:      待检测的数组
     * @param name:      排序方法名
     * @param spendTime: 花费的时间
     * @return void
     * @author Yancey
     * @description 检测经过排序后，数组是否有序
     * @date 2024/2/5 21:13
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] data, String name, double spendTime) {
        boolean checkRes = isSorted(data);
        int n = data.length;

        printArray(data, checkRes);
        if (checkRes) {
            System.out.println(String.format("[%s finished, array is sorted] ", name));
            System.out.println(String.format("[scale of data(n): %d, spend time: %f s]\n", n, spendTime));
            return true;
        } else {
            System.out.println(String.format("[%s failed, please check the code]\n", name));
            return false;
        }
    }


    public static <E extends Comparable<E>> void InsertSort(E[] data) {
        SortTimeTest.testArray(InsertSort.class, false, data);
    }

    public static <E extends Comparable<E>> void MergeSort(E[] data) {
        SortTimeTest.testArray(MergeSort.class, false, data);
    }

    /**
     * @param l: 左边界
     * @param r: 右边界
     * @return int
     * @author Yancey
     * @description 生成 [l, r] 偏向左侧的中点(向下取整)
     * @date 2024-02-29 22:40
     */
    public static int midL(int l, int r) {
        return l + ((r - l) >> 1);
    }

    /**
     * @param l: 左边界
     * @param r: 右边界
     * @return int
     * @author Yancey
     * @description 生成 [l, r] 偏向右侧的中点(向上取整)
     * @date 2024-02-29 22:41
     */
    public static int midR(int l, int r) {
        return l + ((r - l + 1) >> 1);
    }
}
