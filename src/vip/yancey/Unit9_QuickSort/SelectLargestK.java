package vip.yancey.Unit9_QuickSort;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className SelectLargestK
 * @date 2024/2/20-21:33
 * @description TODO
 */

public class SelectLargestK {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 1, 1, 2};
        int[] ints = new SelectLargestK().selectLargestK(arr, 4);
        ArrayHelper.printArray(ints);
        ArrayHelper.printArray(arr);

    }

    public int[] selectLargestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int q = selectK(arr, 0, arr.length - 1, k - 1, new Random());
        return Arrays.copyOf(arr, k);
    }

    public int selectK(int[] arr, int l, int r, int k, Random rnd) {
        int p = partition(arr, l, r, k, rnd);
        if (p == k) {
            return arr[p];
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
        while (true) {
            // arr[l+1...i-1] <=v
            while (i <= r && arr[i] < arr[l]) {
                i++;
            }
            while (l + 1 <= j && arr[j] > arr[l]) {
                j--;
            }
            // arr[r...r] >= v
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
