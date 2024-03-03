package vip.yancey.Day5_Queue;

/**
 * @author Yancey
 * @version 1.0
 * @className LoopQueue
 * @date 2023/11/29-20:03
 * @description TODO
 */

public class LoopQueue<E> implements Queue<E> {
    private E[] queue;
    private int size;
    private int capacity;
    private int tail, front;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        this.queue = (E[]) new Object[capacity + 1];
        this.size = 0;
        this.front = 0;
        this.tail = 0;
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(10);
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        queue.deQueue();
//        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
//        queue.enQueue(11);
        System.out.println(queue);
    }

    public int getCapacity() {
        return queue.length - 1;
    }

    public boolean isFull() {
        return ((tail + 1) % queue.length) == front;
    }

    @Override
    public void enQueue(E e) {
        if (isFull()) {
            resize(2);
        }
        queue[tail] = e;
        tail = (tail + 1) % queue.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        E data = queue[front];
        front = (front + 1) % queue.length;
        size--;
        if (size < capacity / 2 && size != 1) {
            resize(1 / 2.0);
        }
        return data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        int loops = front;
        res.append("-------PrintLoopQueue-------\n");
        res.append("LoopQueue: ");
        if (getSize() != 0) {
            res.append("Capacity = " + capacity + " size = " + getSize());
            res.append("\nfront = " + front + " [");
            for (int i = front; i != tail; i = (i + 1) % queue.length) {
                res.append(queue[i]);

                if ((i + 1) % queue.length == tail) {
                    res.append("] tail = " + tail + "\n");
                } else {
                    res.append(", ");
                }

            }
        } else {
            res.append(" empty!\n");
        }
        return res.toString();
    }

    public void resize(double num) {
        E[] newQueue = (E[]) new Object[(int) (num * capacity + 1)];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(i + front) % queue.length];
        }
        this.capacity = newQueue.length - 1;
        queue = newQueue;
        front = 0;
        tail = size;
    }
}

