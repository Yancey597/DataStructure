package leetcode.RemoveLinkedListElements_203.recursion;//import org.junit.Test;

import recursionUtils.Recursion;
import leetcode.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Soluntion_Recursion_test
 * @date 2023/12/9-17:01
 * @description TODO
 */

public class Soluntion_Recursion_test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Soluntion_Recursion_test().removeElements(new ListNode(nums), 1, 0));
    }

    private ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = Recursion.GenerateDepthString(depth);
        System.out.println(depthString + "Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.println(depthString + "Return " + head);
            return null;
        }
        ListNode retnode = removeElements(head.next, val, depth + 1);
        System.out.println(depthString + "After remove " + val + ": " + retnode);
        if (val == head.val) {
            head = retnode;
        } else {
            head.next = retnode;
        }
        System.out.println(depthString + "Return " + head);
        return head;


    }
}
