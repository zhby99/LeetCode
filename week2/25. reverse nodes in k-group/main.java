/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class ListPair{
        public ListNode n1;
        public ListNode n2;
        public ListPair(ListNode v1, ListNode v2){
            n1 = v1;
            n2 = v2;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode cur = head;
        int num = 0;
        boolean set = false;
        while(cur != null){
            num++;
            cur = cur.next;
        }
        cur = head;
        int numGroup = num / k;
        ListNode prev = null;
        for(int i = 0; i < numGroup; i++){
            ListPair pair = reverse(cur, k);
            if(prev != null){
                prev.next = pair.n1;
            }
            prev = pair.n2;
            cur = prev.next;
            if(!set){
                head = pair.n1;
                set = true;
            }
        }
        return head;
    }

    private ListPair reverse(ListNode head, int k){
        ListNode tail = head;
        ListNode next = head.next;
    	head.next = null;
    	int i = 1;
        while(next != null){
        	ListNode temp = next.next;
        	next.next = head;
        	head = next;
        	next = temp;
        	i++;
        	if(i == k){
        	    break;
        	}
        }
        tail.next = next;
    	return new ListPair(head, tail);
    }


}
