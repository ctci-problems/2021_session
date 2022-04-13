class Solution {
public:
    
    bool isEqual(TreeNode* root, TreeNode* subRoot)
    {
        if ((root == nullptr) and (subRoot == nullptr))
            return true;

        else if (root == nullptr)
            return false;

        else if (subRoot == nullptr)
            return false;

        if (root->val != subRoot->val)
            return false;

        return (this->isEqual(root->left, subRoot->left)) and (this->isEqual(root->right, subRoot->right));
    }
    
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        
        if (root == nullptr)
            return false;
    
        if ((root->val == subRoot->val) and (this->isEqual(root, subRoot)))
            return true;
            
        return (this->isSubtree(root->right, subRoot)) or (this->isSubtree(root->left, subRoot)); 
    }
};
