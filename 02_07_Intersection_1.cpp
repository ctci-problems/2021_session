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
