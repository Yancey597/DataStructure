package vip.yancey.Unit11_BinarySearchTree;//import org.junit.Test;

import Utils.ArrayUtils.ArrayHelper;
import Utils.recursionUtils.Recursion;

import java.util.*;

/**
 * @author Yancey
 * @version 1.0
 * @className Unit11_BinarySearchTree
 * @date 2024-03-04-11:26
 * @description 二叉搜索树的实现类，包含二叉搜索树的常用方法
 */

public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        Integer[] arr = {5, 3, 6, 8, 4, 2};

        ////////////////////////
        //          5         //
        //         / \        //
        //        3   6       //
        //       / \   \      //
        //      2   4   8     //
        ////////////////////////

        for (Integer integer : arr) {
            bst.add(integer);
        }

        Random rnd = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(rnd.nextInt(10000));
        }

        ArrayList<Integer> ints = new ArrayList<>();

        for (int i = 0; i < bst.size; i++) {
            ints.add(bst.deleteMaxNode());
        }

        Integer[] array = ints.toArray(new Integer[0]);
        System.out.println("ArrayHelper.isSorted(array) = " + ArrayHelper.isSorted(array));


    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e: 待添加进二叉搜索树的元素
     * @return void
     * @author Yancey
     * @description 将指定元素 e 添加进二叉搜索树
     * @date 2024-03-05 17:56
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        return node; // 将节点返回，与原有的树结构进行连接
    }

    /**
     * @param e: 待查找的元素 e
     * @return boolean
     * @author Yancey
     * @description 查询二叉搜索树中是否含有 e
     * @date 2024-03-05 17:57
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else { // 找到 e
            return true;
        }
    }

    /**
     * @return void
     * @author Yancey
     * @description 前序遍历以 root 为根节点的二叉搜索树，深度优先搜索
     * @date 2024-03-05 16:49
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * @return void
     * @author Yancey
     * @description 借助栈实现非递归的前序遍历
     * @date 2024-03-05 22:22
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * @return void
     * @author Yancey
     * @description 中序遍历以 root 为根节点的二叉搜索树，遍历的结果是单调有序的
     * @date 2024-03-05 17:19
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTStr(root, 0, res);
        return res.toString();
    }

    private String generateBSTStr(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(Recursion.GenerateDepthString(depth) + "null\n");
            return res.toString();
        }

        res.append(Recursion.GenerateDepthString(depth) + node.e + "\n");
        generateBSTStr(node.left, depth + 1, res);
        generateBSTStr(node.right, depth + 1, res);

        return res.toString();
    }


    /**
     * @param :
     * @return void
     * @author Yancey
     * @description 后序遍历以 root 为根节点的二叉搜索树
     * @date 2024-03-05 17:18
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);

    }


    /**
     * @return void
     * @author Yancey
     * @description 对二叉树进行层序遍历 -> 广度优先
     * @date 2024-03-05 22:47
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

    }

    /**
     * @return E
     * @author Yancey
     * @description 递归的实现 查找二叉搜索树的最大值
     * @date 2024-03-05 22:54
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root);
    }

    private E maximum(Node node) {
        if (node.right == null) {
            return node.e;
        }
        return maximum(node.right);
    }

    /**
     * @return E
     * @author Yancey
     * @description 递归实现 查找二叉搜索树的最小值
     * @date 2024-03-05 22:56
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root);
    }

    private E minimum(Node node) {
        if (node.left == null) {
            return node.e;
        }
        return minimum(node.left);
    }


    /**
     * @return E
     * @author Yancey
     * @description 非递归的实现查找二叉搜索树的最小值
     * @date 2024-03-05 22:52
     */
    public E minimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur.e;
    }

    /**
     * @return E
     * @author Yancey
     * @description 非递归的实现 查找二叉搜索树的最大值
     * @date 2024-03-05 22:52
     */
    public E maximumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        Node cur = root.right;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    /**
     * @return E
     * @author Yancey
     * @description 递归的实现删除 二叉搜索树中的最大节点
     * 返回删除节点后新的二叉树的根
     * @date 2024-03-05 23:18
     */
    public E deleteMaxNode() {
        E maximum = maximum();
        root = deleteMaxNode(root);
        return maximum;
    }


    private Node deleteMaxNode(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            return left;
        }

        node.right = deleteMaxNode(node.right);
        return node;
    }


    /**
     * @return E
     * @author Yancey
     * @description 递归的实现 删除二叉搜索树中的最小值
     * @date 2024-03-05 23:26
     */
    public E deleteMinNode() {
        E minimum = minimum();
        root = deleteMinNode(root);
        return minimum;
    }

    private Node deleteMinNode(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            return right;
        }

        node.left = deleteMinNode(node.left);
        return node;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }


    }
}
