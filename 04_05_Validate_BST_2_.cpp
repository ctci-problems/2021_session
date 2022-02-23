class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        vector<int> inOrderTraversal;
        stack<TreeNode *> dfsStack;
        
        auto * current = root;
        while (!dfsStack.empty() || current != nullptr)
        {
            while (current != nullptr)
            {
                dfsStack.push(current);
                current = current->left;
            }
            
            current = dfsStack.top(); dfsStack.pop();
            
            inOrderTraversal.push_back(current->val);
            
            current = current->right;
        }
        
        for(auto i = 1; i < inOrderTraversal.size(); i++)
        {
            if (inOrderTraversal[i] <= inOrderTraversal[i - 1])
                return false;
        }

        return true;
    }
};
