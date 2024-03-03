package leetcode.RemoveLinkedListElements_203.forLoop;//import org.junit.Test;


import leetcode.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution_dummyHead
 * @date 2023/12/9-15:06
 *  @description leetcode 203 题 java 实现
 *   此版本为带虚拟头结点版本
 */

public class Solution_dummyHead {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(1, head);
        ListNode prevNode = dummyHead;

        while (prevNode.next != null) {
            if (prevNode.next.val == val) {
                prevNode.next = prevNode.next.next;
            } else {    // 如果满足删除条件， prev 指针已经移动过了，所以不需要在移动
                prevNode = prevNode.next;
            }

        }
        return dummyHead.next;
    }
}
