class Solution {
public:
    ListNode *detectCycle(ListNode *head) {

        set<ListNode *> visitedNodes;
        
        while (head != nullptr)
        {
            if (visitedNodes.find(head) != visitedNodes.end())
            {
                return head;
            }
  
            visitedNodes.insert(head);
            head = head->next;
        }

        return nullptr;
    }
};
