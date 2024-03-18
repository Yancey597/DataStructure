package acwing.recursion.num_range_789;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-18-11:21
 * @description 给定一个按照升序排列的长度为n的整数数组，以及 q 个查询。
 * 对于每个查询，返回一个元素k的起始位置和终止位置（位置从0开始计数）。
 * 如果数组中不存在该元素，则返回“-1 -1”。
 * <p>
 * 输入格式
 * 第一行包含整数n和q，表示数组长度和询问个数。
 * 第二行包含n个整数（均在1~10000 范围内），表示完整数组。
 * <p>
 * 接下来q行，每行包含一个整数k，表示一个询问元素。
 * <p>
 * 输出格式
 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * <p>
 * 如果数组中不存在该元素，则返回“-1 -1”。
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = nums.length;
        int target = 6;

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] == target) {
            System.out.print(l + " ");
            r = n - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l);
        } else {
            System.out.println("-1 -1");
        }


    }

    private int findIndex_max(int target, int[] nums) {
        int l = 0, r = nums.length;
        int findIndex = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    findIndex = mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return findIndex == -1 ? l : findIndex;
    }

    private int findIndex_min(int target, int[] nums) {
        int r = nums.length;
        int l = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == nums.length ? -1 : l;
    }

}
