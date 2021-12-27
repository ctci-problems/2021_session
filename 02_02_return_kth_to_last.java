class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummyHead = new ListNode(-1, head);
        ListNode leader = dummyHead;
        
        int count = 0;
        
        while(leader != null) {
            leader = leader.next;
            count++;
            if (count == n) {
                break;
            }
        }
        
        ListNode follower = dummyHead;
        
        while (leader.next != null) {
            leader = leader.next;
            follower = follower.next;
        }
        
        follower.next = follower.next.next;
        
        return dummyHead.next;
    }
}
