/** Solution 1**/
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

/** Solution 2 **/
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
