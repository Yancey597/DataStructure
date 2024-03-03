package vip.yancey.Day5_Queue;/**
 * ClassName: ArrayQueue
 * Package: vip.yancey.Day5_Queue
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/29 19:29
 * @Version 1.0
 */
//import org.junit.Test;

import vip.yancey.Day3_Array.Array;

/**
 * @author Yancey
 * @version 1.0
 * @className ArrayQueue
 * @date 2023/11/29-19:29
 * @description TODO
 */

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> queue;
    private int capacity;
    private int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        queue = new Array<E>(capacity);
        this.capacity = capacity;
        size = 0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for (int i = 1; i <= 10; i++) {
            queue.enQueue(i);
            if (i % 3 == 0) {
                queue.deQueue();
            }
        }
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue);
    }

    @Override
    public void enQueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E deQueue() {
        return queue.removeFirst();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("-------PrintQueue-------\n");
        res.append("Queue: ");
        if (queue.getSize() != 0) {
            res.append("Capacity = " + queue.getCapacity() + " size = " + queue.getSize());
            res.append("\n front [");
            for (int i = 0; i < queue.getSize(); i++) {
                res.append(queue.get(i));
                if (i != getSize() - 1) {
                    res.append(", ");
                } else {
                    res.append("] rear\n");
                }
            }
        }

        return res.toString();
    }


}
