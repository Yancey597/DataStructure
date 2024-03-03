package leetcode.QuickSort.SelectMostSmall_LCR159;//import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024/2/20-16:41
 * @description 仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。
 * 请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
 * url: https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/description/
 */

public class Solution {

    public int[] inventoryManagement(int[] stock, int cnt) {
        Random rnd = new Random();
        inventoryManagement(stock, 0, stock.length - 1, cnt - 1, rnd);
        return Arrays.copyOf(stock, cnt);
    }

    public int inventoryManagement(int[] arr, int l, int r, int cnt, Random rnd) {
        int p = partition(arr, l, r, rnd);
        if (p == cnt) {
            return arr[p];
        } else if (p > cnt) {
            return inventoryManagement(arr, l, p - 1, cnt, rnd);
        } else {
            return inventoryManagement(arr, p + 1, r, cnt, rnd);
        }
    }

    public int partition(int[] arr, int l, int r, Random rnd) {
        int i = l + 1, j = r;
        int p = rnd.nextInt(r - l + 1) + l;
        swap(arr, p, l);

        while (true) {
            while (i <= r && arr[l] > (arr[i])) {
                i++;
            }
            while (l + 1 <= j && arr[l] < arr[j]) {
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
