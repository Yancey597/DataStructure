package vip.yancey.Day6_LinkList;

/**
 * ClassName: LinkList
 * Package: vip.yancey.Day6_LinkList
 * Description: dummyHead 单链表的实现
 *
 * @Author Yancey
 * @Create 2023/12/7 17:35
 * @Version 1.0
 */
//import org.junit.Test;

public class LinkList<E> {
    private int size;
    private Node<E> dummyHead;

    public LinkList() {
        dummyHead = new Node();
        size = 0;
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 0; i < 5; i++) {
            linkList.addLast(i);
            System.out.println(linkList);
        }
        System.out.println(
                "--------------------"
        );
        linkList.add(0, 1);
        linkList.add(0, 2);
        linkList.set(1, 3);
        linkList.delete(1);
        System.out.println(linkList);
    }

    public void addFirst(E e) {
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    /*
     * @param index: int 索引位置
     * @return LinkList<Node<E>
     * @author Yancey
     * @description 获取传入参数 index 索引处的 node
     * @date 2023/12/8 18:29
     */
    public Node<E> getNodeAt(int index) {
        if ((index < 0 && index != -1) || index >= size) {
            throw new IllegalArgumentException("index is invalid!");
        }
        if (index == -1) {
            //针对只有 dummyHead，添加 Node 调用 (index-1) 找索引位置前一个结点，出现异常的情况
            return dummyHead;
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, index is invalid!");
        }

        Node prev = getNodeAt(index - 1);
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
        prev.next = new Node(e, prev.next);
        size++;
    }


    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed, index is invalid!");
        }
        Node cur = getNodeAt(index);
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (; cur != null; cur = cur.next) {
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed, index is invalid.");
        }
        Node prev = getNodeAt(index - 1);
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return (E) delNode.e;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        res.append("Linklist: ");

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur.e + " -> ");
        }
        res.append("NULL");
        return res.toString();
    }

    public E removeFirst() {
        return delete(0);
    }

    public E getFirst() {
        return getNodeAt(0).e;
    }

    private class Node<E> {
        public E e;
        public Node<E> next;

        public Node() {
            e = null;
            next = null;
        }

        public Node(E e) {
            this.e = e;
            next = null;
        }

        public Node(E e, Node node) {
            this.e = e;
            next = node;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
