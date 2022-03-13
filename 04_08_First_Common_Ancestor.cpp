class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if (root == nullptr)
            return root;
        
        if ((root == p) or (root == q))
            return root;
        
        auto * left = lowestCommonAncestor(root->left, p, q);
        auto * right = lowestCommonAncestor(root->right, p, q);

        if ((left != nullptr) and (right != nullptr))
            return root;

        else if (left != nullptr)
            return left;

        else if (right != nullptr)
            return right;

        else
            return nullptr;
    }
};
