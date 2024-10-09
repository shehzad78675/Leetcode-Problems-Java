class Solution {
    public int solve(int grid[][], int i, int j, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }

        if(i < 0 || j < 0){
            return (int) 1e9;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int up = grid[i][j] + solve(grid, i-1, j, dp);
        int left = grid[i][j] + solve(grid, i, j-1, dp);

        return dp[i][j] = Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        return solve(grid, n-1, m-1, dp);
    }
}