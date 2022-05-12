/** Solution 1 **/

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

/** Solution 2 **/

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {

        auto * oneStep = head;
        auto * twoStep = head;

        while (twoStep != nullptr and twoStep->next != nullptr)
        {
            twoStep = twoStep->next->next;
            oneStep = oneStep->next;

            if (oneStep == twoStep)
            {
                auto * current = head;                
                while(current != oneStep)
                {
                    current = current->next;
                    oneStep = oneStep->next;
                }
                return current;
            }
        }

        return nullptr;
    }
};
