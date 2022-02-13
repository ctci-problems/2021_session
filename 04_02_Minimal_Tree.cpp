class Solution {
public:
    TreeNode* createBST(vector<int> & arr, int start, int end)
    {
        if (start > end)
            return nullptr;

        int mid = start + (end - start) / 2;

        auto * current = new TreeNode(arr[mid]);

        current->left = createBST(arr, start, mid - 1);
        current->right = createBST(arr, mid + 1, end);

        return current;
    }

    TreeNode* sortedArrayToBST(vector<int>& nums) {    
        auto n = nums.size() - 1;
        return this->createBST(nums, 0, n);
    }
};
