class Solution {
    public int solve(int[][] grid, int i, int j, int[][] dp){
        if(i < 0 || j < 0 || grid[i][j] == 1){
            return 0;
        }

        if(i == 0 && j == 0){
            return 1;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int up = solve(grid, i-1, j, dp);
        int left = solve(grid, i, j-1, dp);

        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        return solve(obstacleGrid, n-1, m-1, dp);
    }
}