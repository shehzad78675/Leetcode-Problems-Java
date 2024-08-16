class Solution {
    public void dfs(int ind,  int[][] isConnected, int vis[]){
        vis[ind] = 1;
         for(int i=0; i<isConnected[ind].length; i++){
            if(vis[i] == 0 && isConnected[ind][i] == 1){
                dfs(i, isConnected, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int vis[] = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, isConnected, vis);
            }
        }
        return cnt;
    }
}