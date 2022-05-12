/** Solution 1 **/

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        
        auto * newHead = new ListNode;
        auto * current = newHead;
        
        auto carry = 0;
        
        while (l1 != nullptr || l2 != nullptr)
        {
            auto sum = carry;
            
            ListNode * currentList = nullptr;
            
            if (l1 != nullptr)
            {
                sum += l1->val;
                l1 = l1->next;                
            }            
            
            if (l2 != nullptr)
            {
                sum += l2->val;
                l2 = l2->next;
            }
                        
            carry = sum / 10;
            sum %= 10;
            
            current->next = new ListNode(sum);
            current = current->next;
        }
        
        if (carry)
            current->next = new ListNode(carry);

        return newHead->next;
    }
};

/** Solution 2 **/

class Solution {
public:

    ListNode * reverse(ListNode * head)
    {
        if (head == nullptr)
            return head;

        ListNode * next = nullptr;
        ListNode * prev = nullptr;
        ListNode * current = head;
        
        while (current != nullptr)
        {
            next = current->next;
        
            current->next = prev;
    
            prev = current;
            
            current = next;
        }

        return prev;
    }
    
    
    /* submission to addTwoNumbers */
    ListNode * addTwoNumbersOne(ListNode* l1, ListNode* l2)  
    {
        auto * newHead = new ListNode;
        auto * current = newHead;
        
        auto carry = 0;
        
        while (l1 != nullptr || l2 != nullptr)
        {
            auto sum = carry;
            
            ListNode * currentList = nullptr;
            
            if (l1 != nullptr)
            {
                sum += l1->val;
                l1 = l1->next;                
            }            
            
            if (l2 != nullptr)
            {
                sum += l2->val;
                l2 = l2->next;
            }
                        
            carry = sum / 10;
            sum %= 10;
            
            current->next = new ListNode(sum);
            current = current->next;
        }
        
        if (carry)
            current->next = new ListNode(carry);

        return newHead->next;
    }
    
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

        l1 = this->reverse(l1);
        l2 = this->reverse(l2);
        
        auto * result = this->addTwoNumbersOne(l1,l2);
        
        return this->reverse(result);
    }
};
