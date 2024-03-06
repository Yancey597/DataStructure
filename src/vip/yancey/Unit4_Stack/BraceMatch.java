package vip.yancey.Unit4_Stack;/**
 * ClassName: BraceMatch
 * Package: vip.yancey.Day4_Stack
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/28 21:20
 * @Version 1.0
 */
//import org.junit.Test;

import java.util.Stack;

/**
 * @author Yancey
 * @version 1.0
 * @className BraceMatch
 * @date 2023/11/28-21:20
 * @description TODO
 */

public class BraceMatch {
    public static void main(String[] args) {
        System.out.println(new BraceMatch().matches("(())"));
    }

    public boolean matches(String str) {
        if (str.length() <= 1 || str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == '[' || a == '(' || a == '{') {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char b = stack.pop();
                if (b == '{' && a != '}') {
                    return false;
                }
                if (b == '(' && a != ')') {
                    return false;
                }
                if (b == '[' && a != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
