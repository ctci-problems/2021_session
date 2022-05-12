/** Solution 1 **/

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> return_array;
        permutation_helper(nums, 0, return_array);
        return return_array;
    }

    void permutation_helper(vector<int> & nums, int current_idx, vector<vector<int>> & result) {
        if (current_idx == nums.size()) {
            result.push_back(nums);
        } else {
            for (auto i = current_idx; i < nums.size(); i++) {
                swap(nums[current_idx], nums[i]);
                permutation_helper(nums, current_idx + 1, result);
                swap(nums[current_idx], nums[i]);                
            }
        }
    }
};

/** Solution 2 **/

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> return_array;
        permutation_helper(vector<int>(), nums, return_array);
        return return_array;
    }

    void permutation_helper(vector<int> current_set, vector<int> nums, vector<vector<int>> & result) {
        if (current_set.size() == nums.size()) {
            result.push_back(current_set);
        } else {
            for (auto i = 0; i < nums.size(); i++) {
                if (find(current_set.begin(), current_set.end(), nums[i]) == current_set.end()) {
                    current_set.push_back(nums[i]);
                    permutation_helper(current_set, nums, result);
                    current_set.pop_back();
                }
            }
        }
    }
};
