class Pair{
    int row;
    int col;
    int dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int vis[][] = new int[m][n];
        int dist[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] drow = {1,0,-1,0};
        int[] dcol = {0, -1, 0, 1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dist;

            dist[row][col] = dis;

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                    vis[nrow][ncol] == 0){
                    
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol, dis+1));
                }
            }
        }
        return dist;
    }
}