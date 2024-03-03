package vip.yancey.Day6_LinkList;
/**
 * @className LinkQueue
 * @author Yancey
 * @date 2023/12/8-9:00
 * @description 基于带头结点链表的队列
 * 通过实现 Queue 接口， 使用 LinkList 数据结构实现
 * 出队时间复杂度为 O(1), 入队时间复杂度为 O(n)
 * @version 1.0
 */

import vip.yancey.Day5_Queue.Queue;

public class LinkListQueue<E> implements Queue {
    private LinkList<E> linkeList;

    public LinkListQueue() {
        linkeList = new LinkList<>();
    }

    ;

    public static void main(String[] args) {
        LinkListQueue<Integer> linkQueue = new LinkListQueue<>();
        linkQueue.enQueue(1);
        linkQueue.enQueue(3);
        linkQueue.deQueue();
        linkQueue.enQueue(2);
        System.out.println(linkQueue);
    }

    @Override
    public void enQueue(Object o) {
        linkeList.addLast((E) o);
    }

    @Override
    public Object deQueue() {
        return (E) linkeList.removeFirst();
    }

    @Override
    public int getSize() {
        return linkeList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkeList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkQueue: front ");
        res.append(linkeList);
        return res.toString();
    }
}
