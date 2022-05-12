/** Solution 1 **/
class Solution {
public:
    
    void inOrderTraversal(TreeNode * root, vector<int> & traversal)
    {
        if (root != nullptr)
        {
            inOrderTraversal(root->left, traversal);
            traversal.push_back(root->val);
            inOrderTraversal(root->right, traversal);
        }
    }

    bool isValidBST(TreeNode* root) {
        
        vector<int> dfs;
        this->inOrderTraversal(root, dfs);
        
        for(auto i = 1; i < dfs.size(); i++)
            if (dfs[i] <= dfs[i - 1])
                return false;

        return true;
    }
};
/** Solution 2 **/
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
