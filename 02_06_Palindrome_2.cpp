class Solution {
public:

    bool isPalindrome(ListNode* head) {
        
        auto reverseList = [&] (ListNode * node)
        {
            auto * current = node;
            ListNode * prev = nullptr;
            
            while(current != nullptr)
            {
                auto * next = current->next;
                
                current->next = prev;
                prev = current;
                
                current = next;
            }
            
            return prev;
        };

        auto * dummyHead = new ListNode;
        dummyHead->next = head;

        auto * fast = dummyHead;
        auto * slow = dummyHead;
        
        while(fast != nullptr and fast->next != nullptr)
        {
            fast = fast->next->next;
            slow = slow->next;
        }

        auto * secondList = reverseList(slow);
        auto * firstList = dummyHead->next;
        
        while (secondList != nullptr and firstList != nullptr)
        {
            if (firstList->val != secondList->val)
                return false;

            firstList = firstList->next;
            secondList = secondList->next;
        }
        
        return true;
    }
};
