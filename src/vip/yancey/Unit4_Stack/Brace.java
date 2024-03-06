package vip.yancey.Unit4_Stack;/**
 * ClassName: Brace
 * Package: vip.yancey.Day4_Stack
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/28 20:25
 * @Version 1.0
 */
//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Brace
 * @date 2023/11/28-20:25
 * @description TODO
 */

public class Brace {
    static ArrayStack<Character> arr = new ArrayStack();

    public static boolean matches(String str) {
        if (str.length() <= 1 || str.length() % 2 != 0) {
            return false;
        }

        int i =0;
        while (i < str.length()){
            while (i < str.length()&&(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(')) {
                arr.push(str.charAt(i));
                i++;
            }
            if (i == str.length()) {
                return false;
            }
            while (i < str.length()&&(str.charAt(i) == ']' || str.charAt(i) == ')' || str.charAt(i) == '}')) {
                if (i < str.length()&&arr.peek() == '[' && (str.charAt(i) == ']')) {
                    arr.pop();
                    i++;
                    break;
                }
                if (i < str.length()&&arr.peek() == '(' && (str.charAt(i) == ')')) {
                    arr.pop();i++;
                    break;

                }
                if (i < str.length()&&arr.peek() == '{' && (str.charAt(i) == '}')) {
                    arr.pop();i++;
                    break;

                }

            }

        }
        if (arr.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "(()))";
        System.out.println(matches(str));
    }
}