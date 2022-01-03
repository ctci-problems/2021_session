/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        
        
        ListNode prev = new ListNode();
        prev.next = head;
        
        ListNode lastLessThan = dummyHead;
        ListNode currentNode = head;
        
        
        while(currentNode != null) {
            ListNode next = currentNode.next;
            
            if (currentNode.val < x && currentNode == lastLessThan.next) {
                lastLessThan = currentNode;
                prev = prev.next;
                currentNode = currentNode.next;
            } else if (currentNode.val < x) {
                ListNode temp = lastLessThan.next;
                lastLessThan.next = currentNode;
                currentNode.next = temp;
    
                lastLessThan = currentNode;
                
                prev.next = next;
                currentNode = next;
            } else {
                prev = prev.next;
                currentNode = currentNode.next;
            }
        }
        
        return dummyHead.next;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstListPointer = new ListNode();
        ListNode secondListPointer = new ListNode();
        
        ListNode firstHeadTemp = firstListPointer;
        ListNode secondHeadTemp = secondListPointer;
        
        ListNode currentNode = head;
        
        while(currentNode != null) {
            if (currentNode.val < x) {
                firstListPointer.next = currentNode;
                firstListPointer = firstListPointer.next;
            } else {
                secondListPointer.next = currentNode;
                secondListPointer = secondListPointer.next;
            }
            currentNode = currentNode.next;
        }
        secondListPointer.next = null;
        firstListPointer.next = secondHeadTemp.next;
        
        
        return firstHeadTemp.next;
    }
}

