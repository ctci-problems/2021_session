/** Solution 1 **/

class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        set<ListNode *> listA;
        
        while (headA != nullptr)
        {
            listA.insert(headA);
            headA = headA->next;
        }

        while(headB != nullptr)
        {
            if (listA.find(headB) != listA.end())            
                return headB;
            headB = headB->next;
        }

        return nullptr;
    }
};

/** Solution 2 **/

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

/** Solution 3 **/

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
