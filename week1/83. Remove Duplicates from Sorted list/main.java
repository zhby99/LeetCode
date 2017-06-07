/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
            if(cur == null){
                break;
            }
        }
        return head;
    }
}
