class Solution {
public:
    Node* inorderSuccessor(Node* node) {

        auto val = node->val;
        if (node->right)
        {
            node = node->right;

            while(node->left != nullptr)
                node = node->left;
    
            return node;
        }
        else 
        {
            while (node->parent != nullptr)
            {
                if (node->parent->val > val)
                    return node->parent;

                node = node->parent;
            }

            return node->parent;
        }            
    }
};
