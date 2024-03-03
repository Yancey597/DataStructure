package vip.yancey.Day7_LinkedList_recursion;

public class LinkList<E> {
    private Node<E> head;
    private int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    public LinkList(E e) {
        addFirst(e);
    }

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 1; i < 5; i++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }

        System.out.println("--------------------");
        linkList.delete(0);
        System.out.println(linkList);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size - 1, e);
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        size++;
    }

    public void add(int index, E e) {
        head = add(e, index, head);
    }

    private Node add(E e, int index, Node node) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("please check the value of index!");
        }
        if (index == 0) {
            size++;
            return new Node(e, node);
        }

        node.next = add(e, index - 1, node.next);
        return node;
    }

    public void delete(int index) {
        head = delete(index, head);
    }

    public Node delete(int index, Node node) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("please check the value of index!");
        }
        if (index == 0) {
            size--;
            return node.next;
        }
        node.next = delete(index - 1, node.next);
        return node;
    }

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node<E> removeElement(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        node.next = removeElement(node.next, e);
        if (node.e.equals(e)) {
            size--;
            return node.next;
        } else {
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node<E> cur = head; cur != null; cur = cur.next) {
            res.append(cur.e).append(" -> ");
        }
        res.append("NULL");
        return res.toString();
    }
}