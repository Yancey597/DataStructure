package leetcode.LinkedList.RemoveLinkedListElements_203.practice;//import org.junit.Test;

import leetcode.LinkedList.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Practice_Solution
 * @date 2023/12/16-20:18
 * @description TODO
 */

public class Practice_Solution {
    public static ListNode removeLinkedListElements(ListNode head, int target) {
        if (head == null) {
            throw new IllegalArgumentException("head is null!");
        }

        while (head != null && head.val == target) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null && prev.next.val == target) {
            ListNode cur = prev.next;
            prev.next = prev.next.next;
            cur.next = null;
        }
        return head;
    }

}
