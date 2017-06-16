/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        if(head != null && head.next!=null){
            head = head.next;
        }
        ListNode prev = null;
        while(current != null){
            if(current.next == null){
                return head;
            }
            ListNode temp = current.next.next;
            current.next.next = current;
            if(prev!=null){
                prev.next = current.next;
            }
            current.next = temp;
            prev = current;
            current = temp;
        }
        return head;
    }
}
