class Solution {
    public void dfs(int row, int col, int grid[][], int vis[][], int[] drow, int[] dcol){
        vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                
                dfs(nrow, ncol, grid, vis, drow, dcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        int drow[] = {1,0,-1,0};
        int dcol[] = {0, -1, 0, 1};

        for(int i=0; i<m; i++){
            if(grid[0][i] == 1 && vis[0][i] == 0){
                dfs(0, i, grid, vis, drow, dcol);
            }

            if(grid[n-1][i] == 1 && vis[n-1][i] == 0){
                dfs(n-1, i, grid, vis, drow, dcol);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, grid, vis, drow, dcol);
            }

            if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(i, m-1, grid, vis, drow, dcol);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}