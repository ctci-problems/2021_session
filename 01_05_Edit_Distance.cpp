class Solution {
public:

    int min (int a, int b, int c)
    {
        if (a < b) return a < c ? a : c;
        else return b < c ? b : c;
    }
    int minDistance(string word1, string word2) {

        int m = word1.size() + 1;
        int n = word2.size() + 1;
        vector<vector<int>> memo(m, vector<int>(n + 1, 0));
        
        for (int i = 0; i < n; i++)
            memo[0][i] = i;

        for (int i = 0; i < m; i++)
            memo[i][0] = i;

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                // Case #1 - letters match
                if (word1[i - 1] == word2[j - 1])
                {
                    memo[i][j] = memo[i - 1][j - 1];
                }
                // Case #2: Letters do not match, so we omit a letter or replace from word1 and word2
                else
                {
                    memo[i][j] = min(memo[i - 1][j], memo[i][j - 1], memo[i - 1][j - 1]) + 1;
                }
            }
        }

        return memo[word1.length()][word2.length()];
    }
}
