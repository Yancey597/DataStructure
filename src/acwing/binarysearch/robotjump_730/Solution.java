package acwing.binarysearch.robotjump_730;//import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-18-19:54
 * @description TODO
 */

public class Solution {
    private static int a;

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] nums = new int[n];
        int[] nums = {0,
                29, 2, 24, 14, 9, 17, 29, 22, 11, 13, 15, 30, 27, 19, 15, 30, 7, 24, 6, 4,
                17, 18, 12, 24, 25, 11, 23, 27, 30, 27
        };
        int l = 0;
        int r = Arrays.stream(nums).max().getAsInt() + 1;
        a = r;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, nums)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
//        scan.close();
    }

    private static boolean check(int num, int[] nums) {
        int cur = num;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("cur = " + cur);
            cur = (2 * cur - nums[i + 1]);
            if (cur >= a) {
                return true;
            }
            if (cur < 0) {
                return false;
            }
        }

        return true;

    }


}
