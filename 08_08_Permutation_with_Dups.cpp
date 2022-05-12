// Solution 1
class Solution {
public:
    void permutations_helper(vector<vector<int>> & permutations, vector<int> & nums, vector<int> current_list, unordered_map<int, int> frequencies) {
        if (current_list.size() == nums.size()) {
            permutations.push_back(current_list);
        } else {
            for(auto [num, frequency] : frequencies) {
                if (frequency > 0) {
                    
                    frequencies[num]--;
                    current_list.push_back(num);
                    
                    permutations_helper(permutations, nums, current_list, frequencies);
                    
                    frequencies[num]++;
                    current_list.pop_back();                  
                }
            }
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> permutations;
        unordered_map<int, int> frequencies;

        for (auto num : nums)
            frequencies[num]++;

        permutations_helper(permutations, nums, vector<int>(), frequencies);
        return permutations;
    }
};

// Solution 2

class Solution {
public:
    
    void permutations_helper(vector<vector<int>> & permutations, vector<int> & nums, int current_index, set<vector<int>> & visited) {
        if (current_index == nums.size()) {
            if (visited.find(nums) == visited.end()) {
                permutations.push_back(nums);
                visited.insert(nums);   
            }
        } else {
            for(int i = current_index; i < nums.size(); i++) {
                std::swap(nums[current_index], nums[i]);
                permutations_helper(permutations, nums, current_index + 1, visited);
                std::swap(nums[current_index], nums[i]);
            }
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> permutations;
        set<vector<int>> seen;

        permutations_helper(permutations, nums, 0, seen);
        return permutations;
    }
};
