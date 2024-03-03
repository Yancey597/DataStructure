package leetcode.QuickSort.SelectK_215;//import org.junit.Test;

import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024/2/20-0:19
 * @description TODO
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4};
        System.out.println(new Solution().findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Random rnd = new Random();
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k, rnd);
    }

    public int findKthLargest(int[] nums, int l, int r, int k, Random rnd) {
        int p = partition(nums, l, r, rnd);
        if (p == k) {
            return nums[p];
        } else if (p > k) {
            return findKthLargest(nums, l, p - 1, k, rnd);
        } else {
            return findKthLargest(nums, p + 1, r, k, rnd);
        }
    }

    public int partition(int[] arr, int l, int r, Random rnd) {
        int i = l + 1, j = r;
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, p, l);

        while (true) {
            while (i <= r && arr[l] >= (arr[i])) {
                i++;
            }
            while (l + 1 <= j && arr[l] <= arr[j]) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i,j);
            i++;
            j--;
        }
        swap(arr, l,j);
        return j;
    }


    public void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

}
