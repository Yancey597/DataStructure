package leetcode.QuickSort.SortColors_75;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024/2/20-0:09
 * @description 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */

public class Solution {
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length - 1);
    }

    public void sortColors(int[] nums, int l, int r) {
        // 循环不变量
        // nums[0...zero]
        // nums[zero+1, i-1]
        // nums[two, r]
        int zero = -1;
        int two = r + 1;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, two, i);
            } else {
                i++;
            }
        }
    }
}
