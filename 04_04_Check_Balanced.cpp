
class Solution {
public:
    
    int checkHeight(TreeNode * node)
    {
        if (node == nullptr)
        {
            return 0;
        }
        
        auto leftHeight = checkHeight(node->left);
        auto rightHeight = checkHeight(node->right);
        
        if (leftHeight == -1 or rightHeight == -1)
        {
            return -1;
        }
        
        if (abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }
        
        return 1 + max(leftHeight, rightHeight);
    }

    bool isBalanced(TreeNode* root) {
        
        int returnValue = this->checkHeight(root);
        
        return returnValue == -1 ? false : true;
    }
};
