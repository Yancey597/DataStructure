package Utils.recursionUtils.practice;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Array
 * @date 2023/12/9-16:05
 * @description TODO
 */

public class ArraySum {
    private static int sum(int[] arr) {
        return sum(arr,0);
    }

    // 计算 arr[l, n) 范围的和
    private static int sum(int[]arr, int limit){
        if(limit == arr.length){
            return 0;
        }
        return arr[limit]+ sum(arr,limit+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(sum(nums));
    }
}
