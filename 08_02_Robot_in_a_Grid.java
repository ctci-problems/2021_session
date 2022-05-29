class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        
        
        for (int i = 0;i < obstacleGrid.length;i++) {
            for (int j = 0;j < obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 0 && obstacleGrid[i - 1][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                
                if (j != 0 && obstacleGrid[i][j - 1] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
