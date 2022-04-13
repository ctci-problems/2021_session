class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        vector<vector<string>> anagramGroups;
        map<string, int> stringToGroupIndex;

        for (string & str : strs)
        {
            string key = str;
            sort(key.begin(), key.end());

            if (stringToGroupIndex.find(key) != stringToGroupIndex.end())
                anagramGroups[stringToGroupIndex[key]].push_back(str);
            
            else
            {
                stringToGroupIndex[key] = stringToGroupIndex.size();
                anagramGroups.push_back(vector<string>(1, str));
            }
        }
        
        return anagramGroups;
    }
};
