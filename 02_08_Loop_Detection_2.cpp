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
