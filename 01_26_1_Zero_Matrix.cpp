class Solution {
  public:
   void setZeroes(vector<vector<int>>& matrix) {
        
        vector<bool> rows(matrix.size(), 0);
        vector<bool> cols(matrix[0].size(), 0);
        
        for(auto i = 0; i < matrix.size(); i++)
        { 
            for(auto j = 0; j < matrix[0].size(); j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for(auto i = 0; i < matrix.size(); i++)
            if(rows[i])
                for(auto j = 0; j < matrix[0].size(); j++)
                    matrix[i][j] = 0;
        
        for(auto j = 0; j < matrix[0].size(); j++)
            if(cols[j])
                for(auto i = 0; i < matrix.size(); i++)
                    matrix[i][j] = 0;
    }
};
