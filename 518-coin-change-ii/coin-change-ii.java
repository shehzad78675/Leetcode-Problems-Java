class Solution {
    public int solve(int ind, int coins[], int amount, int dp[][]){
        if(ind == 0){
            if(amount%coins[0] == 0){
                return 1;
            }
            return 0;
        }

        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }

        int notTake = solve(ind-1, coins, amount, dp);
        int take = 0;
        if(coins[ind] <= amount) take = solve(ind, coins, amount-coins[ind], dp);

        return dp[ind][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(n-1, coins, amount, dp);
    }
}