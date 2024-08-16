class Solution {
    public void dfs(int ind,  ArrayList<ArrayList<Integer>> adj, int vis[]){
        vis[ind] = 1;
        for(int it: adj.get(ind)){
            if(vis[it] == 0){
                dfs(it, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int vis[] = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, adj, vis);
            }
        }
        return cnt;
    }
}