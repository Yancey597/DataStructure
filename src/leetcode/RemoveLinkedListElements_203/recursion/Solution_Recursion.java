package leetcode.RemoveLinkedListElements_203.recursion;//import org.junit.Test;

import leetcode.RemoveLinkedListElements_203.ListNode;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution_Recursion
 * @date 2023/12/9-16:22
 * @description use recursion method solve this problem.
 */

public class Solution_Recursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution_Recursion().removeElements(new ListNode(nums), 1));
    }

    public ListNode removeElements(ListNode head, int val) {
        // Identify the base case
//        if head == null, just return null
        if (head == null) {
            return null;
        }
        /*
            Recursive call, break down the problem of remove element from the entire list
            into smaller sub-problems: remove elements from the remaining list after the head.
         */
        /*
            Updating the list: After the recursive call, we should modify the next pointer of current
            head pointing the modified list.
         */
        head.next = removeElements(head.next, val);

        /*
            Returning a modified list, if current node's value equal with target value, we should remove it
            by return current node's next pointer.
         */
        return val == head.val ? head.next : head;
    }
}
