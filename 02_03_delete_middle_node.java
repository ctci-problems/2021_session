class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        
        
       while(fast != null) {
           fast = fast.next;
           
           // If the length is even
           if (fast == null) {
               slow.next = slow.next.next;
               break;
           }
           fast = fast.next;
           // If the length is odd
           if (fast == null) {
               slow.next = slow.next.next;
               break;
           }
           slow = slow.next;
       }
        
        return dummyHead.next;
    }
}
