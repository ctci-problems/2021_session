class Solution {
public:

    bool removeLetterDistance(string & short_str, string & long_str)
    {
        auto short_str_idx = 0;
        auto long_str_idx = 0;

        while (long_str_idx < long_str.length() && short_str_idx < short_str.length())
        {
            if(short_str[short_str_idx] == long_str[long_str_idx])
            {
                short_str_idx++;
            }
            long_str_idx++;
        }
        return (long_str_idx == long_str.length() - 1) || (short_str_idx == long_str_idx - 1);
    }

    bool replaceLetterDistance(string & s, string & t)
    {
        if (s.length() != t.length())
            return false;

        bool replaceOneLetter = false;
        for (auto i = 0; i < t.length(); i++)
        {
            if (s[i] != t[i])
            {
                if (replaceOneLetter)
                {
                    return false;
                }
                replaceOneLetter = true;
            }
        }
        return replaceOneLetter;
    }

    bool isOneEditDistance(string &s, string &t) {

        if (s.length() < t.length())
            return (replaceLetterDistance(s, t)) || (removeLetterDistance(s, t));
        else
            return (replaceLetterDistance(s, t)) || (removeLetterDistance(t, s));
    }
};
