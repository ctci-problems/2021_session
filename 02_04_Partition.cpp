class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        
        auto * lesserList = new ListNode;
        auto * greaterList = new ListNode;
        
        auto * lesserListHead = lesserList;
        auto * greaterListHead = greaterList;
        
        for(auto * current = head; current != nullptr; current = current->next)
        {
            if (current->val < x)
            {
                lesserList->next = current;
                lesserList = lesserList->next;
            }
            else
            {
                greaterList->next = current;
                greaterList = greaterList->next;
            }    
        }

        lesserList->next = greaterListHead->next;
        greaterList->next = nullptr;
        
        return lesserListHead->next;

    }
};
