lass Solution:
    def deleteDuplicatesUnsorted(self, head: ListNode) -> ListNode:
        sett = {}
        curr = head
        while curr:
            if curr.val not in sett:
                sett[curr.val]=1
            else:
                sett[curr.val]+=1
            curr = curr.next
        
        dummy = ListNode()
        dummy.next = head
        prev = dummy
        rot = head
        
        while rot:
            if sett[rot.val]>1:
                prev.next = rot.next
            else:
                prev = rot
            rot = rot.next
                
        return dummy.next
