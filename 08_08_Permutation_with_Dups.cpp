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
