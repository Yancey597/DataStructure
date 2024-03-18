package vip.yancey.Unit10_BinarySearch;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className BinarySearch1
 * @date 2024-03-18-14:22
 * @description TODO
 */

public class BinarySearch1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 5, 6};
        int target = 2;
        int left = new BinarySearch1().lower_ceil(nums, target);
        int right = new BinarySearch1().upper_floor(nums, target);
        System.out.println(" left = " + left + ", right = " + right);
        if (left <= right && (left != -1)) {
            System.out.println(" left = " + left + ", right = " + right);
        } else {
            System.out.println("-1, -1");
        }
    }

    private int upper_floor(int[] nums, int target) {
        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private int lower_ceil(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

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

    private int lower_floor(int[] nums, int target) {
        int lower = lower(nums, target);
        if (lower + 1 < nums.length && nums[lower + 1] == target) {
            return lower + 1;
        }
        return lower;
    }

    private int lower(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = -1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    private int upper(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == nums.length ? -1 : l;
    }

    private int upper_ceil(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int upper = upper(nums, target);
        if (upper >= 1 && nums[upper - 1] == target) {
            return upper - 1;
        }
        return upper;
    }


}
