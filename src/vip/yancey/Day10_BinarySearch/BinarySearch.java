package vip.yancey.Day10_BinarySearch;//import org.junit.Test;

import static ArrayUtils.ArrayHelper.midL;
import static ArrayUtils.ArrayHelper.midR;

/**
 * @author Yancey
 * @version 1.0
 * @className BinarySearch
 * @date 2024/2/21-17:50
 * @description TODO
 */

public class BinarySearch {
    private BinarySearch() {
    }

    public static void main(String[] args) {
        Integer[] ints = {0, 1, 1, 1};
//        for (int i = 0; i < ints.length; i++) {
        int search = search2(ints, -1);
        System.out.println(search + "  ");
//        }
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查询的目标值
     * @return int: 返回目标值的索引，如果没查询到返回-1
     * @author Yancey
     * @description 半闭区间实现的二分查找，数组的查找范围为[l, r)
     * @date 2024/2/22 23:51
     */
    public static <E extends Comparable<E>> int search(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = 0;
        int r = arr.length; // 查找范围 [l, r), r 初始化为 arr.length

        // 在data[l, r) 的范围中查找 target
        while (l < r) { // 当 l == r 时, 搜索范围为空循环结束
            int mid = l + (r - l) / 2;
            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else { // arr[mid] 大于目标值时, 区间在 mid 左侧, 因为左闭右开区间, r = mid
                r = mid;
            }
        }
        return -1;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查询的目标值
     * @return int: 返回目标值的索引，如果没查询到返回-1
     * @author Yancey
     * @description 全闭区间实现的二分查找，数组的查找范围为[l, r]
     * @date 2024/2/22 23:46
     */
    public static <E extends Comparable<E>> int search1(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = 0;
        int r = arr.length - 1; //全闭区间包含数组最右边的元素

        // 在data[l, r] 的范围中查找 target
        while (l <= r) { // data[l, r] 中查询, 所以是 l <= r, 当 l > r 时搜索范围为空循环结束
            int mid = l + (r - l) / 2;
            if (arr[mid].equals(target)) { // 找到目标值返回其下标
                return mid;
            } else if (arr[mid].compareTo(target) < 0) { // 中点值小于目标值
                l = mid + 1;
            } else { // 中点值大于于等于目标值
                r = mid - 1;
            }
        }
        return -1; // 没找到返回 -1
    }


    public static <E extends Comparable<E>> int search2(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = midL(l, r);
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if(arr[l].compareTo(target) == 0){
            return l;
        }else{
           return  -1;
        }

    }

    public static <E extends Comparable<E>> int searchR(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        return searchR(arr, 0, arr.length - 1, target);
    }

    /**
     * @param arr: 待查找的数组
     * @param t:   待查询的目标值
     * @param l:   查找区间的左边界
     * @param r:   查找区间的右边界
     * @return int
     * @author Yancey
     * @description 递归实现的二分查找法, 全闭区间
     * @date 2024/2/22 23:57
     */
    public static <E extends Comparable<E>> int searchR(E[] arr, int l, int r, E t) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;

        if (t.equals(arr[mid])) {
            return mid;
        } else if (t.compareTo(arr[mid]) < 0) {
            return searchR(arr, l, mid - 1, t);
        } else {
            return searchR(arr, mid + 1, r, t);
        }

    }

    /*
     * @param arr: 待查找的数组
     * @param target: 目标值
     * @return int 返回大于 target 的最小值的索引，如果没有则返回数组长度值
     * @author Yancey
     * @description 查找 > target 的最小值的索引
     * @date 2024/2/21 23:47
     */
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

//        if (target.compareTo(arr[arr.length - 1]) >= 0) {
//            return -1;
//        }

        // 确定搜索范围 arr[0, arr.length] 在范围内搜索解
        // 无论 target 有多大返回：arr.length
        // target 小于数组所有的元素时返回：0
        int l = 0;
        int r = arr.length;

        while (l < r) { // 采用半闭区间
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的目标值
     * @return int
     * @author Yancey
     * @description 找到小于目标值的最大值索引，如果不存在返回-1
     * @date 2024-02-25 17:16
     */
    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        if (target.compareTo(arr[0]) <= 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;

        // 在这个范围内一定能找到解 [l, r]
        while (l < r) {
            int mid = midR(l, r);
            if (arr[mid].compareTo(target) >= 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的值
     * @return int
     * @author Yancey
     * @description 如果数组中包含 target 则返回靠右的 target 的索引，否则返回大于 target 的最小值。
     * @date 2024/2/22 0:03
     */

    public static <E extends Comparable<E>> int upper_ceil2(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = upper(arr, target);
        if (l - 1 >= 0 && arr[l - 1].equals(target)) {
            return l - 1;
        }

        return l;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的值
     * @return int
     * @author Yancey
     * @description 如果数组中包含 target 则返回靠右的 target 的索引(upper)，否则返回大于 target 的最小值(ceil 上界天花板)。
     * @date 2024/2/22 0:03
     */
    public static <E extends Comparable<E>> int upper_ceil1(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = 0;
        int r = arr.length;
        int foundIndex = -1; // 用于记录目标元素的索引

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) > 0) {
                r = mid;
            } else {
                l = mid + 1;
                if (arr[mid].equals(target)) {
                    foundIndex = mid; // 更新目标元素的索引
                }
            }
        }

        return foundIndex != -1 ? foundIndex : l;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的值
     * @return int
     * @author Yancey
     * @description 如果数组中包含 target 则返回靠左的 target 的索引(lower)，否则返回大于 target 的最小值(ceil 上界天花板)。
     * @date 2024-02-25 16:46
     */
    public static <E extends Comparable<E>> int lower_ceil(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = midL(l, r);
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的值
     * @return int
     * @author Yancey
     * @description 如果数组中存在 target 返回左侧索引(lower)，如果不存在返回小于 target 的最大索引(floor)
     * @date 2024-02-29 21:17
     */
    public static <E extends Comparable<E>> int lower_floor(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = lower(arr, target);
        if (l + 1 < arr.length && arr[l + 1].equals(target)) {
            return l + 1;
        } else {
            return l;
        }
    }

    public static <E extends Comparable<E>> int lower_Floor(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = -1;
        int r = arr.length - 1;
        System.out.println("l = " + l);
        System.out.println("r = " + r);
        int findIndex = -1;
        while (l < r) {
            int mid = (r - l + 1) / 2 + l;
            System.out.println("mid = " + mid);
            if (arr[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
                if (arr[mid].equals(target)) {
                    findIndex = mid;
                }
            }
        }
        return findIndex == -1 ? l : findIndex;
    }

    /**
     * @param arr:    待查找的数组
     * @param target: 待查找的值
     * @return int
     * @author Yancey
     * @description 如果数组中存在 target 返回右侧索引(upper)，如果不存在返回小于 target 的最大索引(floor)
     * @date 2024-02-29 21:17
     */
    public static <E extends Comparable<E>> int upper_floor(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr is illegal");
        }

        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}