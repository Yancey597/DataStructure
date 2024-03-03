package vip.yancey.Day5_Queue;

/**
 * ClassName: Queue
 * Package: vip.yancey.Day5_Queue
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/29 19:28
 * @Version 1.0
 */
public interface Queue<E> {
    void enQueue(E e);

    E deQueue();

    int getSize();

    boolean isEmpty();
}
