import java.util.Stack;

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

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        boolean palindrome = true;
        Stack<Integer> stack = new Stack<Integer>();
        // Traverse the linked list and add its elements
        // to the stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        // Iterate the linked list again and
        // check by each element with the stack
        while (head != null) {
            int i = stack.pop();
            if (head.val == i)
                palindrome = true;
            else {
                palindrome = false;
                break;
            }
            head = head.next;
        }
        return palindrome;

    }
}