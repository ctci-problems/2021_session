class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {

        auto * A = headA;
        auto * B = headB;
        
        for (auto iterations = 0; iterations < 2;)
        {    
            A = A->next;
            B = B->next;
            
            if (A == nullptr)
            {
                A = headB;
                iterations++;
            }
            
            if (B == nullptr)
            {
                B = headA;
                iterations++;
            }
        }
        
        while(A != nullptr and B != nullptr)
        {
            if (A == B)
                return A;
            
            A = A->next;
            B = B->next;
        }
                
        return nullptr;
    }
};
