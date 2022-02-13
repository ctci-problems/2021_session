class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> totalLevel;      
    
        queue<TreeNode *> breathQueue;
        if (root) breathQueue.push(root);
    
        while(breathQueue.empty() != true)
        {
            auto size = breathQueue.size();
            vector<int> currentLevel;
            while (size > 0)
            {
                auto * currentNode = breathQueue.front();
                breathQueue.pop();
                
                currentLevel.push_back(currentNode->val);
                
                if (currentNode->left) breathQueue.push(currentNode->left);
                if (currentNode->right) breathQueue.push(currentNode->right);
                
                size--;
            }
            totalLevel.push_back(currentLevel);
        }
    }
};
