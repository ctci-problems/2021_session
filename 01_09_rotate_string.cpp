/** Solution 1 **/
class Solution {
public:
    bool rotateString(string s, string goal) {

        if (s.size() == goal.size())
        {
            for(auto i = 0; i < s.length(); i++)
            {
                s = s.at(s.length() - 1) + s.substr(0, s.length() - 1);

                if(s == goal) 
                  return true;
            }
        }
        return false;
    }
};

/** Solution 2 **/
class Solution {
public:
    bool rotateString(string s, string goal) {

        if (s.size() != goal.size())
            return false;

        s += s;

        return s.find(goal) != -1;
    }
};
