package recursionUtils.practice;//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className FibonacciPractice
 * @date 2023/12/16-19:45
 * @description TODO
 */

public class FibonacciPractice {
    public static int fibonacci(int n) {
        return n==1||n==2 ? 1 : fibonacci(n-1)+fibonacci(n-2);
    }

    public static String generate(int n){
        StringBuilder res = new StringBuilder();
        res.append("fibonacci: ");
        for (int i = 1; i <= n; i++) {
            res.append(fibonacci(i)+" ");
        }
        return res.toString();
    }

    public static int sum(int n){
        return n == 1? 1 : sum(n-1)+fibonacci(n);
    }

    @Test
    public void test(){
        System.out.println(generate(5));
        System.out.println(sum(5));
    }

}
