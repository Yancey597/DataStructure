package leetcode.LinkedList.RemoveLinkedListElements_203.forLoop;
//import org.junit.Test;

import leetcode.LinkedList.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2023/12/9-14:31
 * @description leetcode 203 题 java 实现
 * 此版本为不带虚拟头结点版本
 */
//0.15
class Solution {
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
        while (head != null && head.val == val) { // 处理表中第一个元素 为待删除结点的情况。
//            ListNode delNode = head;
            head = head.next;
//            delNode.next = null;
        }

        ListNode currNode = head;
        if (currNode != null) {
            return null;
        }

        while (currNode.next != null) {// 处理后续结点为待删除结点的情况
            if (currNode.next.val == val) {
                currNode.next = currNode.next.next;
//                ListNode delNode = currNode.next;
//                currNode.next = delNode.next;
//                delNode.next = null;
            } else {
                currNode = currNode.next;
            }
        }


        return head;
    }
}