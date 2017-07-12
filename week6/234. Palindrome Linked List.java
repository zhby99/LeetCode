public boolean isPalindrome(ListNode head) {
    ListNode left = head, right = head;
    while (left != null && left.next != null) {
        left = left.next.next;
        right = right.next;
    }
    if (left != null) { // odd nodes: let right half smaller
        right = right.next;
    }
    right = reverse(right);
    left = head;

    while (right != null) {
        if (left.val != right.val) {
            return false;
        }
        left = left.next;
        right = right.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
    while(current != null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}
