package vip.yancey.Unit5_Queue;

/**
 * ClassName: LinkQueue
 * Package: vip.yancey.Day5_Queue
 * Description: 基于链式存储实现的栈
 *
 * @Author Yancey
 * @Create 2023/12/8 17:49
 * @Version 1.0
 */
//import org.junit.Test;

public class LinkQueue<E> implements Queue {
    private int size;
    private Node head, tail; // 使用 head, tail 来追踪队头和队尾，便于入队和出队操作

    public LinkQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        LinkQueue<Integer> linkQueue = new LinkQueue();
        for (int i = 0; i < 5; i++) {
            linkQueue.enQueue(i);
        }
        System.out.println(linkQueue);

    }

    /*
     * @param o: 待入队的元素，需要转为泛型 E
     * @return void
     * @author Yancey
     * @description 进行入队操作：
     * 1) 当队为空时，创建 node 使 head = tail = node;
     * 2) 当队不为空时,tail.next = node;tail = tail.next;
     * @date 2023/12/8 18:37
     */
    @Override
    public void enQueue(Object o) {
        if (tail == null) { // 也可以使用 isEmpty()，tail == null 使语法更加简洁。
            tail = new Node((E) o);
            head = tail;
        } else {
            tail.next = new Node((E) o);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty, deQueue failed");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) { // 需要考虑队中只有一个元素的情况，需要使 tail =null;
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        for (Node iter = head; iter != null; iter = iter.next) {
            res.append(iter + " -> ");
        }
        res.append("NULL tail");
        return res.toString();
    }

    private class Node {
        private Node next;
        private E e;

        private Node() {
            e = null;
            next = null;
        }

        private Node(E e) {
            this.e = e;
            next = null;
        }

        private Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
