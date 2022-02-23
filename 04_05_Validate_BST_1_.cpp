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
