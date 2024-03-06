package Utils.recursionUtils.practice;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className SumPrc
 * @date 2023/12/16-19:41
 * @description TODO
 */

public class SumPractice {
    public static int sum(int n) {


        return n == 1 ? 1 : n + sum(n - 1);
    }


}
