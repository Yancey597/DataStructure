package recursionUtils.practice;//import org.junit.Test;

import recursionUtils.Recursion;

/**
 * @author Yancey
 * @version 1.0
 * @className Sum
 * @date 2023/12/9-17:25
 * @description TODO
 */

public class Sum {
    private static int sum(int n, int depth) {
        String s = Recursion.GenerateDepthString(depth);
        System.out.println(s + "Call: sum " + n + "~1");
        if (n == 1) {
            System.out.println(s + "return 1");
            return 1;
        }

        int res = sum(n - 1, depth + 1) + n;
        System.out.println(s + "return n:" + n+"+[" + (n-1)+"~1]="+res);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(sum(5, 0));
//        1 1 2 3 5
    }

}
