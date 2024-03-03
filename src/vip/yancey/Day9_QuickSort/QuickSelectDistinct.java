package vip.yancey.Day9_QuickSort;//import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Yancey
 * @version 1.0
 * @className s1
 * @date 2024/2/20-23:02
 * @description TODO
 */

public class QuickSelectDistinct {

    public static int findKthDifferent(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int pivot = arr[new Random().nextInt(right - left + 1) + left];
            int partitionIndex = partition(arr, left, right, pivot);

            int leftDifferentCount = countDifferentElements(arr, left, partitionIndex);

            if (k <= leftDifferentCount) {
                right = partitionIndex - 1;
            } else {
                left = partitionIndex + 1;
            }
        }

        return arr[left];
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] >= pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, left, j);

        return j;
    }

    private static int countDifferentElements(int[] arr, int left, int right) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = left; i <= right; i++) {
            if (!set.contains(arr[i])) {
                count++;
                set.add(arr[i]);
            }
        }

        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 4};
        int kthDifferent = findKthDifferent(ints, 2);
        System.out.println("kthDifferent = " + kthDifferent);
    }

}