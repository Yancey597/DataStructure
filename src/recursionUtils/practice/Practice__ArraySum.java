package recursionUtils.practice;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Practice__ArraySum
 * @date 2023/12/16-20:09
 * @description calculate sum of array[limit, array.length-1];
 */

public class Practice__ArraySum {
    public static int sum(int[] array) {
        return sum(0, array);
    }

    private static int sum(int limit, int[] array) {
        if (limit == array.length) {
            return 0;
        }
        return sum(limit + 1, array) + array[limit];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(sum(3, array));
    }
}
