class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {

        auto * dummyHead = new ListNode;
        dummyHead->next = head;
        
        auto * fast = dummyHead;
        auto * slow = dummyHead;
        
        for(auto i = 0; i < n; i++)
            fast = fast->next;
        
        while(fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next;
        }
        
        slow->next = slow->next->next;
        
        return dummyHead->next;
    }
};
