package vip.yancey.Day9_QuickSort;//import org.junit.Test;

import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className SelectK
 * @date 2024/2/20-21:20
 * @description 选择第 k 小的元素
 */

public class SelectK {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 5};
        int k = 2;
        int i = new SelectK().selectK(ints, ints.length - k);
        System.out.println(i);
    }

    public int selectK(int[] arr, int k) {
        Random rnd = new Random();
        return selectK(arr, 0, arr.length - 1, k, rnd);
    }

    public int selectK(int[] arr, int l, int r, int k, Random rnd) {
        int p = partition(arr, l, r, k, rnd);
        if (p == k) {
            return arr[k];
        } else if (p > k) {
            return selectK(arr, l, p - 1, k, rnd);
        } else {
            return selectK(arr, p + 1, r, k, rnd);
        }
    }

    public int partition(int[] arr, int l, int r, int k, Random rnd) {
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        int i = l + 1;
        int j = r;
        int e = arr[l];
        while (true) {
            while (i <= r && arr[i] < e) {
                i++;
            }
            while (j >= l + 1 && arr[j] > e) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
