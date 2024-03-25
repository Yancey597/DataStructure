package lanqiao.longest_multiple_string12;//import org.junit.Test;

import java.util.Scanner;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-19-19:53
 * @description TODO
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String S = scan.next();
//        int x = scan.nextInt();
        int prefix = new Solution().prefix("0268", 8);
        System.out.println("prefix = " + prefix);

        scan.close();
    }

    private int prefix(String s, int x) {
        if (s == null || (s.length() == 1 && s.charAt(0) - '0' % x != 0)) {
            return 0;
        }
        if (s.length() == 1 && s.charAt(0) - '0' % x == 0) {
            return 1;
        }
        int[] temp = new int[s.length() + 1];
        temp[0] = 0;
        int count = 0;
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i + 1] = temp[i] + (s.charAt(i) - '0');
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }

        for (int i = 1; i < temp.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((temp[i] - temp[j]) % x == 0) {
                    System.out.println("j-i = " + (i - j));
                }
            }
        }

        return count;
    }

}
