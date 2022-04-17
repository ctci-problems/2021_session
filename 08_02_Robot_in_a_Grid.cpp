class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {        
        // grid[i][j] =  obstacle ? grid[i - 1][j] + grid[i][j - 1] : 0;
        auto n = obstacleGrid.size();
        auto m = obstacleGrid[0].size();
        vector<vector<int>> grid(n,vector<int>(m));
        grid[0][0] = 1;
        for (auto i = 0; i < n; i++) {
            for (auto j = 0; j < m; j++) {        
                if (obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
 
                if (j > 0) {
                    grid[i][j] += grid[i][j - 1];         
                }
            }
        }
        return grid[n - 1][m - 1];
    }
};
