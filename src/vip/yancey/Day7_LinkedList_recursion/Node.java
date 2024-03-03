package vip.yancey.Day7_LinkedList_recursion;

public class Node<E> {
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

    public Node(E e, Node<E> node) {
        this.e = e;
        next = node;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}