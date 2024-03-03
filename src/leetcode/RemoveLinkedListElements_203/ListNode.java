package leetcode.RemoveLinkedListElements_203;//import org.junit.Test;

import leetcode.RemoveLinkedListElements_203.practice.Practice_Solution;

/**
 * @author Yancey
 * @version 1.0
 * @className ListNode
 * @date 2023/12/9-14:31
 * @description Linked List implements class.
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr cannot be empty");
        }
        ListNode cur = this;
        this.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Practice_Solution.removeLinkedListElements(new ListNode(nums), 2));
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (ListNode cur = this; cur != null; cur = cur.next) {
            res.append(cur.val + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
