class Solution {
public:
    ListNode * deleteDuplicatesUnsorted(ListNode * head) {

        auto dummyHead = new ListNode(0); dummyHead->next = head;
        auto * p1 = head, * p2 = dummyHead;

        map < int, int > duplicateNodes;

        if ((p1 != nullptr) && (p1->next != nullptr))
        {
            while(p1 != nullptr)
            {
                duplicateNodes[p1 -> val]++;
                p1 = p1->next;
            }
            
            for(p1 = head; p1 != nullptr; p1 = p1->next) 
            {                    
                if (duplicateNodes[p1->val] == 1) 
                {
                    p2 -> next = p1;
                    p2 = p2->next;
                }
            }
            
            p2->next = nullptr;
            
            return dummyHead->next;
        }

        else return head;
    }
};
