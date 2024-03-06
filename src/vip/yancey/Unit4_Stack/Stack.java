package vip.yancey.Unit4_Stack;/**
 * ClassName: Stack
 * Package: vip.yancey.Day4_Stack
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/28 19:16
 * @Version 1.0
 */
//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Stack
 * @date 2023/11/28-19:16
 * @description TODO
 */

public interface Stack<E> {
    void push(E e);
    E pop();
    E peek();
    boolean isEmpty();
    int getSize();
}
