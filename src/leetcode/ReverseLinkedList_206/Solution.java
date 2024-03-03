package leetcode.ReverseLinkedList_206;//import org.junit.Test;

import leetcode.RemoveLinkedListElements_203.ListNode;
import recursionUtils.Recursion;

/**
 * @author Yancey
 * @version 1.0
 * @className Recursion
 * @date 2023/12/20-20:46
 * @description two pointer solve the problem of reverse linkedlist.
 */

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(array);
        System.out.println(Solution.reverse_recursion(head,0));

    }

    public static ListNode reverse_twopointers(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverse_recursion(ListNode head, int depth) {
        if (head == null || head.next == null) {
            Recursion.GenerateDepthString(depth,"start return",true);

            return head;

        } else {
            Recursion.GenerateDepthString(depth,"start recursion",true);
            ListNode rev = reverse_recursion(head.next,depth+1);
            head.next.next = head;
            head.next = null;
            Recursion.GenerateDepthString(depth,"Return rev",true);

            return rev;
        }
    }
}
