class Solution {
    public:
        ListNode * removeDuplicates(ListNode * head) 
	{
            auto * current = head;
            if (current != nullptr) 
	    {
                set <int> duplicateNodes;
                duplicateNodes.insert(current->val);

                while (current->next != nullptr) 
		{
                    if (duplicateNodes.find(current->next->val) != duplicateNodes.end()) 
		    {
                        current->next = current->next->next;
                    } 
		    else 
		    {
                        duplicateNodes.insert(current->next->val);
                        current = current->next;
                    }
                }
            }
            return head;
        }
};
