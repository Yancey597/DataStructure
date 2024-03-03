package vip.yancey.Day6_LinkList;
/**
 * ClassName: LinkStack
 * Package: vip.yancey.Day6_LinkList
 * Description:通过实现 Stack 接口， 基于 LinkList 数据结构实现的栈。
 * 在表头进行数据的入栈和出栈操作，时间复杂度均为 O(1)
 *
 * @Author Yancey
 * @Create 2023/12/7 20:44
 * @Version 1.0
 */
//import org.junit.Test;

import vip.yancey.Day4_Stack.Stack;


public class LinkStack<E> implements Stack {
    private LinkList<E> list;

    public LinkStack() {
        list = new LinkList<>();
    }

    public static void main(String[] args) {
        LinkStack<Integer> linkStack = new LinkStack<>();
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.pop();
        System.out.println(linkStack);


    }

    @Override
    public void push(Object o) {
        list.addFirst((E) o);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
