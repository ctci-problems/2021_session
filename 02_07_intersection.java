public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;

        
        while(currentA != currentB) {
            
            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }
            
            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
            
        }
        
        return currentA;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        Set<ListNode> setOfNodesSeen = new HashSet<>();
        
        while(currentA != null) {
            setOfNodesSeen.add(currentA);
            currentA = currentA.next;
        }
        
        ListNode currentB = headB;
        
        while(currentB != null) {
            if (setOfNodesSeen.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.next;
        }
        
        return null;
    }
}
