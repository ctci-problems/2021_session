/** Solution 1 **/

class Solution {
public:
    
    bool is_palindrome(vector<int> & arr)
    {
        auto s = 0;
        auto e = arr.size() - 1;
        
        while (s < e)
        {
            if (arr[s] != arr[e])
                return false;

            s++;
            e--;
        }

        return true;
    }
    
    bool isPalindrome(ListNode* head) {
 
        vector<int> newList;
        
        for(auto current = head; current != nullptr; current = current->next)
            newList.push_back(current->val);
    
        return is_palindrome(newList);   
    }
};

/** Solution 2 **/

class Solution {
public:

    bool isPalindrome(ListNode* head) {
        
        auto reverseList = [&] (ListNode * node)
        {
            auto * current = node;
            ListNode * prev = nullptr;
            
            while(current != nullptr)
            {
                auto * next = current->next;
                
                current->next = prev;
                prev = current;
                
                current = next;
            }
            
            return prev;
        };

        auto * dummyHead = new ListNode;
        dummyHead->next = head;

        auto * fast = dummyHead;
        auto * slow = dummyHead;
        
        while(fast != nullptr and fast->next != nullptr)
        {
            fast = fast->next->next;
            slow = slow->next;
        }

        auto * secondList = reverseList(slow);
        auto * firstList = dummyHead->next;
        
        while (secondList != nullptr and firstList != nullptr)
        {
            if (firstList->val != secondList->val)
                return false;

            firstList = firstList->next;
            secondList = secondList->next;
        }
        
        return true;
    }
