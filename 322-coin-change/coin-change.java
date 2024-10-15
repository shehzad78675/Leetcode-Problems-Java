class Solution {
    public int solve(int ind, int[] coins, int amount, int[][] dp){
        if(ind == 0){
            if(amount%coins[ind] == 0) return amount/coins[ind];
            return (int) 1e9;
        }

        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }

        int notTake = solve(ind-1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount) take = 1 + solve(ind, coins, amount-coins[ind], dp);

        return dp[ind][amount] = Math.min(take, notTake);
    }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int res = solve(n-1, coins, amount, dp);
        return res >= (int) 1e9 ? -1 : res;
    }
}