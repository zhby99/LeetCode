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
        if(head == null) return null;
        ListNode start = new ListNode(-1);
        ListNode prev = start;
        prev.next = head;
        ListNode cur = head;
        int counter = 0;
        while(cur.next != null){
            ListNode trial = cur.next;
            while(trial.val == cur.val){
                if(trial.next!=null){
                    trial=trial.next;
                    counter += 1;
                }
                else{
                    prev.next = null;
                    return start.next;
                }
            }


            if(counter==0){
                prev.next = cur;
                prev = cur;
            }
            else{
                prev.next = trial;
            }
            counter = 0;
            cur = trial;
            if(cur == null){
                break;
            }
        }
        return start.next;
    }
}
