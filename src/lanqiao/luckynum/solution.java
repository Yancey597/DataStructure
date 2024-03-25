package lanqiao.luckynum;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className solution
 * @date 2024-03-18-22:33
 * @description TODO
 */

public class solution {
    public static void main(String[] args) {
        long sub = 1;
        for (int i = 1; i < 50; i++) {
            sub = 1;
            int n = i;
            while (n > 0) {
                sub *= n;
                n--;
            }
            System.out.println("sub = " + sub);
        }


    }

    public static boolean check(int x, int mod) {
        int sum = 0;
        int n = x;
        while (x > 0) {
            sum += (x % mod);
            x /= mod;
        }

        return n % sum == 0;

    }
}
