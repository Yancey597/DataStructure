package Utils.recursionUtils.practice;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Fibonacci
 * @date 2023/12/9-17:44
 * @description TODO
 */

public class Fibonacci {
    private static int fibonacci(int n) {
        if (n == 1 || n == 2 || n == 0) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
//    11 23

    public static int fibonacciSum(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return fibonacci(n) + fibonacciSum(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSum(6));
//        1 1 2 3 5 8
    }
}
