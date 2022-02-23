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
