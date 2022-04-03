class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        auto n = nums.size();
        auto pow = 1 << n;

        vector<vector<int>>subSets(1, vector<int>());
        for(auto i = 1; i < pow; i++) {
            vector<int> currentSet;
            for(auto j = 0; j < nums.size(); j++) {
                if (((i >> j) & 1) > 0)
                    currentSet.push_back(nums[j]);
            }
            subSets.push_back(currentSet);
        }        
        return subSets;
    }
};
