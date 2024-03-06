package vip.yancey.Unit10_BinarySearch;//import org.junit.Test;

import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className SelectK
 * @date 2024/2/21-22:17
 * @description TODO
 */

public class SelectK {
    public int search(int[] arr, int k) {
        Random rnd = new Random();
        return search(arr, arr.length - k, rnd);
    }

    public int search(int[] arr, int k, Random rnd) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int p = partition(arr, l, r, rnd);
            if (p == k) {
                return arr[k];
            } else if (p > k) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }

        throw new RuntimeException("error!");
    }

    public int partition(int[] arr, int l, int r, Random rnd) {
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= r && arr[i] <= arr[l]) {
                i++;
            }

            while (l + 1 <= j && arr[j] >= arr[l]) {
                j--;
            }

            if (i > j) {
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
