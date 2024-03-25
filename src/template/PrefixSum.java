package template;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className prefixSum
 * @date 2024-03-23-21:37
 * @description TODO
 */

public class PrefixSum {
    private static int[] prefixSum;
    private static int[][] two_prefixSum;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int i = prefixSum(nums, 6, 6);
        System.out.println("i = " + i);


    }

    public static int prefixSum(int[] nums, int l, int r) {
        if (prefixSum == null) {
            prefixSum = new int[nums.length + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
        }
        return prefixSum[r] - prefixSum[l - 1];
    }

    private static int prefixSum(int[][] nums, int l, int r) {
        if (two_prefixSum == null) {
            two_prefixSum = new int[nums.length + 1][nums[0].length + 1];
            two_prefixSum[0][0] = 0;

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= nums[0].length; j++) {
                    two_prefixSum[i][j] = two_prefixSum[i - 1][j] + two_prefixSum[i][j - 1] - two_prefixSum[i - 1][j - 1] + nums[i - 1][j - 1];
                }
            }

        }
        return two_prefixSum[l][r];
    }

}
