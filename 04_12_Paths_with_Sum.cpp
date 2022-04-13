class Solution {

public:
    void pathSum(TreeNode* root, bool addToSum, long int targetSum, int & currentCount) {
        if (root == nullptr) {
            return;
        }

        if (root->val == targetSum) {
            currentCount++;
        }

        if (addToSum == false) {
            pathSum(root->left, false, targetSum, currentCount);
            pathSum(root->right, false, targetSum, currentCount);
        }

        pathSum(root->left, true, targetSum - root->val, currentCount);
        pathSum(root->right, true, targetSum - root->val, currentCount);
    }

    int pathSum(TreeNode* root, int targetSum) {
        int totalSum = 0;
        this->pathSum(root, false, targetSum, totalSum);
        return totalSum;
    }
};
