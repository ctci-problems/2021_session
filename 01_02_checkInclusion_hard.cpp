class Solution {
public:
    bool checkInclusion(string s1, string s2) {

        if (s1.length() <= s2.length())
        {
            map<char,int> s1Window;
            map<char,int> s2Window;

            for (auto i = 0; i < s1.length(); i++)
            {
                s2Window[s2[i]]++;
                s1Window[s1[i]]++;
            }

            if (s1Window == s2Window) 
                return true;

            for (auto i = s1.length(); i <= s2.length(); i++)
            {
                s2Window[s2[i - s1.length()]]--; 
                s2Window[s2[i]]++;

                if (s2Window[s2[i - s1.length()]] == 0) 
                    s2Window.erase(s2[i - s1.length()]);

                if (s2Window == s1Window)
                    return true;
            }
        }

        return false;
    }
};
