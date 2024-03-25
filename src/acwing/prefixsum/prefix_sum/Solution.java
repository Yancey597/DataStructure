package acwing.prefixsum.prefix_sum;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-19-18:28
 * @description 输入一个长度为n的整数序列
 * 接下来再输入m个询问，每个询问输入一对l,r
 * 对于每个询问，输出原序列中从第l个数到第r个数的和.
 * 输入格式
 * 第一行包含两个整数n和m.
 * 第二行包含n个整数，表示整数数列
 * 接下来m行，每行包含两个整数l和r，表示一个询问的区间范围
 * <p>
 * 输出格式
 * 共m行，每行输出一个询问的结果
 */

public class Solution {
    private static int[] res;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int i = new Solution().searchSum(nums, 0, 4);
        System.out.println("i = " + i);

    }

    public int searchSum(int[] nums, int l, int r) {
        if (r >= nums.length) {
            throw new IllegalArgumentException("param error");
        }
        if (res == null) {
            res = prefixSum(nums);
        }

        if (l == 0) {
            return res[r];
        }

        return res[r] - res[l - 1];

    }

    private int[] prefixSum(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] + nums[i];
        }

        for (int i : temp) {
            System.out.println(i);
        }
        return temp;
    }
}
