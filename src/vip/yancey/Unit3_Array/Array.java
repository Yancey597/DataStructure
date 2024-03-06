package vip.yancey.Unit3_Array;

import java.util.ArrayList;

/**
 * @author Yancey
 * @version 1.0
 * @className Array
 * @date 2023/11/24-10:42
 * @description TODO
 */

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        try {
            data = (E[]) new Object[capacity];
        } catch (Exception e) {
            throw new RuntimeException("数组创建失败！");
        }
        this.size = 0;
    }

    public Array() {
        this(10);
    }


    public static void main(String[] args) {
        Array<Integer> array = new Array(5);

        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(2);
        array.addFirst(2);
        array.addFirst(1);
        array.addFirst(4);
        array.addFirst(5);

        System.out.println(array);
        array.remove(1);

        array.remove(2);
        array.remove(2);
        System.out.println(array);

    }

    public E removeFirst() {
        return remove(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E removeElement(E element) {
        int search = search(element);
        if (search != -1) {
            return remove(search);
        } else {
            return null;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E[] removeAll(E element) {
        int index = -1;
        ArrayList<E> elements = new ArrayList(size);
        while ((index = search(element)) != -1) {
            E remove = remove(index);
            elements.add(remove);
        }
        return (E[]) elements.subList(0, elements.size()).toArray(new Integer[0]);
    }

    public E remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Array is empty!");
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        if (size < (getCapacity() / 2) && size != 1) {
            shrink();
        }

        return e;
    }

    public int search(E e) {
        if (isEmpty() || e == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index error");
        }
        E ee = data[index];
        data[index] = e;
        return ee;
    }


    public boolean isFull() {
        return size == getCapacity();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        if (isFull()) {
            resize();
        }
        data[size] = e;
        size++;
    }

    public void addFirst(E e) {
        if (isFull()) {
            resize();
        }
        Insert(e, 0);
    }

    public void Insert(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("AddLast is fail, the index is error!");
        }
        if (isFull()) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder prs = new StringBuilder();
        prs.append("----- Print Array -----\n");
        prs.append(String.format("Array: capacity = %d, size = %d", getCapacity(), getSize()));
        if (size != 0) {
            prs.append("\n[");
        }
        for (int i = 0; i < size; i++) {
            prs.append(data[i]);
            if (i != size - 1) {
                prs.append(", ");
            } else {
                prs.append("]");
            }
        }
        return prs.toString();
    }

    public void resize() {
        E[] newArray = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    public void shrink() {
        if (getCapacity() > 1) {
            E[] newArray = (E[]) new Object[getCapacity() / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }


    public void printArray() {
        System.out.println("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
