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
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        if(grid[0][0] == 0 && grid.length == 1 && grid[0].length == 1){
            return 1;
        }
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        q.add(new Pair(0, 0, 1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dist;

            for(int i=-1; i<=1; i++){
                for(int j=-1; j<=1; j++){
                    int nrow = row + i;
                    int ncol = col + j;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == 0){
                        
                        if(nrow == n-1 && ncol == m-1){
                            return dis+1;
                        }
                        q.add(new Pair(nrow, ncol, dis+1));
                        grid[nrow][ncol] = 1;
                    }
                }
            }
        }
        return -1;
    }
}