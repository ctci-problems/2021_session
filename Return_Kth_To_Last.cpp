class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        auto * dummyHead = new ListNode(0);
        
        auto count = 0;

        for (auto * current = head; current != nullptr; current = current->next)
            count++;
        
        count -= n;

        dummyHead->next = head;
        
        auto * current = dummyHead;
        
        while(count--)
            current = current->next;
        
        current->next = current->next->next;
        
        return dummyHead->next;
    }
};
