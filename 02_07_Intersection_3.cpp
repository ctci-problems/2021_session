class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
 
        auto * A = headA;
        auto * B = headB;
        
        auto countA = 0;
        auto countB = 0;
        
        while (A != nullptr)
        {
            A = A->next;
            countA++;
        }
        
        while(B != nullptr)
        {
            B = B->next;
            countB++;
        }
        
        
        if (countA < countB)
        {
            while (countA < countB)
            {
                headB = headB->next;
                countB--;
            }
        }
        else if (countA > countB)
        {
            while (countA > countB)
            {
                headA = headA->next;
                countA--;
            }
        }
        
        while (headA != nullptr && headB != nullptr)
        {
            if (headA == headB)
            {
                return headA;
            }
            
            headB = headB->next;
            headA = headA->next;            
        }
    }
};
