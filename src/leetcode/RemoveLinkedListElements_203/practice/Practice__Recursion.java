package leetcode.RemoveLinkedListElements_203.practice;//import org.junit.Test;


import leetcode.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Practice_Recursion
 * @date 2023/12/16-20:30
 * @description TODO
 */

public class Practice__Recursion {

    public static ListNode removeLinkedListElements(ListNode head, int target) {
        if (head == null) {
            return head;
        }

        head.next = removeLinkedListElements(head.next, target);
        return target == head.val ? head.next : head;
    }

}
