class Solution {
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        
        if (p->right == nullptr)
        {
            TreeNode * inOrderSuccessor = nullptr;
            TreeNode * current = root;
            
            while (current != p)
            {
                if (p->val < current->val)
                {
                    inOrderSuccessor = current;
                    current = current->left;
                }
                else
                {
                    current = current->right;
                }
            }
            return inOrderSuccessor;
        }
        else
        {
            auto * inOrderSuccessor = p->right;
            
            while (inOrderSuccessor->left != nullptr)
                 inOrderSuccessor = inOrderSuccessor->left;
            
            return inOrderSuccessor;
        }
    }
};
