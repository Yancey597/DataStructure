package vip.yancey.Unit4_Stack;/**
 * ClassName: ArrayStack
 * Package: vip.yancey.Day4_Stack
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/28 19:35
 * @Version 1.0
 */
//import org.junit.Test;

import vip.yancey.Unit3_Array.Array;

/**
 * @author Yancey
 * @version 1.0
 * @className ArrayStack
 * @date 2023/11/28-19:35
 * @description TODO
 */

public class ArrayStack<E> implements Stack<E> {
    Array<E> arrayStack;

    public ArrayStack(int capacity) {
        arrayStack = new Array(capacity);
    }

    public ArrayStack() {
        arrayStack = new Array(10);
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arr = new ArrayStack<>(3);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);
        arr.push(5);
        arr.push(5);
        System.out.println(arr);
        System.out.println(arr.peek());
    }

    public int getCapacity() {
        return arrayStack.getCapacity();
    }

    @Override
    public void push(E e) {
        arrayStack.addLast(e);
    }

    @Override
    public E pop() {
        return arrayStack.removeLast();
    }

    @Override
    public E peek() {
        return arrayStack.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arrayStack.isEmpty();
    }

    @Override
    public int getSize() {
        return arrayStack.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-------PrintStack-------\n");
        res.append("Stack: ");
        if (arrayStack.getSize() != 0) {
            res.append("Capacity = " + getCapacity() + " size = " + getSize());
            res.append("\n bottom [");
            for (int i = 0; i < arrayStack.getSize(); i++) {
                res.append(arrayStack.get(i));
                if (i != getSize() - 1) {
                    res.append(" ,");
                } else {
                    res.append("] top\n");
                }
            }
        }
        return res.toString();
    }
}
